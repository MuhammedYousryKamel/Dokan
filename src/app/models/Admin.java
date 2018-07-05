/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author gami
 */
public class Admin {

    /**
     * 
     * @param name
     * @param descreption
     * @param user_id 
     */
    public void addCategory(String name, String descreption, int user_id) {
        new Category().addCategory(name, descreption, user_id);
    }

    /**
     * 
     * @return
     * @throws SQLException 
     */
    public ArrayList showFeedbackEmails() throws SQLException {
        return new Feedback().showFeedbackEmails();
    }

    /**
     * 
     * @param email
     * @return
     * @throws SQLException 
     */
    public ArrayList showFeedback(String email) throws SQLException {
        return new Feedback().showFeedback(email);
    }

    /**
     * 
     * @param name
     * @param discount_price
     * @param user_id 
     */
    public void makeOffer(String name, double discount_price) {
        try {
            new Offer().makeOffer(name, discount_price);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param name
     * @param quantity
     * @param price
     * @param descreption
     * @param category_id
     * @param offer_id 
     */
    public void addProduct(String name, int quantity, int price, String descreption, String categoryName) {
        try {
            new Product().addProduct(name, quantity, price, descreption, categoryName);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList showReport() throws SQLException
    {
        Product product = new Product();
        ArrayList<Product> pro= Product.get(null);
        ArrayList<Pair<String,Integer>> report = new ArrayList();
        do{ int i=0;
            String l =pro.get(i).getName();
            int r = pro.get(i).baidQuantity();
           Pair<String,Integer> re=new Pair<String,Integer>(l,r);
           report.add(re);
        }while(!pro.isEmpty());
//        for (Product p : pro)
//        {
//         for(int i=0 ; i<pro.size();i++)
//         {
//            report.add(p.baidQuantity());
//         }
//        }
        
        return report;
        
    }

}
