package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.internal.org.objectweb.asm.TypeReference;
import models.Id;
import views.YouAreEll;

public class IdController {
    private ObjectMapper mapper = new ObjectMapper();
    private YouAreEll youAreEll;
    private ArrayList<Id> iDList;
    Id myId;

    public IdController(){
        iDList = new ArrayList<>();
    }

    public IdController(List<Id> newList){
        for (Id id: newList) {
            iDList.add(id);
        }


    }



    public ArrayList<Id> getIds() {

        return iDList;
    }

    public void addIds(Id toAdd){
        iDList.add(toAdd);
    }

    public Id postId(Id id) {


        return null;
    }

    public Id putId(Id id) {
        return null;
    }

    public Id getMyId(){


        return iDList.get(0);
    }
 
}