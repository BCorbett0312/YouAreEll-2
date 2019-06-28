
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.*;



import okhttp3.*;
import java.io.IOException;




public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");



    public YouAreEll (MessageController m, IdController j) {
        // used j because i seems awkward
        this.msgCtrl = m;
        this.idCtrl = j;
    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(new MessageController(), new IdController());
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }


    public String MakeURLCall(String mainurl, String method, String jpayload) {
        TransactionController transCont = new TransactionController(mainurl, method, jpayload, msgCtrl, idCtrl);

        if(method.equals("GET")) {
            transCont.getToController();

        }
//           Request request = new Request.Builder()
//                   .url(server)
//                   .build();
//           try (Response response = client.newCall(request).execute()) {
//               String test = response.body().string();
//               List<Id> results = objectMapper.readValue(response,
//                       new TypeReference<List<Id>>() {} );
//               List<Id> idList = objectMapper.readValue(test, new TypeReference<List<Id>>(){});
//
//               return test;
//           }catch (IOException e){
//               e.printStackTrace();
//           }
//        }


        else if(method.equals("POST")){
            try {
                transCont.PostResponse();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            RequestBody body = RequestBody.create(JSON, jpayload);
//            Request request = new Request.Builder()
//                    .url(server)
//                    .post(body)
//                    .build();
//                try(Response response = client.newCall(request).execute()){
//                    return response.body().string();
//                }catch (IOException e){
//                    e.printStackTrace();
//            }
        }

        else if(method.equals("PUT")){
            try {
                transCont.changeNameToGitId();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "Data";
    }


}
