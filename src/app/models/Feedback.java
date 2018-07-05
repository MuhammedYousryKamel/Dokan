
package app.models;

import app.App;
import app.susport.contact.IModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import shoponline.ShopOnline;



public class Feedback implements IModel{

    public Feedback(){
        try {
            ShopOnline.init();
        } catch (SQLException ex) {
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    @Override
    public String getTable() {
        return "feedback";        
    }

    @Override
    public ArrayList getAttributes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList att(){
        ArrayList attributes = new ArrayList();

        attributes.add("name");
        attributes.add("message");
        attributes.add("email");
        attributes.add("user_id");
        return attributes;
    }
    public ArrayList<HashMap<String,Object>> showFeedbackEmails() throws SQLException
    {
        ArrayList attribute = new ArrayList();
        attribute.add("email");
        ArrayList rows = App.select(this.getTable(),attribute);
        return rows;
        
    }
    public ArrayList<HashMap<String,Object>> showFeedback(String email) throws SQLException
            
    {
        ArrayList attribute = new ArrayList();
        attribute.add("message");
        
        ArrayList Feedback = App.select(this.getTable(),attribute ,"email = '"+email+"' " );
        return Feedback;
        
    }
    
    public void addFeedback (String name, String message, String email, int user_id) {

        
        ArrayList values = new ArrayList();
        values.add(name);
        values.add(message);
        values.add(email);
        values.add(user_id);
        


        //App.getConnectDatabase();
        try {
            App.AddRow(this.getTable(), this.att(), values);
        } catch (SQLException ex) {
            Logger.getLogger(Feedback.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
