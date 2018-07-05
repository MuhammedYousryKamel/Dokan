/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline;

import app.App;
import app.models.Admin;
import app.models.Category;
import app.models.Customer;
import app.models.Feedback;
import app.models.Invoice;
import app.models.Offer;
import app.models.Pair;
import app.models.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author gami
 */
public class ShopOnline {
    static{
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(ShopOnline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, NamingException, SQLException, Exception {
        // TODO code application logic here
        // For bootstrap the projects
            
//        ArrayList a=new ArrayList();
//        a.add("name");
//        ArrayList rows= App.select("category");
//       if(Customer.login("aaaa","mayar")){
//         Customer s=(Customer)App.getCurrentCustomer();
//         System.out.println(s.getID());
//       }
//        
//      
//        
//        HashMap<String ,Object> a=new HashMap<>();
        //a.put("quantity#","500");
        
       // s.editProfile(a);
        //System.out.println(s.getPassword());

//        ArrayList a=Offer.get(" true ","created_at","DESC", 30);
        
      // Product p=new Product();
        //p.addProduct("mostafa", 100, 15, "test test test ", 1, 1);

//        Product p=new Product(1); //Fetch be Id
    //boolean h=   p.editProduct(a,"AMR");
     //   System.out.println(h); 
        //Offer o =new Offer();
        //o.makeOffer("discount mayar",10, 1);
      //  Category c = new Category();
       // c.addCategory("mourad", "ffffffffff", 1);
        
        //Feedback f = new Feedback();
        
       // ArrayList x = f.showFeedback("amr_shawki");
        //ArrayList y= f.showFeedbackEmails();
        //for(int i=0;i<x.size();i++)
        //{
          //  System.out.println( x.get(i));
       // }
     //  ArrayList y = p.showProduct(1);
       //  System.out.println(y.get(0));
        // System.out.println(y.get(1));
      /* for(int i=0;i<2;i++){
            System.out.println(y.get(i));
            
        }*/
       //ArrayList<HashMap<String,Object>> j = p.search("mayar");
        
         
        /*  for(HashMap<String, Object> obj : j) {
           int get1 = (int) obj.get("ID");
           String get2 = (String) obj.get("name");
           int get3 = (int) obj.get("price");
           String get4 = (String) obj.get("description");
              System.out.println(get1+" "+get2+" "+get3+" "+get4 );
              
          }  */  
       // f.addFeedback("mayar", "hhhhhhhhhhh", "mayar@yahoo.com", 1);
   //    ArrayList i= Product.get("category_id="+ 1);
     //   System.out.println(i.get(0));
        
//        ArrayList<HashMap<String,Object>> rows=Product.getProductRows(" true ");
//        for(HashMap<String,Object> item : rows){
//            item.put("buyNumber", 1);
//        }
//        Invoice.add(rows, 1, "cash");
   // Product p = new Product();
   //Product p = Product.get(null);
    
    
    
      
    }
    /**
     * Applictions booting
     * @throws SQLException
     */
    public static void init() throws SQLException {
        App.connectDatabase();
    }

}
