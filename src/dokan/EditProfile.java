/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import app.App;
import app.models.Customer;
import static dokan.Categories.carImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import shoponline.ShopOnline;

/**
 *
 * @author Mourad
 */
public class EditProfile extends Tools{

    
    public void display() throws FileNotFoundException, SQLException {
        Stage primaryStage = new Stage();
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
        //logo
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
        Rectangle menu = new Rectangle(1125, 0, 250, 800);
//        menu.setArcWidth(40);
//        menu.setArcHeight(40);
        menu.setStyle("-fx-fill: #222;");
        menu.setEffect(new DropShadow(80, Color.BLACK));
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

        root.getChildren().addAll(menu, ball1, ball2, ball3);
        Label[] l = new Label[3];
        l[1] = new Label("Home");

        l[2] = new Label("Logout");

        for (int set = 1; set < l.length; set++) {

            l[set].setLayoutX(1160);
            l[set].setLayoutY(900);
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
        for (int i = 1; i < l.length; i++) {
            root.getChildren().add(l[i]);
        }
        TranslateTransition[] lt = new TranslateTransition[9];
        for (int k = 1; k < l.length; k++) {
            lt[k] = new TranslateTransition();
        }
        for (int j = 1; j < l.length; j++) {

            lt[j].setNode(l[j]);
            lt[j].setToY(-(850 - (j * 90)));
            lt[j].setDuration(Duration.seconds(2));
            lt[j].play();
        }
        l[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                CustomerGui c = new CustomerGui();
                primaryStage.close();
                try {
                    c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        l[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                primaryStage.close();

                Home h = new Home();
                try {
                    h.start(primaryStage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        int x = 470, y = 130;

        Label l1 = new Label("Edit Profile");
        Label[] labels = new Label[10];
         texts = new TextField[10];
        CheckBox male = new CheckBox("MALE");
        CheckBox female = new CheckBox("FEMALE");
        Button submit = new Button("SUBMIT");
        Button back = new Button("BACK");

        l1.setLayoutX(550);
        l1.setLayoutY(-50);
        l1.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.ITALIC, 25));
        TranslateTransition regt1 = new TranslateTransition(Duration.millis(325));
        regt1.setNode(l1);
        regt1.setToY(80);
        regt1.setDuration(Duration.seconds(2));
        regt1.play();
        
        ShopOnline.init();
        Customer c = (Customer)App.getCurrentCustomer();
        String [] txt = new String[8];
        labels[0] = new Label("First Name");
        labels[1] = new Label("Address");
        labels[2] = new Label("Email");
        labels[3] = new Label("Password");
        labels[4] = new Label("Balance");
        labels[5] = new Label("Gender");
        labels[6] = new Label("Phone Number");
        labels[7] = new Label("SSN");
        texts[0] = new TextField(c.getName());
        texts[1] = new TextField(c.getAddress());
        texts[2] = new TextField(c.getEmail());
        texts[3] = new TextField(c.getPassword());
        texts[4] = new TextField(Double.toString(c.getBalance()));
        texts[5] = new TextField();
        texts[6] = new TextField(c.getPhone());
        texts[7] = new TextField(c.getSSN());
        for (int i = 0; i <= 7; i++) {
            texts[i].setStyle("-fx-background-radius: 20px ;");
            texts[i].setPrefWidth(250);
        }
        labels[0].setLayoutX(-200);
        labels[0].setLayoutY(y);
        labels[0].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition fnamet1 = new TranslateTransition(Duration.millis(325));
        fnamet1.setNode(labels[0]);
        fnamet1.setToX(670);
        fnamet1.setDuration(Duration.seconds(2));
        fnamet1.play();
        texts[0].setLayoutX(1500);
        texts[0].setLayoutY(y);
        TranslateTransition fnamet2 = new TranslateTransition(Duration.millis(325));
        fnamet2.setNode(texts[0]);
        fnamet2.setToX(-850);
        fnamet2.setDuration(Duration.seconds(2));
        fnamet2.play();
        labels[1].setLayoutX(-200);
        labels[1].setLayoutY(y + 60);
        labels[1].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition lnamet1 = new TranslateTransition(Duration.millis(325));
        lnamet1.setNode(labels[1]);
        lnamet1.setToX(670);
        lnamet1.setDuration(Duration.seconds(2));
        lnamet1.play();
        texts[1].setLayoutX(1500);
        texts[1].setLayoutY(y + 60);
        TranslateTransition lnamet2 = new TranslateTransition(Duration.millis(325));
        lnamet2.setNode(texts[1]);
        lnamet2.setToX(-850);
        lnamet2.setDuration(Duration.seconds(2));
        lnamet2.play();
        labels[2].setLayoutX(-200);
        labels[2].setLayoutY(y + 120);
        labels[2].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition emailt1 = new TranslateTransition(Duration.millis(325));
        emailt1.setNode(labels[2]);
        emailt1.setToX(670);
        emailt1.setDuration(Duration.seconds(2));
        emailt1.play();
        texts[2].setLayoutX(1500);
        texts[2].setLayoutY(y + 120);
        TranslateTransition emailt2 = new TranslateTransition(Duration.millis(325));
        emailt2.setNode(texts[2]);
        emailt2.setToX(-850);
        emailt2.setDuration(Duration.seconds(2));
        emailt2.play();
        labels[3].setLayoutX(-200);
        labels[3].setLayoutY(y + 180);
        labels[3].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition passt1 = new TranslateTransition(Duration.millis(325));
        passt1.setNode(labels[3]);
        passt1.setToX(670);
        passt1.setDuration(Duration.seconds(2));
        passt1.play();
        texts[3].setLayoutX(1500);
        texts[3].setLayoutY(y + 180);
        TranslateTransition passt2 = new TranslateTransition(Duration.millis(325));
        passt2.setNode(texts[3]);
        passt2.setToX(-850);
        passt2.setDuration(Duration.seconds(2));
        passt2.play();
        labels[4].setLayoutX(-200);
        labels[4].setLayoutY(y + 240);
        labels[4].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition aget1 = new TranslateTransition(Duration.millis(325));
        aget1.setNode(labels[4]);
        aget1.setToX(670);
        aget1.setDuration(Duration.seconds(2));
        aget1.play();
        texts[4].setLayoutX(1500);
        texts[4].setLayoutY(y + 240);
        TranslateTransition aget2 = new TranslateTransition(Duration.millis(325));
        aget2.setNode(texts[4]);
        aget2.setToX(-850);
        aget2.setDuration(Duration.seconds(2));
        aget2.play();
        labels[5].setLayoutX(-200);
        labels[5].setLayoutY(y + 300);
        labels[5].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition gendert1 = new TranslateTransition(Duration.millis(325));
        gendert1.setNode(labels[5]);
        gendert1.setToX(670);
        gendert1.setDuration(Duration.seconds(2));
        gendert1.play();
        male.setLayoutX(1500);
        male.setLayoutY(y + 300);
        TranslateTransition malet = new TranslateTransition(Duration.millis(325));
        malet.setNode(male);
        malet.setToX(-850);
        malet.setDuration(Duration.seconds(2));
        malet.play();
        female.setLayoutX(1500);
        female.setLayoutY(y + 300);
        TranslateTransition femalet = new TranslateTransition(Duration.millis(325));
        femalet.setNode(female);
        femalet.setToX(-780);
        femalet.setDuration(Duration.seconds(2));
        femalet.play();
        labels[6].setLayoutX(-200);
        labels[6].setLayoutY(y + 360);
        labels[6].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition numbert1 = new TranslateTransition(Duration.millis(325));
        numbert1.setNode(labels[6]);
        numbert1.setToX(670);
        numbert1.setDuration(Duration.seconds(2));
        numbert1.play();
        texts[6].setLayoutX(1500);
        texts[6].setLayoutY(y + 360);
        TranslateTransition numbert2 = new TranslateTransition(Duration.millis(325));
        numbert2.setNode(texts[6]);
        numbert2.setToX(-850);
        numbert2.setDuration(Duration.seconds(2));
        numbert2.play();
        labels[7].setLayoutX(-200);
        labels[7].setLayoutY(y + 420);
        labels[7].setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        TranslateTransition ssnt1 = new TranslateTransition(Duration.millis(325));
        ssnt1.setNode(labels[7]);
        ssnt1.setToX(670);
        ssnt1.setDuration(Duration.seconds(2));
        ssnt1.play();
        texts[7].setLayoutX(1500);
        texts[7].setLayoutY(y + 420);
        TranslateTransition ssnt2 = new TranslateTransition(Duration.millis(325));
        ssnt2.setNode(texts[7]);
        ssnt2.setToX(-850);
        ssnt2.setDuration(Duration.seconds(2));
        ssnt2.play();
        submit.setLayoutX(-200);
        submit.setLayoutY(y + 500);
        submit.setPrefWidth(200);
        submit.setStyle("-fx-background-radius: 20px ;");
        TranslateTransition submitt1 = new TranslateTransition(Duration.millis(325));
        submitt1.setNode(submit);
        submitt1.setToX(800);
        submitt1.setDuration(Duration.seconds(2));
        submitt1.play();
        HashMap<String ,Object> a=new HashMap<>();
        
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               txt[0] = texts[0].getText();
               txt[1] = texts[1].getText();
               txt[2] = texts[2].getText();
               txt[3] = texts[3].getText();
               txt[4] = texts[4].getText();
               txt[6] = texts[6].getText();
               txt[7] = texts[7].getText();
               
               a.put("name",txt[0]);
               a.put("address",txt[1]);
               a.put("email",txt[2]);
               a.put("password",txt[3]);
               a.put("balance",txt[4]);
               a.put("phone",txt[6]);
               a.put("SSN",txt[7]);
               
                try {
                    c.editProfile(a);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
                Profile p = new Profile();
                primaryStage.close();
                try {
                    p.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProfile.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        /*
        ("Address");
        labels[2] = new Label("Email");
        labels[3] = new Label("Password");
        labels[4] = new Label("Balance");
        labels[5] = new Label("Gender");
        labels[6] = new Label("Phone Number");
        labels[7] = new Label("SSN");
        */
        root.getChildren().addAll(l1, labels[0], labels[1], texts[0], texts[1], texts[2], texts[3], texts[4], male, female, submit,
                texts[6], texts[7], labels[2], labels[3], labels[4], labels[5], labels[6], labels[7]);

        back.setLayoutX(1500);
        back.setLayoutY(y + 500);
        TranslateTransition backt = new TranslateTransition(Duration.millis(325));
        backt.setNode(back);
        backt.setToX(-850);
        backt.setDuration(Duration.seconds(2));
        backt.play();
        Scene scene = new Scene(root);
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("EditProfile");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

}
