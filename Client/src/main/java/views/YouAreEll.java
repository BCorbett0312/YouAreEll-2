package views;



import com.fasterxml.jackson.databind.util.JSONPObject;
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

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String post_ids(){return MakeURLCall("/ids", "POST", "");}

    public String put_ids(){ return MakeURLCall("/ids", "PUT", "");}

    public String get_myIdMessages(String id){return MakeURLCall ("/ids/:mygithubid/messages", "GET", "");}

    public String get_myMessagesSequence(){return MakeURLCall("/ids/:mygithubid/messages/:sequence", "GET", "");}

    public String get_messagesFromFriend(){ return MakeURLCall("/ids/:mygithubid/from/:friendgithubid", "GET", "");}

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        String server = "http://zipcode.rocks:8085" + mainurl;

        if(method.equals("GET")) {
           Request request = new Request.Builder()
                   .url(server)
                   .build();
           try (Response response = client.newCall(request).execute()) {

               return response.body().string();
           }catch (IOException e){
               e.printStackTrace();
           }
        }


        else if(method.equals("POST")){
            RequestBody body = RequestBody.create(JSON, jpayload);
            Request request = new Request.Builder()
                    .url(server)
                    .post(body)
                    .build();
                try(Response response = client.newCall(request).execute()){
                    return response.body().string();
                }catch (IOException e){
                    e.printStackTrace();
            }
        }


        return "nada";
    }
}
