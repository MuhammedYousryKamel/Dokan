/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.App;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author Mourad
 */
public class Guest {
    private String Name;
    private String Email;
    private int Password;
    private String Phone;
    private int Ssn;
     private String address;
      private Timestamp created_at;
      private int role_id;

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getAddress() {
        return address;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    
    public void setName(String GName)
    {
      Name=GName;  
    }
    public void setEmail(String GEmail)
    {
      Email=GEmail;  
    }
    public void setPassword(int GPasswordd)
    {
      Password=GPasswordd;  
    }
     public void setPhone(String GPhone)
    {
      Phone=GPhone;  
    }
      public void setSsn(int GSsn)
    {
      Ssn=GSsn;  
    }
     public String getName()
    {
      return Name;
    }
       public String getEmail()
    {
      return Email;
    }
        public String getPhone()
    {
      return Phone;
    }
      public int getSsn()
    {
      return Ssn;
    }
          public ArrayList attofsearch(){
        ArrayList attributes = new ArrayList();

        attributes.add("name");
        attributes.add("quantity#");
        attributes.add("price");
        attributes.add("description");
        attributes.add("category_id");
        attributes.add("offer_id");
        return attributes;
    }
    
  
    
    public String gettable(){
          return "contact";
      }
      public ArrayList getattributes(){
          ArrayList attributes= new ArrayList();
          attributes.add("Name");
          attributes.add("Email");
          attributes.add("Subject");
          attributes.add("Message");
          return attributes;
      }
      public void contact_us(String Name,String Email, String Subject,String Message) throws SQLException
      {
         ArrayList list=new ArrayList();
         list.add(Name);
         list.add(Email);
         list.add(Subject);
         list.add(Message);
        App.AddRow(this.gettable(), this.getattributes(), list);
      }
      
        
            
            
            
      public ArrayList attreg(){
          ArrayList attributes= new ArrayList();
          attributes.add("name");
          attributes.add("email");
          attributes.add("balance");
          attributes.add("password");
          attributes.add("SSN");
          attributes.add("phone");
          attributes.add("address");
          attributes.add("role_id");
          return attributes;
      }
      public void register(String name,String email, int balance,String password,String SSN,String phone,String address,int role_id) throws SQLException
      {
         ArrayList list=new ArrayList();
         list.add(name);
         list.add(email);
         list.add(balance);
         list.add(password);
         list.add(SSN);
         list.add(phone);
         list.add(address);
         list.add(role_id);
        
        App.AddRow("users", this.attreg(), list);
      }      
      
      public ArrayList getAttributes() {
   
        ArrayList list1=new ArrayList();
        list1.add("email");
        
        return list1;
        
    }
      public ArrayList Forget_password(String Email) throws SQLException{
          ArrayList s=new ArrayList();
         s=App.select("users",this.getAttributes(),"email= '"+Email+"'");
       return s;
                  
      }
       public int forget(HashMap<String,Object> h,String s) throws SQLException{
           
                
                int x;
                x=App.update("users",h, "email= '"+s+"'");
                return x;
               
            }

        
}
