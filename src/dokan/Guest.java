/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import app.models.Offer;
import app.models.Product;
import static dokan.CustomerGui.logoImage;
import static dokan.CustomerGui.searchImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import static java.lang.reflect.Array.set;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mourad
 */
public class Guest extends Tools{

    Label[] l = new Label[8];
    public int set;
    // feedback 
    Button submit = new Button();
    TextField emailt = new TextField("Enter your Email");
    TextArea feedbackt = new TextArea("Enter your Feedback");
    Label email = new Label("Email");
    Label feedback = new Label("feedback");

    public void feedbackfun(boolean fb) {
        emailt.setVisible(fb);
        email.setVisible(fb);
        feedback.setVisible(fb);
        feedbackt.setVisible(fb);
        submit.setVisible(fb);
    }
// search
    Button search = new Button();
    TextField searchfd = new TextField("Search");
    Label searchlb = new Label("Search");
    public static Image searchImage;
    private String searchImagePath = "search.png";
    public ImageView searchi;
    public static Image logoImage;
    private String logoImagePath = "Untitled-2.png";
    public ImageView logo;

    public void searchfun(boolean sr) {
        searchi.setVisible(sr);
        searchfd.setVisible(sr);
        searchlb.setVisible(sr);
        search.setVisible(sr);
    }

    public void dispaly() throws FileNotFoundException {
Stage   primaryStage = new Stage();
        root = new Group();

        // background
        Image backgImage;
        String backgImagePath = "light.jpg";
        ImageView backg;
        backgImage = new Image(new FileInputStream(backgImagePath));
        backg = new ImageView(backgImage);
        backg.setX(-400);
        backg.setY(00);
        backg.setFitWidth(1800);

        backg.setPreserveRatio(true);
        backg.setSmooth(true);
        backg.setCache(true);
        root.getChildren().add(backg);
        //feedback
        submit.setText("Submit");
        submit.setLayoutX(580);
        submit.setLayoutY(710);
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

            }
        });
        emailt.setLayoutY(450);
        emailt.setLayoutX(160);
        emailt.setPrefWidth(300);
        emailt.setStyle("-fx-background-radius:20px;");

        email.setTextFill(Color.web("black"));
        email.setFont(Font.font("Copperplate Gothic Light", 20));
        email.setLayoutY(450);
        email.setLayoutX(20);
        feedbackt.setLayoutY(520);

        feedbackt.setLayoutX(160);
        feedbackt.setStyle("-fx-background-radius:20px;");
        feedback.setTextFill(Color.web("black"));
        feedback.setFont(Font.font("Copperplate Gothic Light", 20));
        feedback.setLayoutY(520);
        feedback.setLayoutX(20);
        submit.setStyle("-fx-background-radius:20px;");
        root.getChildren().add(submit);
        root.getChildren().add(email);
        root.getChildren().add(emailt);
        root.getChildren().add(feedback);
        root.getChildren().add(feedbackt);
      // offers 
        //table
        TableView<Offer> table = new TableView<>();
        ScrollPane sp = new ScrollPane();
        ScrollPane sp2 = new ScrollPane();
        
        TableColumn<Offer, String> id = new TableColumn("ID");
        id.setMinWidth(200);
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Offer, Integer> price = new TableColumn("Discount_price");
        price.setMinWidth(200);
        price.setCellValueFactory(new PropertyValueFactory<>("discount_price"));
        //table functions
        table.getColumns().addAll(id, price);
        table.setVisible(false);
        table.setTableMenuButtonVisible(true);
        try {
            table.setItems(buildData());
        } catch (SQLException ex) {
            Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.getStyleClass().add("table");

        sp.getStyleClass().add("sp");
        sp.setContent(table);
        sp.setPrefSize(400, 250);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setLayoutX(20);
        sp.setLayoutY(200);
        sp.setFitToHeight(false);
        sp.setVisible(false);

        root.getChildren().addAll(table, sp);
 
        // search
        searchImage = new Image(new FileInputStream(searchImagePath));
        searchi = new ImageView(searchImage);
        search.setText("");
       
        search.setPrefWidth(30);
        searchlb.setTextFill(Color.web("black"));
        searchlb.setFont(Font.font("Copperplate Gothic Light", 35));
        searchlb.setLayoutY(190);
        searchlb.setLayoutX(20);
        searchfd.setLayoutY(200);
        searchfd.setLayoutX(220);
        searchfd.setPrefWidth(200);
        searchfd.getStyleClass().add("searchfd");
//        searchfd.setStyle("-fx-border-radius:20px");
        searchi.setX(390);
        searchi.setY(202);
        searchi.setFitWidth(20);
        searchi.setPreserveRatio(true);
        searchi.setSmooth(true);
        searchi.setCache(true);
        
        TableView<Product> table2 = new TableView<>();
        TableColumn<Product, String> Id = new TableColumn("ID");
        Id.setMinWidth(100);
        Id.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Product, String> Name = new TableColumn("NAME");
        Name.setMinWidth(100);
        Name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Integer> Price = new TableColumn("PRICE");
        Price.setMinWidth(100);
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> details = new TableColumn("DETAILS");
        details.setMinWidth(350);
        details.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        table2.getColumns().addAll(Id, Name, Price,details);
        table2.setVisible(false);
        table2.setTableMenuButtonVisible(true);
        table2.getStyleClass().add("table");
        
        sp2.getStyleClass().add("sp");
        sp2.setContent(table2);
        sp2.setPrefSize(600, 250);
        sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp2.setLayoutX(20);
        sp2.setLayoutY(300);
        sp2.setFitToHeight(false);
        sp2.setVisible(false);
        
        root.getChildren().add(searchlb);
        root.getChildren().add(searchfd);
        root.getChildren().add(searchi);
        root.getChildren().addAll(sp2,table2);
        logoImage = new Image(new FileInputStream(logoImagePath));
        logo = new ImageView(logoImage);
        logo.setX(0);
        logo.setY(0);
        logo.setFitWidth(400);
        logo.setPreserveRatio(true);
        logo.setSmooth(true);
        logo.setCache(true);
        root.getChildren().add(logo);
     // Customer Home
        Rectangle categorybox = new Rectangle(1125, 0, 250, 850);
//        categorybox.setArcWidth(30);
//        categorybox.setArcHeight(30);

        categorybox.setStyle("-fx-fill: #222;");
        categorybox.setEffect(new DropShadow(70, Color.BLACK));
        Rectangle ball1 = new Rectangle(1250, 20, 30, 30);
        ball1.setArcWidth(40);
        ball1.setArcHeight(40);
        ball1.setStyle("-fx-fill: yellow;");
        ball1.setEffect(new DropShadow(30, Color.YELLOW));
        Rectangle ball2 = new Rectangle(1200, 20, 30, 30);
        ball2.setArcWidth(40);
        ball2.setArcHeight(40);
        ball2.setStyle("-fx-fill: orange;");
        ball2.setEffect(new DropShadow(30, Color.ORANGE));
        Rectangle ball3 = new Rectangle(1150, 20, 30, 30);
        ball3.setArcWidth(40);
        ball3.setArcHeight(40);
        ball3.setStyle("-fx-fill: red;");
        ball3.setEffect(new DropShadow(30, Color.RED));
        root.getChildren().add(categorybox);
        root.getChildren().addAll(ball1, ball2, ball3);

        // labels of  categories
        l[1] = new Label("Home");

        l[2] = new Label("search");

        l[3] = new Label("Show Offers");

        l[4] = new Label("Categories");

        l[5] = new Label("Contact Us");

        l[6] = new Label("Feedback");

        l[7] = new Label("Back");

        for (set = 1; set < l.length; set++) {

            l[set].setLayoutX(1160);
            l[set].setLayoutY(800);
            l[set].setTextFill(Color.web("WHITESMOKE"));
            l[set].setFont(Font.font("Copperplate Gothic Light", 20));

            int x = set;

            l[x].setOnMouseEntered(e -> {

                l[x].setTextFill(Color.web("#5BAAEC"));

            });

            l[x].setOnMouseExited(e -> {

                l[x].setTextFill(Color.web("WHITESMOKE"));

            });

        }

       

        for (int i = 1; i <= 7; i++) {
            root.getChildren().add(l[i]);
        }
        TranslateTransition[] lt = new TranslateTransition[9];
        for (int k = 1; k <= 7; k++) {
            lt[k] = new TranslateTransition();
        }
        for (int j = 1; j <= 7; j++) {

            lt[j].setNode(l[j]);
            lt[j].setToY(-(750 - (j * 90)));
            lt[j].setDuration(Duration.seconds(2));
            lt[j].play();
        }
        searchi.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {

                String s = searchfd.getText();
                sp2.setVisible(true);
                table2.setVisible(true);
                try {
                    table2.setItems(buildData2(s));
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        l[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                searchfun(false);
                feedbackfun(false);
                table.setVisible(false);
                sp.setVisible(false);
            }
        });
        l[6].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                feedbackfun(true);
                searchfun(false);
                table.setVisible(false);
                sp.setVisible(false);
            }
        });
        l[5].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {

                try {
                    try {
                        ContactUs.display();
                    } catch (SQLException ex) {
                        Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        l[4].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                GuestCategories v = new GuestCategories();
                primaryStage.close();
                try {
                    v.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        l[3].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                searchfun(false);
                feedbackfun(false);
                table.setVisible(true);
                sp.setVisible(true);
                table2.setVisible(false);
                sp2.setVisible(false);
            }
        });
        l[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                
                 searchfun(true);
                feedbackfun(false);
                table.setVisible(false);
                sp.setVisible(false);
                table2.setVisible(false);
                sp2.setVisible(false);
            }
        });
        l[7].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                primaryStage.close();
                Home h = new Home();
                try {
                    h.start(primaryStage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Guest.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        search.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
//             primaryStage.setScene(scene2);
                System.out.println("OK");

            }
        });

        feedbackfun(false);
        searchfun(false);
           Scene scene = new Scene(root, Color.web("#837D7D"));
        scene.getStylesheets().add("customer.css");
       
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    
    

    public ObservableList<product> getproduct() {
        ObservableList<product> products = FXCollections.observableArrayList();
        products.add(new product(1, "samsung 4", "50%", "this is details"));
        products.add(new product(2, "IPHONE 5", "20%", "this is details"));
        products.add(new product(3, "LCD", "30%", "this is details"));
        products.add(new product(4, "GOLD", "10%", "this is details"));
        products.add(new product(5, "BMW", "5%", "this is details"));
        products.add(new product(5, "BMW", "35%", "this is details"));
        return products;
    }
      public ObservableList<Offer> buildData() throws SQLException{        
   ObservableList<Offer> data = FXCollections.observableArrayList();
            Offer cs = new Offer();  
        ArrayList<HashMap<String,Object>> j = cs.showOffer();
         for(HashMap<String, Object> obj : j) {
               data.add(new Offer((int)obj.get("ID"), (int) obj.get("discount_price")));
          }      
             return data;             
}
    public ObservableList<Product> buildData2(String name) throws SQLException{        
   ObservableList<Product> data = FXCollections.observableArrayList();
            Product cs = new Product();  
        ArrayList<HashMap<String,Object>> j = cs.search(name);
         for(HashMap<String, Object> obj : j) {
               data.add(new Product((int)obj.get("ID"),(String)obj.get("name"), (int) obj.get("price"),(String)obj.get("description")));
          }      
             return data;     
}

}
