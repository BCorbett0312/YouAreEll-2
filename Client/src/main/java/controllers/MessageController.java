package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import models.Id;
import models.Message;

public class MessageController {
    private ArrayList response = new ArrayList();
    private LinkedHashSet<Message> messagesSeen;


    public MessageController(LinkedHashSet hashSet){
        messagesSeen = hashSet;
    }


    // why a HashSet??

    public MessageController(){

    }


    public LinkedHashSet<Message> getMessages() {
        return messagesSeen;
    }

    public void setMessageSeen(LinkedHashSet<Message> messages){
        messagesSeen = messages;
    }


    public void printMessages(){
        messagesSeen.stream().limit(5).forEach(e -> System.out.println(e.toString()));
    }



//    public ArrayList<Message> getMessagesForId(Id Id) {
//
//
//        return response;
//    }
//    public Message getMessageForSequence(String seq) {
//        return null;
//    }
//
//
//    public ArrayList<Message> getMessagesFromFriend(Id myId, Id friendId) {
//        return null;
//    }
//
//    public Message postMessage(Id myId, Id toId, Message msg) {
//        return null;
//    }
 
}