/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * singleton
 *
 * @author gami
 */
public class App {

    /**
     * use in save Objects reference
     */
    private static HashMap<String, Object> bind;

    /**
     * Run once using to init the static instance
     */
    static {
        App.bind = new HashMap<>();
        bind.put("app", new App());
    }

    /**
     * private constructor to avoid client applications to use constructor
     */
    public App() {
    }

    /**
     * @return App instance
     */
    public static App getInstance() {
        return (App) App.get("app");
    }

    /**
     * Store key/object
     *
     * @param key
     * @param obj
     */
    public static void bind(String key, Object obj) {
        App.bind.put(key, obj);
    }

    /**
     * get object which his key
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        return App.bind.get(key);
    }

    /**
     * Make default connection in database
     *
     * @throws SQLException
     */
    public static void connectDatabase() throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:" + App.driver + "://localhost:" + App.port + "/" + App.databaseName, App.username, App.password);
        App.bind.put("connection", connect);
    }

    /**
     * Make connection new connection
     *
     * @param driver
     * @param databaseName
     * @param username
     * @param password
     * @param port
     * @return new connection in database
     * @throws SQLException
     */
    public static Connection connectDatabase(String driver, String databaseName, String username, String password, String port) throws SQLException {
        Connection connect = DriverManager.getConnection("jdbc:" + driver + "://localhost:" + port + "/" + databaseName, username, password);
        return connect;
    }

    /**
     * Get Database connection
     *
     * @return
     */
    public static Connection getConnectDatabase() {

        return (Connection) bind.get("connection");
    }

    /**
     * Get new Statement
     *
     * @return
     */
    public static Statement createStatement() throws SQLException {
        return (Statement) ((Connection) bind.get("connection")).createStatement();
    }

    /**
     *
     * @param tablename Table name
     * @param attriubutes The database table fields
     * @param values the values of database fields which the same order
     * attributes
     * @return
     * @throws SQLException
     */
    public final static int AddRow(String tablename, ArrayList attriubutes, ArrayList values) throws SQLException {

        Statement stmt = App.createStatement();
        String query = "INSERT INTO `" + tablename + "`  (";

        // Write Attrubute Grammer
        for (int index = 0; index < attriubutes.size(); index++) {
            if (index + 1 == attriubutes.size()) {
                query += "`" + attriubutes.get(index) + "`";
            } else {
                query += "`" + attriubutes.get(index) + "` ,";
            }
        }
        query += " ) VALUES (";
        // Write Values Grammer
        for (int index = 0; index < values.size(); index++) {
            if (index + 1 == values.size()) {
                if (values.get(index) instanceof java.lang.Integer) {
                    query += values.get(index);
                } else {
                    query += "'" + values.get(index) + "'";
                }
            } else if (values.get(index) instanceof java.lang.Integer) {
                query += values.get(index) + ",";
            } else {
                query += "'" + values.get(index) + "',";
            }
        }
        query += " )";
        int resultInt = stmt.executeUpdate(query);

        stmt.close();
        return resultInt;
    }

    /**
     * update special rows in table at database
     *
     * @param table
     * @param dataMapping
     * @param condition delete row form database if condition result is true
     * @throws java.sql.SQLException
     */
    public final static int update(String table, HashMap<String, Object> dataMapping, String condition) throws SQLException {

        //Write Update grammer
        String query = "UPDATE  `" + table + "` SET ";
        Object[] keys = (dataMapping.keySet().toArray());
        Object[] values = (Object[]) dataMapping.values().toArray();
        for (int index = 0; index < keys.length && index < values.length; index++) {
            if ((index + 1) == keys.length) {
                query += "`" + keys[index] + "` = " + ((values[index] instanceof java.lang.Integer) ? values[index] : "'" + values[index] + "' ");
            } else {
                query += "`" + keys[index] + "` = " + ((values[index] instanceof java.lang.Integer) ? values[index] : "'" + values[index] + "' , ");
            }
        }
        query += (condition != null ? " WHERE " + condition : "");
        //Create and run Statments
        Statement stmt = App.createStatement();
        int resultInt = stmt.executeUpdate(query);
        stmt.close();
        return resultInt;
    }

    /**
     * Select rows form table in database
     *
     * @param table table name must me exist
     * @return Array of rows
     * @throws SQLException
     */
    public final static ArrayList<HashMap<String, Object>> select(String table) throws SQLException {
        return App.select(table, null, null, null, null, 30);
    }

    /**
     * Select rows form table in database
     *
     * @param table table name must me exist
     * @param attribute all want attribute in table if attribute is null then
     * get table attributes
     * @return Array of rows
     * @throws SQLException
     */
    public final static ArrayList<HashMap<String, Object>> select(String table, ArrayList<String> attribute) throws SQLException {
        return App.select(table, attribute, null, null, null, 30);
    }

    /**
     * Select rows form table in database
     *
     * @param table table name must me exist
     * @param attribute all want attribute in table if attribute is null then
     * get table attributes
     * @param condition return row form database if condition result is true
     * @return Array of rows
     * @throws SQLException
     */
    public final static ArrayList<HashMap<String, Object>> select(String table, ArrayList<String> attribute, String condition) throws SQLException {
        return App.select(table, attribute, condition, null, null, 30);
    }

    /**
     * Select rows form table in database
     *
     * @param table table name must me exist
     * @param attribute all want attribute in table if attribute is null then
     * get table attributes
     * @param condition return row form database if condition result is true
     * @param orderby column which will been sorted by
     * @return Array of rows
     * @throws SQLException
     */
    public final static ArrayList<HashMap<String, Object>> select(String table, ArrayList<String> attribute, String condition, String orderby) throws SQLException {
        return App.select(table, attribute, condition, orderby, "ASC", 30);
    }

    /**
     * Select rows form table in database
     *
     * @param table table name must me exist
     * @param attribute all want attribute in table if attribute is null then
     * get table attributes
     * @param condition return row form database if condition result is true
     * @param orderby column which will been sorted by
     * @param order Kind of sorted ASC or DESC
     * @return Array of rows
     * @throws SQLException
     */
    public final static ArrayList<HashMap<String, Object>> select(String table, ArrayList<String> attribute, String condition, String orderby, String order) throws SQLException {
        return App.select(table, attribute, condition, orderby, order, 30);
    }

    /**
     * Select rows form table in database
     *
     * @param table table name must me exist
     * @param attribute all want attribute in table if attribute is null then
     * get table attributes
     * @param condition return row form database if condition result is true
     * @param orderby column which will been sorted by
     * @param order Kind of sorted ASC or DESC
     * @param limit Limit of rows
     * @return Array of rows
     * @throws SQLException
     */
    public final static ArrayList<HashMap<String, Object>> select(String table, ArrayList<String> attribute, String condition, String orderby, String order, int limit) throws SQLException {
        // Write Grammer
        String query = "SELECT ";
        if (attribute == null) {
            query += " * ";
        } else {
            for (int index = 0; index < attribute.size(); index++) {
                if ((index + 1) == attribute.size()) {
                    query += "`" + attribute.get(index) + "` ";
                } else {
                    query += "`" + attribute.get(index) + "` ,";
                }
            }
        }
        query += " FROM  `" + table + "` ";
        query += (condition != null ? " WHERE " + condition : "");
        //Order hander 
        order = (order == null || order.isEmpty() ? "ASC" : order);
        query += (orderby != null ? "ORDER BY `" + orderby + "` " + order : "");
        query += " LIMIT " + limit;//Limit for preformace reason
        ArrayList<HashMap<String, Object>> rows = new ArrayList<>();

        //Database excuting query
        Statement stmt = App.createStatement();
        if (stmt.execute(query)) {
            ResultSet result = stmt.getResultSet();
            // if null get all column attriubute
            if (attribute != null) {
                while (result.next()) {
                    //Mapping 
                    HashMap<String, Object> row = new HashMap<>();
                    for (int index = 0; index < attribute.size(); index++) {
                        row.put(attribute.get(index), result.getObject(attribute.get(index)));
                    }
                    rows.add(row);
                }
            } else {
                //Mapping
                while (result.next()) {
                    HashMap<String, Object> row = new HashMap<>();
                    String columnName;
                    int columnCount = result.getMetaData().getColumnCount();
                    for (int index = 1; index <= columnCount; index++) {
                        columnName = result.getMetaData().getColumnLabel(index);
                        row.put(columnName, result.getObject(columnName));
                    }
                    rows.add(row);
                }
            }
        } else {
            stmt.close();
            return null;
        }
        stmt.close();
        return rows;
    }

    /**
     * Delete rows form table if condition true
     *
     * @param table table name
     * @param condition
     * @param limit limited of deleted rows
     * @return Row effected be query
     * @throws SQLException if sql is invalid
     */
    public static int delete(String table, String condition, int limit) throws SQLException {
        String query = "DELETE FROM `" + table.trim() + "` WHERE " + condition + " LIMIT " + limit;
        Statement stmt = App.createStatement();
        int resultInt = stmt.executeUpdate(query);
        stmt.close();
        return resultInt;
    }

    /**
     * Delete rows form table if condition true, default limit 30
     *
     * @param table
     * @param condition
     * @return
     * @throws SQLException
     */
    public static int delete(String table, String condition) throws SQLException {
        return delete(table, condition, 10);
    }

    /**
     * Delete row form table if condition true
     *
     * @param table
     * @param condition
     * @return
     * @throws SQLException
     */
    public static int deleteRow(String table, String condition) throws SQLException {
        return delete(table, condition, 1);
    }

    public final static void setCurrentCustomer(Object user) {
        App.bind("currentUser", user);
    }

    public final static Object getCurrentCustomer() {
        return App.get("currentUser");
    }
    /**
     * Database Driver name
     */
//    public final static String driver = "mysql";
//    /**
//     * Database name
//     */
//    public final static String databaseName = "onlineshopping";
//    /**
//     * Username
//     */
//    public final static String username = "root";
//
//    /**
//     * password
//     */
//    public final static String password = "YES";
//
//    /**
//     * Database port default 3306
//     */
//    public final static String port = "3306";

    /**
     * Database Driver name
     *
     * @param user
     */
    /**
     * Database Driver name
     */
    public final static String driver = "mysql";
    /**
     * Database name
     */
    public final static String databaseName = "dokan";
    /**
     * Username
     */
    public final static String username = "root";

    /**
     * password
     */
    public final static String password = "";

    /**
     * Database port default 3306
     */
    public final static String port = "3306";

    public ArrayList<String> getCategoryName() throws SQLException {
        ArrayList<String> category = new ArrayList<>();
        String sqlStatement = "SELECT * FROM category";
        ResultSet rs = createStatement().executeQuery(sqlStatement);
        while (rs.next()) {
            category.add(rs.getString("name"));
        }
        return category;
    }
}
