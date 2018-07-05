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
 * @author gami
 */
public class Offer implements IModel ,Component{

    /**
     * empty offer object
     */
    public Offer() {
    }

    public Offer(int id, int discount_price) {
        this.ID = id;
        this.discount_price = discount_price;
    }
    /**
     * Create object and fetch his other attribute form database
     * @param id
     * @throws SQLException 
     */
    public Offer(int id) throws SQLException {
        ArrayList<HashMap<String, Object>> rows = App.select(this.getTable(), this.getAttributes(), " ID = " + id, null, null, 1);
        if (!rows.isEmpty()) {
            this.HashMapLoad(rows.get(0));
        }
    }
    /**
     * Make offer by offermap key/value
     * @param offerMap 
     */
    public Offer(HashMap<String, Object> offerMap) {
        this.HashMapLoad(offerMap);
    }

    /**
     * Get Offers
     *
     * @param condition
     * @param orderby
     * @param order
     * @param limit
     * @return
     * @throws SQLException
     */
    public static ArrayList<Offer> get(String condition, String orderby, String order, int limit) throws SQLException {
        ArrayList<HashMap<String, Object>> rows = App.select("offers", null, condition, orderby, order, limit);
        if (rows == null || rows.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Offer> resultOffers = new ArrayList<>();
        for (int index = 0; index < rows.size(); index++) {
            resultOffers.add(new Offer(rows.get(index)));
        }
        return resultOffers;
    }

    /**
     *
     * @param condition
     * @param orderby
     * @param order
     * @return
     * @throws SQLException
     */
    public static ArrayList<Offer> get(String condition, String orderby, String order) throws SQLException {
        return Offer.get(condition, orderby, order, 30);
    }

    /**
     *
     * @param condition
     * @param orderby
     * @return
     * @throws SQLException
     */
    public static ArrayList<Offer> get(String condition, String orderby) throws SQLException {
        return Offer.get(condition, orderby, "ASC", 30);
    }

    /**
     *
     * @param condition
     * @return
     * @throws SQLException
     */
    public static ArrayList<Offer> get(String condition) throws SQLException {
        return Offer.get(condition, null, null, 30);
    }

    /**
     * 
     * @return  table name
     */
    @Override
    public String getTable() {
        return "offers";
    }

    /**
     * 
     * @return get fetch column name
     */
    @Override
    public ArrayList getAttributes() {
        ArrayList attributes = new ArrayList();
        attributes.add("ID");
        attributes.add("created_at");
        attributes.add("discount_price");
        attributes.add("user_id");
        return attributes;
    }

    
    /**
     * @return offerDiscount
     */
     @Override
    public double cost() {
       return 0-this.discount_price;
    }
    /**
     * Load Attribute
     *
     * @param
     */
    private void HashMapLoad(HashMap<String, Object> userMap) {
        if (userMap == null || userMap.isEmpty()) {
            return;
        }
        if (userMap.containsKey("ID")) {
            this.ID = (int) userMap.get("ID");
        }
        if (userMap.containsKey("created_at")) {
            this.created_at = (Timestamp.valueOf(userMap.get("created_at").toString()));
        }
        if (userMap.containsKey("user_id")) {
            if (userMap.get("user_id") == null) {
                this.user_id = 0;
            } else {
                this.user_id = Integer.parseInt(userMap.get("user_id").toString());
            }
        }

        if (userMap.containsKey("discount_price")) {
            if (userMap.get("discount_price") == null) {
                this.discount_price = 0;
            } else {
                this.discount_price = Integer.parseInt(userMap.get("discount_price").toString());
            }
        }

    }

    public ArrayList att() {
        ArrayList attributes = new ArrayList();

        attributes.add("discount_price");
        attributes.add("user_id");
        return attributes;
    }

     public void makeOffer(String name,double offer_price) throws SQLException{
        
        int userid=1; //3obal ma abdelrahman ygbli l id bta3 l ragl l 3aml login
        
         ArrayList values = new ArrayList();
        //values.add(name);
        values.add(offer_price);
        values.add(userid);
//
//        

        try {
            App.AddRow(this.getTable(), this.att(), values);
        } catch (SQLException ex) {
            Logger.getLogger(Offer.class.getName()).log(Level.SEVERE, null, ex);
        }
        Statement stmt = App.createStatement();
            ResultSet  idMax = stmt.executeQuery("SELECT Max(ID) AS max_id  FROM offers");
            int max_id = 0;
                if (idMax.next()) {
                  max_id= idMax.getInt("max_id");       
        }
               HashMap<String, Object> updatedAttriubute =new HashMap() ;
               
               updatedAttriubute.put("offer_id",""+max_id);
               
        App.update("products",updatedAttriubute,"name = '"+name+"' ");
    }
    public ArrayList showOffer() throws SQLException {
        ArrayList attribute = new ArrayList();
        attribute.add("ID");
        attribute.add("discount_price");

        ArrayList offers = App.select(this.getTable(), attribute, null);
        return offers;

    }
    public ArrayList showOffers() throws SQLException
    {
         
         Statement stmt = App.createStatement();
         ResultSet  offer_product = stmt.executeQuery("SELECT products.name ,offers.discount_price FROM products JOIN offers ON products.offer_id=offers.ID  ");
        ArrayList<Pair<String,Integer>>offer_pro = new ArrayList ();
             offer_product.next();
         
         do{
             
            String l = offer_product.getString("name") ;
            int r =offer_product.getInt("discount_price") ;
            Pair<String,Integer> x =new Pair<String,Integer>(l,r);
            offer_pro.add(x);
           // System.out.println(l + "\t" + r );
         } 
         while (offer_product.next());
         return offer_pro ;
        
        
    }
    public void deleteOffer(String name) throws SQLException
    {
        Product p = new Product();
         for (HashMap<String, Object> products : p.Search(name) ) {
             // System.out.println(products.get("offer_id"));
             System.out.println(products);
             App.deleteRow(this.getTable(),"ID = '"+products.get("offer_id")+"' ");

         }
        
        
    }
    
    public int getID() {
        return ID;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getDiscount_price() {
        return discount_price;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    private int discount_price;

    private Timestamp created_at;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDiscount_price(int discount_price) {
        this.discount_price = discount_price;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
    private int ID;
    private int user_id;

   
}
