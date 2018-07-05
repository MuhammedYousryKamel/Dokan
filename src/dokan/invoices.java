/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import app.models.Invoice;
import app.models.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Mourad
 */
public class invoices extends Tools {
static TextField text; 
static int i = 0;
     void display() throws FileNotFoundException {
        Stage window = new Stage();
        Group root = new Group();
        // background
        Image backgImage;
        String backgImagePath = "light.jpg";
        ImageView backg;
        backgImage = new Image(new FileInputStream(backgImagePath));
        backg = new ImageView(backgImage);
        backg.setX(-375);
        backg.setY(0);
        backg.setFitWidth(1800);
        Button home = new Button();
        home.setText("home");
        home.setLayoutX(230);
        home.setLayoutY(450);
        home.setStyle("-fx-background-radius:20px;");
        Button print = new Button();
        print.setText("print");
        print.setLayoutX(180);
        print.setLayoutY(450);
        print.setStyle("-fx-background-radius:20px;");
        backg.setPreserveRatio(true);
        backg.setSmooth(true);
        backg.setCache(true);
        root.getChildren().add(backg);
        root.getChildren().addAll(home, print);
        //logo
        Image image1 = new Image(new FileInputStream("Untitled-2.png"));
        TextField emailtext = new TextField();
        TextField passtext = new TextField();
        ImageView iv1 = new ImageView();

        iv1.setImage(image1);
        iv1.setFitWidth(200);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        iv1.setX(0);
        iv1.setY(0);
        root.getChildren().add(iv1);
// first table for product
        ScrollPane sp = new ScrollPane();
        TableView<Product> table = new TableView<>();
        TableColumn<Product, String> id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Product, String> name = new TableColumn("NAME");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Integer> price = new TableColumn("PRICE");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantity = new TableColumn("QUANTITY");
        quantity.setMinWidth(100);
        quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, TextField>, ObservableValue<TextField>>() {

            @Override
            public ObservableValue<TextField> call(
                    TableColumn.CellDataFeatures<Product, TextField> arg0) {
                Product user = arg0.getValue();
                 text = new TextField();
                text.setEditable(false);
                if( i < Categories.list.size() + 1)
                {
                
                }
                return new SimpleObjectProperty<TextField>(text);
            }
        });
        home.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Categories.list.clear();
                window.close();
                try {

                    CustomerGui c = new CustomerGui();
                    c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(invoices.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        //table functions
        table.getColumns().addAll(id, name, quantity, price);
        table.setTableMenuButtonVisible(true);
    try {
        table.setItems(buildData());
    } catch (SQLException ex) {
        Logger.getLogger(invoices.class.getName()).log(Level.SEVERE, null, ex);
    }
        table.setVisible(true);
        table.getStyleClass().add("table");
        sp.getStyleClass().add("sp");
        sp.setContent(table);
        sp.setPrefSize(500, 300);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setLayoutX(0);
        sp.setLayoutY(50);
        sp.setFitToHeight(true);
        root.getChildren().addAll(table, sp);
        // second for bill
        TableView<Invoice> tableb = new TableView<>();
        ScrollPane spb = new ScrollPane();
       

        

        TableColumn<Invoice, Integer> priceb = new TableColumn("Total");
        priceb.setMinWidth(500);
        priceb.setCellValueFactory(new PropertyValueFactory<>("total_price"));

        //table functions
        tableb.getColumns().addAll(priceb);
        tableb.setTableMenuButtonVisible(true);
    try {
        tableb.setItems(buildData2());
    } catch (SQLException ex) {
        Logger.getLogger(invoices.class.getName()).log(Level.SEVERE, null, ex);
    }
        tableb.setVisible(true);
        spb.setContent(tableb);
        spb.setPrefSize(500, 70);
        spb.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        spb.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        spb.setLayoutX(0);
        spb.setLayoutY(360);
        spb.setFitToHeight(true);
        tableb.getStyleClass().add("table");
        spb.getStyleClass().add("sp");
        root.getChildren().addAll(tableb, spb);

        Scene scene = new Scene(root, 500, 500, Color.LIGHTGRAY);
        scene.getStylesheets().add("customer.css");
        window.setTitle("Invoice");
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public ObservableList<Product> buildData() throws SQLException {
        ObservableList<Product> data = FXCollections.observableArrayList();
        ArrayList<HashMap<String, Object>> j = Categories.list;

        for (HashMap<String, Object> obj : j) {

            data.add(new Product((int) obj.get("ID"), (String) obj.get("name"), (int) obj.get("price"), (String) obj.get("description")));

        }
        return data;
    }
    public ObservableList<Invoice> buildData2() throws SQLException {
        ObservableList<Invoice> data = FXCollections.observableArrayList();
        

       

            data.add(new Invoice(CheckOut.total));

        
        return data;
    }

    public static ObservableList<product> getproduct1() {
        ObservableList<product> products = FXCollections.observableArrayList();
        products.add(new product(1, "50.E", "200L.E", "150L.E"));

        return products;
    }
}
