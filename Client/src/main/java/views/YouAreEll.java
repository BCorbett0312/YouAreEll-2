package views;




import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.*;
import jdk.internal.org.objectweb.asm.TypeReference;
import models.Id;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class YouAreEll {

    private MessageController msgCtrl;
    private IdController idCtrl;
    private OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private ObjectMapper objectMapper = new ObjectMapper();


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
               //idCtrl = objectMapper.readValue(response.body().string(), idCtrl.getClass());
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
