/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.App;
import app.susport.contact.Component;
import app.susport.contact.IModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class Product implements IModel ,Component {

    /**
     * Empty product empty
     */
    public Product() {
    }
    public String productName;
    
    /**
     * Create product using id and load other attribute form  database 
     * @param id
     * @throws SQLException 
     */
    public Product(int id) throws SQLException {
        ArrayList<HashMap<String, Object>> rows = App.select(this.getTable(), this.getAttributes(), " ID = " + id, null, null, 1);
        if (!rows.isEmpty()) {
            this.HashMapLoad(rows.get(0));
        }
    }

    public Product(int id, String name, int price, String description) {
        this.ID = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    /**
     * Create product using select rowMap columnNAme\Value
     * @param categoryMap 
     */
    public Product(HashMap<String, Object> categoryMap) {
        this.HashMapLoad(categoryMap);
    }

    /**
     * Search return Product where condition true
     *
     * @param condition
     * @param orderby
     * @param order
     * @param limit
     * @return
     * @throws SQLException
     */
    public static ArrayList<Product> get(String condition, String orderby, String order, int limit) throws SQLException {
        ArrayList<HashMap<String, Object>> rows = Product.getProductRows(condition, orderby, order, limit);
        if (rows == null || rows.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Product> resultCategories = new ArrayList<>();
        for (int index = 0; index < rows.size(); index++) {
            resultCategories.add(new Product(rows.get(index)));
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
    public static ArrayList<Product> get(String condition, String orderby, String order) throws SQLException {
        return Product.get(condition, orderby, order, 30);
    }

    /**
     *
     * @param condition
     * @param orderby
     * @return
     * @throws SQLException
     */
    public static ArrayList<Product> get(String condition, String orderby) throws SQLException {
        return Product.get(condition, orderby, "ASC");
    }

    /**
     *
     * @param condition
     * @return
     * @throws SQLException
     */
    public static ArrayList<Product> get(String condition) throws SQLException {
        return Product.get(condition, null, null);
    }

    /**
     * Return Array list of Hashmap key/value
     *
     * @param condition
     * @param orderby
     * @param order
     * @param limit
     * @return
     * @throws SQLException
     */
    public static ArrayList<HashMap<String, Object>> getProductRows(String condition, String orderby, String order, int limit) throws SQLException {
        return App.select("products", null, condition, orderby, order, limit);

    }

    /**
     * Return Array list of Hashmap key/value
     *
     * @param condition
     * @param orderby
     * @param order
     * @return
     * @throws SQLException
     */
    public static ArrayList<HashMap<String, Object>> getProductRows(String condition, String orderby, String order) throws SQLException {
        return Product.getProductRows(condition, orderby, order, 30);
    }

    /**
     * Return Array list of Hashmap key/value
     *
     * @param condition
     * @param orderby
     * @return
     * @throws SQLException
     */
    public static ArrayList<HashMap<String, Object>> getProductRows(String condition, String orderby) throws SQLException {
        return Product.getProductRows(condition, orderby, "ASC");
    }

    /**
     *
     * @param condition
     * @return
     * @throws SQLException
     */
    public static ArrayList<HashMap<String, Object>> getProductRows(String condition) throws SQLException {
        return Product.getProductRows(condition, null, null);
    }
    
    /**
     * Update product
     * @param updatedAttriubute
     * @return
     * @throws SQLException 
     */
    public boolean EditProduct(HashMap<String, Object> updatedAttriubute) throws SQLException {
        if (App.update(this.getTable(), updatedAttriubute, " ID =" + this.ID ) > 0) {
            this.HashMapLoad(updatedAttriubute);
            return true;
        } else {
            return false;
        }

    }
    
    /**
     * reduce product quantity
     * @param quantity 
     */
    public boolean reduceQuantity(int quantity) throws SQLException{
        if(this.quantity==0)
            return false;
        HashMap<String,Object>updates=new HashMap<>();
        updates.put("quantity#",this.quantity-quantity);
        return this.EditProduct(updates);
    }
    
    /**
     * 
     * @return total number of paid 
     * @throws SQLException 
     */
    public int baidQuantity() throws SQLException{
        Statement stmt=App.createStatement();
        String query="SELECT Sum(`quantity`) AS totalQuantity FROM invoice_product WHERE  product_id="+this.ID+" GROUP BY product_id";
        stmt.execute(query);
        ResultSet result=stmt.getResultSet();
        int baidQuantity=0;
        if(result.next()){
            baidQuantity=result.getInt(1);
        }
        return baidQuantity;
    }
    
    public ArrayList att() {
        ArrayList attributes = new ArrayList();

        attributes.add("name");
        attributes.add("quantity#");
        attributes.add("price");
        attributes.add("description");
        attributes.add("category_id");
        attributes.add("offer_id");
        return attributes;
    }
   public void addProduct(String name, int quantity,int price, String descreption,String categoryName) throws SQLException {
       
        ArrayList Category_id = new ArrayList();
        Category_id.add("ID");//hna bn3ml ano yrg3 attribute l id bs 
        ArrayList<HashMap<String, Object>> categorey_ID = new ArrayList<>();// hna 3shan l select btrg3 arraylist of hashmap
        
        categorey_ID= App.select("category",Category_id ,"name = '"+categoryName+"'");
        
       for (HashMap<String, Object> categoryid : categorey_ID) {
         
       this.ID = (int) categoryid.get("ID");
              
         }
   
       
        
       
        ArrayList values = new ArrayList();
        values.add(name);
        values.add(quantity);
        values.add(price);
        values.add(descreption);
        values.add(this.getID());
        values.add(0);
        //values.add();
        
//        System.out.println(values);

        //App.getConnectDatabase();
        try {
            App.AddRow(this.getTable(),this.att(),values);
             
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   public ArrayList<HashMap<String, Object>> Search(String name) throws SQLException
    {
       this.name=name;
       ArrayList<HashMap<String, Object>> productData = App.select(this.getTable(),null,"name = '"+name+"'");
        return productData;
        
    }
   public void deleteProduct(String productName) throws SQLException
    {
        this.name = productName;  
        App.deleteRow(this.getTable(),"name = '"+name+"'" );
    }
    public boolean editProduct(HashMap<String, Object> updatedAttriubute,String productName) throws SQLException
    {
        if (App.update(this.getTable(), updatedAttriubute,"name = '"+productName+"' ") > 0)
        {
          //  this.HashMapLoad(updatedAttriubute);
            return true;
        } else {
            return false;
        }
       
         
    }

    public ArrayList showProduct(int category_id) throws SQLException {
        ArrayList attribute = new ArrayList();
        attribute.add("ID");
        attribute.add("name");
        attribute.add("price");
        attribute.add("description");


        ArrayList products = App.select(this.getTable(), attribute, "category_id = " + category_id);
        return products;

    }

    public ArrayList search(String name) throws SQLException {
        ArrayList attribute = new ArrayList();
        attribute.add("ID");
        attribute.add("name");
        attribute.add("price");
        attribute.add("description");

        ArrayList products = App.select(this.getTable(), attribute, "name = '" + name + "' ");
        return products;

    }

    /**
     * Load Attribute form Product Map
     *
     * @param productMAp
     */
    private void HashMapLoad(HashMap<String, Object> productMAp) {

        if (productMAp == null || productMAp.isEmpty()) {
            return;
        }
        if (productMAp.containsKey("ID")) {
            this.ID = (int) productMAp.get("ID");
        }
        if (productMAp.containsKey("name")) {
            this.name = (String) productMAp.get("name");
        }
        if (productMAp.containsKey("description")) {
            this.description = (String) productMAp.get("description");
        }
        if (productMAp.containsKey("quantity#")) {
            this.quantity = (int) productMAp.get("quantity#");
        }
        if (productMAp.containsKey("price")) {
            this.price = (int) productMAp.get("price");
        }
        if (productMAp.containsKey("offer_id")) {
            this.offer_id = (int) productMAp.get("offer_id");
        }
        if (productMAp.containsKey("category_id")) {
            this.category_id = (int) productMAp.get("category_id");
        }
        if (productMAp.containsKey("created_at")) {
            this.created_at = (Timestamp.valueOf(productMAp.get("created_at").toString()));
        }
    }

    public HashMap<String, Object> getHash() {
        HashMap<String, Object> m = new HashMap<>();
        m.put("ID", ID);
        m.put("name", name);
        m.put("price", price);
        m.put("description", description);
        
        return m;
    }
    /**
     * @return  table name
     */
    @Override
    public String getTable() {
        return "products";
    }

    @Override
    public ArrayList getAttributes() {
        ArrayList attributes = new ArrayList();
        attributes.add("ID");
        attributes.add("name");
        attributes.add("quantity#");
        attributes.add("price");
        attributes.add("description");
        attributes.add("created_at");
        attributes.add("category_id");
        attributes.add("offer_id");
        return attributes;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getName() {
        return name;
    }

    public String getDescreption() {
        return descreption;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public int ID;
    public String name;
    public String descreption;
    public int price;
    public String description;
    public int quantity;
    public int offer_id;
    public int category_id;
    public Timestamp created_at;

  
    private Component component;
    
    
    /**
     * Add decorate 
     * @param component 
     */
    public void decorate(Component component){
        this.component=component;
    }
    
    /**
     * @return  final price
     */
    @Override
    public double cost() {
        if(this.component!=null){
            return this.price+this.component.cost();
        }
        return this.price;
    }
}
