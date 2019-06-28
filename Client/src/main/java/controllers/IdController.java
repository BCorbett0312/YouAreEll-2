package controllers;

import java.util.ArrayList;



import models.Id;


public class IdController {

    private ArrayList<Id> iDList;

    public IdController(){
    }

    public IdController(ArrayList<Id> newList){
        this.iDList = newList;
    }

    public void setiDList(ArrayList<Id> idList){
        this.iDList= idList;
    }

    public ArrayList<Id> getIds() {
        return iDList;
    }

    public Id ListContains(String toEval){
        for (Id id: iDList) {
            if (id.getGithub().equals(toEval)){
                return id;
            }
        }
        return null;
    }




    public void printList(){
        for (Id id : iDList){
            System.out.println(id.toString());
        }
    }
 
}