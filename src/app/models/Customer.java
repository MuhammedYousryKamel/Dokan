/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.App;
import app.susport.contact.IModel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author gami
 */
public class Customer implements IModel {

    public Customer() {
    }

    /**
     * select user by conditions
     *
     * @param conditon
     * @param limit
     * @return Users
     * @throws SQLException
     */
    public static ArrayList<Customer> selectUsers(String conditon, int limit) throws SQLException {
        ArrayList<HashMap<String, Object>> users;
        users = App.select("users", null, conditon, null, null, limit);
        if (users == null || users.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Customer> resultUser = new ArrayList<>();
        for (int index = 0; index < users.size(); index++) {
            resultUser.add(new Customer(users.get(index)));
        }
        return resultUser;
    }

    /**
     * select user by conditions
     *
     * @param conditon
     * @return Users
     * @throws SQLException
     */
    public static ArrayList<Customer> selectUsers(String conditon) throws SQLException {
        return selectUsers(conditon, 30);
    }

    public Customer(HashMap<String, Object> userMap) {
        this.HashMapLoad(userMap);
    }

    /**
     * @param email Create user by email
     * @throws java.sql.SQLException
     */
    public Customer(String email) throws SQLException {
        ArrayList users = App.select(this.getTable(), this.getAttributes(), " email = '" + email + "'", null, null, 1);
        if (!users.isEmpty()) {
            this.HashMapLoad((HashMap<String, Object>) users.get(0));
        }

    }

    /**
     * @param id Create user by ID
     */
    public Customer(int id) throws SQLException {
        ArrayList users = App.select(this.getTable(), this.getAttributes(), " ID = " + id, null, null, 1);
        if (!users.isEmpty()) {
            this.HashMapLoad((HashMap<String, Object>) users.get(0));
        }
    }

    @Override
    public String getTable() {
        return "users";
    }

    @Override
    public ArrayList getAttributes() {
        ArrayList attributes = new ArrayList();
        attributes.add("ID");
        attributes.add("name");
        attributes.add("email");
        attributes.add("balance");
        attributes.add("password");
        attributes.add("SSN");
        attributes.add("phone");
        attributes.add("address");
        attributes.add("created_at");
        attributes.add("role_id");
        return attributes;
    }

    /**
     * Load Attribute form UserMap
     *
     * @param userMap
     */
    private void HashMapLoad(HashMap<String, Object> userMap) {

        if (userMap == null || userMap.isEmpty()) {
            return;
        }
        if (userMap.containsKey("ID")) {
            this.ID = (int) userMap.get("ID");
        }
        if (userMap.containsKey("name")) {
            this.name = (String) userMap.get("name");
        }
        if (userMap.containsKey("email")) {
            this.email = (String) userMap.get("email");
        }
        if (userMap.containsKey("balance")) {
            this.balance = Double.parseDouble("" + userMap.get("balance"));
        }
        if (userMap.containsKey("password")) {
            this.password = (String) userMap.get("password");
        }
        if (userMap.containsKey("SSN")) {
            this.SSN = (String) userMap.get("SSN");
        }
        if (userMap.containsKey("phone")) {
            this.phone = (String) userMap.get("phone");
        }
        if (userMap.containsKey("address")) {
            this.address = (String) userMap.get("address");
        }
        if (userMap.containsKey("created_at")) {
            this.created_at = (Timestamp.valueOf(userMap.get("created_at").toString()));
        }
        if (userMap.containsKey("last_login")) {
            this.last_login = (Timestamp.valueOf(userMap.get("last_login").toString()));
        }
        if (userMap.containsKey("role_id")) {
            this.role_id = (int) userMap.get("role_id");
        }
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String getSSN() {
        return SSN;
    }

    public String getPhone() {
        return phone;
    }

    

    public String getAddress() {
        return address;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getLast_login() {
        return last_login;
    }
    public int getRole_id() {
        return role_id;
    }
    
    public void diactivatecustomer(String customeremail) throws SQLException
    {
        this.email = customeremail;  
        App.deleteRow(this.getTable(),"email = '"+email+"'" );
    }
    public ArrayList<HashMap<String, Object>> Search_Customer(String email) throws SQLException
    {
       this.email=email;
       ArrayList<HashMap<String, Object>> customerData = App.select(this.getTable(),null,"email = '"+email+"'");
        return customerData;
        
    }
    
    public static boolean login(String email, String password) throws SQLException {
        Customer user = new Customer(email);
        if (user.password == null ? false : user.password.equals(password)) {
            App.setCurrentCustomer(user);
            return true;
        } else {
            return false;
        }
    }

    public boolean editProfile(HashMap<String, Object> updatedAttriubute) throws SQLException {
        if (App.update(this.getTable(), updatedAttriubute, " ID = " + this.ID) > 0) {
            this.HashMapLoad(updatedAttriubute);
            return true;
        } else {
            return false;
        }
    }
   /* public ArrayList<HashMap<String ,Object>> addtoCart(ArrayList<HashMap<String ,Object>> l)
    {
        ArrayList<HashMap<String ,Object>> list = new ArrayList<>();
        int i=0;
         for(HashMap<String, Object> obj : l) {
              list.add(l.get(i));
               i++;
          }   
        return list;
        
    }*/

    private int ID;

    private String name;

    private String email;

    private double balance;

    private String password;

    private String SSN;

    private String phone;

    private String address;

    private Timestamp created_at;

    private Timestamp last_login;
    
    private int role_id;

}
