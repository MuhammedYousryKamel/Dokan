/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.App;
import app.susport.contact.IModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author gami
 */
public class Invoice implements IModel {

    /**
     * Empty Invoice object
     */
    public Invoice() {
    }
    public Invoice(double total) {
        this.total_price = total;
    }
    /**
     * Create invoice by id fetch other field form database
     *
     * @param id
     * @throws SQLException
     */
    public Invoice(int id) throws SQLException {
        ArrayList users = App.select(this.getTable(), this.getAttributes(), " ID = " + id, null, null, 1);
        if (!users.isEmpty()) {
            this.HashMapLoad((HashMap<String, Object>) users.get(0));
        }
    }

    /**
     * Create Object of Invoice by invoiceMap is mapping attribute/value
     *
     * @param invoiceMap
     */
    public Invoice(HashMap<String, Object> invoiceMap) {
        this.HashMapLoad(invoiceMap);
    }

    /**
     * Load Attribute form InvoiceMap
     *
     * @param invoiceMap
     */
    private void HashMapLoad(HashMap<String, Object> invoiceMap) {

        if (invoiceMap == null || invoiceMap.isEmpty()) {
            return;
        }
        if (invoiceMap.containsKey("ID")) {
            this.ID = (int) invoiceMap.get("ID");
        }
        if (invoiceMap.containsKey("user_id")) {
            this.user_id = (int) invoiceMap.get("user_id");
        }
        if (invoiceMap.containsKey("total_price")) {
            this.total_price = Double.parseDouble("" + invoiceMap.get("total_price"));
        }
        if (invoiceMap.containsKey("payment_type")) {
            this.payment_type = (String) invoiceMap.get("payment_type");
        }
        if (invoiceMap.containsKey("created_at")) {
            this.created_at = (Timestamp.valueOf(invoiceMap.get("created_at").toString()));
        }
    }

    /**
     *
     * @return table name
     */
    @Override
    public String getTable() {
        return "invoice";
    }

    /**
     *
     * @return all column name
     */
    @Override
    public ArrayList getAttributes() {
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add("ID");
        attributes.add("created_at");
        attributes.add("total_price");
        attributes.add("user_id");
        attributes.add("payment_type");
        return attributes;
    }

    /**
     *
     * Fetch quantity => buyNumber
     *
     * @param invoiceProductMap invoiceProductMap of Map of products which you
     * want make invoice for it
     * @return all cost of products
     */
    public static Invoice add(ArrayList<HashMap<String, Object>> invoiceProductMap, int user_id, String paymantMethod) throws Exception {
        if (invoiceProductMap.isEmpty()) {
            return null;
        }
        double cost = 0;
        ArrayList<HashMap<String, Object>> invoices_products = new ArrayList<HashMap<String, Object>>();
        for (int index = 0; index < invoiceProductMap.size(); index++) {
            if (invoiceProductMap.get(index).containsKey("ID")) {

                HashMap<String, Object> item = new HashMap<>();
                item.put("buyNumber", invoiceProductMap.get(index).get("buyNumber"));

                Product product = new Product((int) invoiceProductMap.get(index).get("ID"));

                item.put("product_id", product.getID());
                product.decorate(new Offer(product.getOffer_id()));
                //Add payment method
                product.reduceQuantity((int) invoiceProductMap.get(index).get("buyNumber"));
                //Adding the cost
                double product_cost = product.cost() * (int) invoiceProductMap.get(index).get("buyNumber");

                item.put("price", product_cost);
                cost += product_cost;
                invoices_products.add(item);

            } else {
                throw new Exception("I do't found ID in product Map");
            }
        }

        //Add invoices
        Statement stmt = App.createStatement();
        String query = "INSERT INTO invoice (total_price,user_id,payment_type) VALUES (" + cost + "," + user_id + ",'" + paymantMethod + "')";
        String[] columnName = {"ID"};
        int invoice_id = 0;
        if (stmt.executeUpdate(query, columnName) > 0) {;
            ResultSet set = stmt.getGeneratedKeys();
            if (set.next()) {
                invoice_id = (int) (set.getInt(1));
            }
        } else {
            throw new Exception("Can't create invoices");
        }
        stmt.close();
        ArrayList attributes = new ArrayList();
        attributes.add("product_id");
        attributes.add("invoice_id");
        attributes.add("price");
        attributes.add("quantity");
        for (int index = 0; index < invoices_products.size(); index++) {
            ArrayList values = new ArrayList();
            values.add(invoices_products.get(index).get("product_id"));
            values.add(invoice_id);
            values.add(invoices_products.get(index).get("price"));
            values.add(invoices_products.get(index).get("buyNumber"));
            App.AddRow("invoice_product", attributes, values);
        }
        return new Invoice(invoice_id);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    private int ID;
    private Timestamp created_at;
    private double total_price;
    private int user_id;
    private String payment_type;
}
