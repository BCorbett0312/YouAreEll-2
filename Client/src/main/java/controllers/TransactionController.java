package controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Id;
import models.Message;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TransactionController {

    private String rootURL = "http://zipcode.rocks:8085";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    ObjectMapper mapper = new ObjectMapper();
    private String responseBody;
    private MessageController msgCtrl;
    private IdController idCtrl;
    private String mainUrl;
    private String method;
    private String jpayload;

    public TransactionController(String mainUrl, String method, String jpayload, MessageController msgCtrl, IdController idCtrl) {
        this.mainUrl = mainUrl;
        this.method = method;
        this.jpayload = jpayload;
        this.msgCtrl = msgCtrl;
        this.idCtrl = idCtrl;

    }

    private String buildURL(){
        return rootURL + mainUrl;
    }

    public void setJsonResponse(){
        Request request = new Request.Builder()
                .url(buildURL())
                .build();
        try(Response response = client.newCall(request).execute()){
            this.responseBody = response.body().string();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getToController(){
        if(mainUrl.contains("/ids") && mainUrl.contains("/messages")) {
            getToMessages();
        }

        else if(mainUrl.contains("/ids") && mainUrl.length()== 5){
                getToIds();
            }
        else if(mainUrl.contains("/messages") && mainUrl.length()== 8){
                getToMessages();
            }
        else if(mainUrl.contains("/ids") && mainUrl.contains("/from")){
            getToMessages();
        }
        }



    private void getToIds (){
        setJsonResponse();
        try{
            idCtrl.setiDList(mapper.readValue(responseBody, new TypeReference<List<Id>>(){}));
            idCtrl.printList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void getToMessages(){
        setJsonResponse();
        try{
            msgCtrl.setMessageSeen(mapper.readValue(responseBody, new TypeReference<HashSet<Message>>(){}));
            msgCtrl.printMessages();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public String PostResponse() throws IOException {
        RequestBody body = RequestBody.create(JSON, jpayload);

        Request request = new Request.Builder()
                .url(buildURL())
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public void changeNameToGitId() throws IOException {

        RequestBody body = RequestBody.create(JSON, jpayload);
        Request request = new Request.Builder()
                .url(buildURL())
                .put(body)
                .build();
        Response response = client.newCall(request).execute();
    }








}
