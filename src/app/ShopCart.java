/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.models.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author gami
 */
public class ShopCart extends HashSet<Integer>{
    
    public ShopCart(){}
    
    /**
     * Get added products
     * @return Array of rules
     * @throws SQLException 
     */
    public ArrayList<HashMap<String,Object>> getSelectProduct() throws SQLException{
       
        String condition=" ID IN (";
        int index=0;
        for (Integer product_id : this) {
            if(index==0){
                condition+=""+product_id;
            }else{
                condition+=","+product_id;
            }
            index++;
        }
        condition+=" )";
        return Product.getProductRows(condition);
    }
}
