/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package STC_Client;

import java.sql.*;
import java.sql.Statement;
import java.util.*;

/**
 *
 * @author Marcus
 */
public class Client {

    private int id;
    private String name;
    private String adress;
    private String postNumb;
    private String ort;
    private String telefon;
    private String mobil;
    private String fax;
    private String epost;
    private String epost2;
    private String contact;
    private boolean fakturaunderlag;
    
    SQLConnectivity con = new SQLConnectivity();
    
    
    public Client (int id, String name){
        this.name=name;
        this.id=id;
    }
    public Client(){
        
    }

    public int getID() {
        int i=0;
        try{
        con.getNewID();
        i = con.getNewID();
          }catch (ClassNotFoundException|SQLException a){ 
              
          }  
        return i;
    }
    
    
    public ArrayList getClients(){
        SQLConnectivity con = new SQLConnectivity();           
        
        ArrayList <Client> clients = new ArrayList<>();
           try{
            clients = con.getClients();
           }catch (ClassNotFoundException|SQLException ave){
               
           }
           
           return clients;
    }


    
    public void setID(int id){
               this.id = id; 
    }
    public int getExistID(){
         return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setAdress(String adress){
        this.adress = adress;
    }
    public void setPostNumb(String numb){
        this.postNumb=numb;
    }
    public void setOrt(String ort){
        this.ort=ort;
    }
     public void setMob(String mob){
        this.mobil=mob;
    }
      public void setTel(String tel){
        this.telefon=tel;
    }
       public void setFax(String fax){
        this.fax=fax;
    }
       public void setEpost(String epost){
          this.epost=epost; 
       }
         public void setEpost2(String epost){
          this.epost2=epost; 
       }
    public void setContact(String contact){
        this.contact=contact;
    }
    public void setFakturaUnderlag(boolean b){
        this.fakturaunderlag=b;
    }
    
    public String toString(){
        return id+name+fakturaunderlag+""; 
    }

  
}
