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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gami
 */
public class Category implements IModel {

    public Category() {
    }

    public Category(int id) throws SQLException {
        ArrayList<HashMap<String, Object>> rows = App.select(this.getTable(), this.getAttributes(), " ID = " + id, null, null, 1);
        if (!rows.isEmpty()) {
            this.HashMapLoad(rows.get(0));
        }
    }

    /**
     * @param categoryMap
     */
    public Category(HashMap<String, Object> categoryMap) {
        this.HashMapLoad(categoryMap);
    }

    /**
     * Get Categories 
     * @param condition
     * @param orderby
     * @param order
     * @param limit
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Category> get(String condition, String orderby, String order, int limit) throws SQLException {
        ArrayList<HashMap<String, Object>> rows = App.select("category", null, condition, orderby, order, limit);
        if (rows == null || rows.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Category> resultCategories = new ArrayList<>();
        for (int index = 0; index < rows.size(); index++) {
            resultCategories.add(new Category(rows.get(index)));
        }
        return resultCategories;
    }
    /**
     * 
     * @param condition
     * @param orderby
     * @param order
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Category> get(String condition, String orderby, String order) throws SQLException {
        return Category.get(condition, orderby, order, 30);
    }

    /**
     *  
     * @param condition
     * @param orderby
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Category> get(String condition, String orderby) throws SQLException {
        return Category.get(condition, orderby, "ASC");
    }

    /**
     * 
     * @param condition
     * @return
     * @throws SQLException 
     */
    public static ArrayList<Category> get(String condition) throws SQLException {
        return Category.get(condition, null, null);
    }

    @Override
    public String getTable() {
        return "category";
    }

    @Override
    public ArrayList getAttributes() {
        ArrayList attributes = new ArrayList();
        attributes.add("ID");
        attributes.add("Description");
        attributes.add("name");
        attributes.add("created_at");
        attributes.add("user_id");
        return attributes;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public int getUser_id() {
        return user_id;
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
        if (userMap.containsKey("Description")) {
            this.description = (String) userMap.get("Description");
        }
        if (userMap.containsKey("created_at")) {
            this.created_at = (Timestamp.valueOf(userMap.get("created_at").toString()));
        }
        if (userMap.containsKey("user_id")) {
            if ((String) userMap.get("user_id") == null) {
                this.user_id = 0;
            } else {
                this.user_id = Integer.parseInt( userMap.get("user_id").toString());
            }
        }

    }
    public ArrayList att(){
        ArrayList attributes = new ArrayList();

        attributes.add("name");
        attributes.add("description");
        attributes.add("user_id");
        return attributes;
    }
    public ArrayList<HashMap<String, Object>> Search_Category(String name) throws SQLException
    {
       this.name=name;
       ArrayList<HashMap<String, Object>> categoryData = App.select(this.getTable(),null,"name = '"+name+"'");
        return categoryData;
        
    }
   public void addCategory(String name, String descreption,int user_id) {

        
        ArrayList values = new ArrayList();
        values.add(name);
        values.add(descreption);
        values.add(user_id);
       
        //App.getConnectDatabase();
        try {
            App.AddRow(this.getTable(), this.att(), values);
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }  
    
    }
   public ArrayList<HashMap<String, Object>> getcategory(int id) throws SQLException{
    
          ArrayList<HashMap<String, Object>> categorydata = App.select(this.getTable(),null,"ID = '"+id+"'");
        return categorydata;
    
    }
    

    private int ID;

    private String name;

    private String description;

    private Timestamp created_at;

    private int user_id;

}
