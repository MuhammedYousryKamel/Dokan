/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import app.App;
import app.models.Customer;
import app.models.Invoice;
import static dokan.invoices.getproduct1;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;
import shoponline.ShopOnline;
import sun.security.util.Password;

/**
 *
 * @author Mourad
 */
public class CheckOut {

    public static Image paypallImage;
    private String paypallImagePath = "Paypal (1).jpg";
    public ImageView paypall;
   static double total;
   Invoice v = new Invoice();
    public void display() throws FileNotFoundException {
        Stage primaryStage = new Stage();
        Group root = new Group();
        // background
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

        Label print = new Label();
        print.setText("DO you want invoice ?");
        Button pay = new Button();
        pay.setText("Pay");
        Button yes = new Button();
        yes.setText("Yes");
        Button no = new Button();
        no.setText("No");
        PasswordField paynum = new PasswordField();
        paynum.setPromptText("paypal number...");
        Label info = new Label();
        info.setText("Enter Your PayPal Number Please !");
        try {
            ShopOnline.init();
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        Customer c = (Customer)App.getCurrentCustomer();
        
        pay.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                no.setVisible(true);
                yes.setVisible(true);
                print.setVisible(true);
                try {
                  v =  Invoice.add(Categories.list,c.getID() ,"VISA");
                  total = v.getTotal_price();
                } catch (Exception ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });

        pay.setLayoutX(1250);
        pay.setLayoutY(500);
        print.setLayoutX(100);
        print.setLayoutY(650);
        yes.setLayoutX(100);
        yes.setLayoutY(700);

        yes.setStyle("-fx-background-radius:20px;");
        no.setLayoutX(200);
        no.setLayoutY(700);

        no.setStyle("-fx-background-radius:20px;");
        paynum.setLayoutX(100);
        paynum.setLayoutY(650);
        paynum.setPrefSize(250, 25);
        paynum.setStyle("-fx-background-radius:20px;");
//         info.set
//          paynum.setTextFill(Color.web("crimson"));
        pay.setFont(Font.font("cursive", 20));
        pay.setStyle("-fx-background-radius:20px;");
        paynum.setFont(Font.font("cursive", 20));
        yes.setFont(Font.font("cursive", 20));

        no.setFont(Font.font("cursive", 20));
        info.setLayoutX(100);
        info.setLayoutY(0);
        print.setTextFill(Color.web("black"));
        print.setFont(Font.font("Copperplate Gothic Light", 25));
        info.setTextFill(Color.web("black"));
        info.setFont(Font.font("Copperplate Gothic Light", 32));

        yes.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                try {
                    invoices v = new invoices();
                    v.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        no.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Categories.list.clear();
                primaryStage.close();
                try {
                   
                   CustomerGui c = new CustomerGui();
                   c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        TranslateTransition payt = new TranslateTransition(Duration.millis(325));
        payt.setNode(pay);
        payt.setToX(-850);
        payt.setDuration(Duration.seconds(2));
        payt.play();

        TranslateTransition paynumt = new TranslateTransition(Duration.millis(325));
        paynumt.setNode(paynum);
        paynumt.setToY(-150);
        paynumt.setDuration(Duration.seconds(2));
        paynumt.play();

        TranslateTransition infot = new TranslateTransition(Duration.millis(325));
        infot.setNode(info);
        infot.setToY(425);
        infot.setDuration(Duration.seconds(2));
        infot.play();

        no.setVisible(false);
        yes.setVisible(false);
        print.setVisible(false);
        root.getChildren().add(pay);
        root.getChildren().add(yes);
        root.getChildren().add(no);
        root.getChildren().add(print);
        root.getChildren().add(paynum);
        root.getChildren().add(info);
        
        
        paypallImage = new Image(new FileInputStream(paypallImagePath));
        paypall = new ImageView(paypallImage);

        paypall.setX(100);
        paypall.setY(-300);
        root.getChildren().add(paypall);
        TranslateTransition paypallt = new TranslateTransition(Duration.millis(325));
        paypallt.setNode(paypall);
        paypallt.setToY(400);
        paypallt.setDuration(Duration.seconds(3));
        paypallt.play();
//        Screen screen = Screen.getPrimary();
//        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
        // second for bill
        TableView<product> tableb = new TableView<>();
        ScrollPane spb = new ScrollPane();
        TableColumn<product, String> idb = new TableColumn("SubTotal");
        idb.setMinWidth(200);
        idb.setCellValueFactory(new PropertyValueFactory<>("Pdetails"));

        TableColumn<product, String> nameb = new TableColumn("Taxes");
        nameb.setMinWidth(150);
        nameb.setCellValueFactory(new PropertyValueFactory<>("Pname"));

        TableColumn<product, Integer> priceb = new TableColumn("Total");
        priceb.setMinWidth(150);
        priceb.setCellValueFactory(new PropertyValueFactory<>("Pprice"));

        //table functions
        tableb.getColumns().addAll(idb, nameb, priceb);
        tableb.setTableMenuButtonVisible(true);
        tableb.setItems(getproduct1());
        tableb.setVisible(true);
        spb.setContent(tableb);
        spb.setPrefSize(500, 70);
        spb.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        spb.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        spb.setLayoutX(800);
        spb.setLayoutY(450);
        spb.setFitToHeight(true);
        tableb.getStyleClass().add("table");
        spb.getStyleClass().add("sp");
        root.getChildren().addAll(tableb, spb);
        Scene scene = new Scene(root);

        scene.getStylesheets().add("customer.css");

//        root.set(new Background(new BackgroundFill(Color.BLUE , CornerRadii.EMPTY , javafx.geometry.Insets.EMPTY)) );
//primaryStage.setX(bounds.getMinX());
//primaryStage.setY(bounds.getMinY());
//primaryStage.setWidth(bounds.getWidth());
//primaryStage.setHeight(bounds.getHeight());
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Check Out");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
