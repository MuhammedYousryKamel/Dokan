package dokan;

import app.models.Product;
import com.sun.prism.impl.Disposer.Record;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Mourad
 */
public class purshace extends Tools{

    TableView<Product> table = new TableView<>();
    Button del;

    public void display() throws FileNotFoundException {
         primaryStage = new Stage();
         root = new Group();
         sp = new ScrollPane();
        // background
        Image backgImage;
        String backgImagePath = "light.jpg";
        ImageView backg;
        backgImage = new Image(new FileInputStream(backgImagePath));
        backg = new ImageView(backgImage);
        backg.setX(-400);
        backg.setY(0);
        backg.setFitWidth(1800);

        backg.setPreserveRatio(true);
        backg.setSmooth(true);
        backg.setCache(true);
        root.getChildren().add(backg);
        Image image1 = new Image(new FileInputStream("Untitled-2.png"));

        ImageView iv1 = new ImageView();

        iv1.setImage(image1);
        iv1.setFitWidth(400);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        iv1.setX(0);
        iv1.setY(0);
        
                 
        root.getChildren().add(iv1);
        //table
        //table functions downaaaa

        TableColumn<Product, String> id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Product, String> name = new TableColumn("NAME");
        name.setMinWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Integer> price = new TableColumn("PRICE");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn delete = new TableColumn("Delete");
        delete.setMinWidth(100);
        delete.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, Button>, ObservableValue<Button>>() {

            @Override
            public ObservableValue<Button> call(
                    TableColumn.CellDataFeatures<Product, Button> arg0) {
                Product user = arg0.getValue();
                del = new Button("Delete");
                del.setOnAction(new EventHandler<ActionEvent>() {
                //int selected = table.getSelectionModel().getSelectedItems();
                    
                    @Override
                    public void handle(ActionEvent event) {
                        int selectedItem = table.getSelectionModel().getSelectedItem().getID();
                        ArrayList<HashMap<String,Object>> j = Categories.list;
        
                      int i = 0;
                       for(i=0;i<Categories.list.size();i++) {
               
                             int id = (int) Categories.list.get(i).get("ID");
//(int)obj.get("ID");    
                             if(selectedItem == id){
                                 Categories.list.remove(i);
                             }
                             //i++;
                    }      
                        deleteb();
                    }
                });
                return new SimpleObjectProperty<Button>(del);
            }
        });

        TableColumn quantity = new TableColumn("QUANTITY");
        quantity.setMinWidth(100);
        quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, TextField>, ObservableValue<TextField>>() {

            @Override
            public ObservableValue<TextField> call(
                    TableColumn.CellDataFeatures<Product, TextField> arg0) {
                Product user = arg0.getValue();
                TextField text = new TextField();

                return new SimpleObjectProperty<TextField>(text);
            }

             
        });
        //table functions
        table.getColumns().addAll(id, name, price, quantity, delete);
        table.setVisible(true);
        table.setTableMenuButtonVisible(true);

        sp.setContent(table);
        sp.setPrefSize(500, 500);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setLayoutX(350);
        sp.setLayoutY(100);
        sp.setFitToHeight(true);
        table.getStyleClass().add("table");
        sp.getStyleClass().add("sp");

        root.getChildren().addAll(table, sp);

        try {
            //        root.getChildren().add();
            table.setItems(buildData());
        } catch (SQLException ex) {
            Logger.getLogger(purshace.class.getName()).log(Level.SEVERE, null, ex);
        }

        Label[] b = new Label[4];
        b[1] = new Label("ADD More");
        b[2] = new Label("CheckOut");
        b[3] = new Label("Cancel Order");
        b[1].setLayoutX(980);
        b[1].setLayoutY(350);
        b[1].setTextFill(Color.web("white"));
        b[1].setFont(Font.font("Copperplate Gothic Light", 20));
        b[2].setLayoutX(980);
        b[2].setLayoutY(450);
        b[2].setTextFill(Color.web("white"));
        b[2].setFont(Font.font("Copperplate Gothic Light", 20));
        b[3].setLayoutX(960);
        b[3].setLayoutY(550);
        b[3].setTextFill(Color.web("white"));
        b[3].setFont(Font.font("Copperplate Gothic Light", 20));

        b[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                Categories c = new Categories();
                primaryStage.close();
                try {
                    c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(purshace.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(purshace.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        b[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                CheckOut co = new CheckOut();
                primaryStage.close();
                try {
                    co.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(purshace.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        b[3].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                Categories.list.clear();
                CustomerGui c = new CustomerGui();
                primaryStage.close();
                try {
                    c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(purshace.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        b[1].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent t) {
                b[1].setTextFill(Color.web("#222"));
            }
        });
        b[1].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                b[1].setTextFill(Color.web("white"));
            }
        });

        b[2].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                b[2].setTextFill(Color.web("#222"));
            }
        });
        b[2].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                b[2].setTextFill(Color.web("white"));
            }
        });
        b[3].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                b[3].setTextFill(Color.web("#222"));
            }
        });
        b[3].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                b[3].setTextFill(Color.web("white"));
            }
        });
        for (int j = 1; j <= 3; j++) {
            root.getChildren().add(b[j]);
        }

        Scene scene = new Scene(root, Color.PERU);
        scene.getStylesheets().add("customer.css");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Purshace");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public void deleteb() {
        ObservableList<Product> productselected, allproducts;
        allproducts = table.getItems();
        productselected = table.getSelectionModel().getSelectedItems();
        productselected.forEach(allproducts::remove);
    }
    
    public ObservableList<Product> buildData() throws SQLException{        
   ObservableList<Product> data = FXCollections.observableArrayList();
            Product cs = new Product();  
        ArrayList<HashMap<String,Object>> j = Categories.list;
        
         
         for(HashMap<String, Object> obj : j) {
               
               data.add(new Product((int)obj.get("ID"),(String)obj.get("name"), (int) obj.get("price"),(String)obj.get("description")));
               
          }      
             return data;        
}
    /*public ObservableList<Product> getproduct() {
        ObservableList<product> products = FXCollections.observableArrayList();
        products.add(new product(1, "samsung 4", "5000", "This is the details"));
        products.add(new product(2, "IPHONE 5", "3000", "This is the details,"));
        products.add(new product(3, "LCD", "5000", "This is the details,"));
        products.add(new product(4, "GOLD", "6000", "This is the details"));
        products.add(new product(5, "BMW", "1000", "This is the details"));
        products.add(new product(5, "BMW", "1000", "This is the details"));
        return products;
    }*/

}
