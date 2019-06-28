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

    public void printList(){
        for (Id id : iDList){
            System.out.println(id.toString());
        }
    }
 
}