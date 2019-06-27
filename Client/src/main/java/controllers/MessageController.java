package controllers;

import java.util.ArrayList;
import java.util.HashSet;

import models.Id;
import models.Message;

public class MessageController {
    private ArrayList response = new ArrayList();
    private HashSet<Message> messagesSeen;


    public MessageController(HashSet hashSet){
        messagesSeen = hashSet;
    }


    // why a HashSet??

    public MessageController(){

    }


    public ArrayList<Message> getMessages() {
        for(Message message: messagesSeen){
            response.add(message);
        }

        return response;
    }
    public ArrayList<Message> getMessagesForId(Id Id) {
        for(Message message: messagesSeen){
            if(message.getFromID().equals(Id)){
                response.add(message);
            }
        }

        return response;
    }
    public Message getMessageForSequence(String seq) {
        return null;
    }
    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
        return null;
    }

    public Message postMessage(Id myId, Id toId, Message msg) {
        return null;
    }
 
}