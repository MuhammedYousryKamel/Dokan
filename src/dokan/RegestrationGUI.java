package dokan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import app.models.Guest;
import app.models.Validation;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import shoponline.ShopOnline;

public class RegestrationGUI extends Tools {

    public static void display() throws FileNotFoundException, SQLException {
        int x = 470, y = 130;
        Stage primaryStage = new Stage();
        primaryStage.setFullScreen(true);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.setMinWidth(250);

        Label l1 = new Label("Registration Form");
        Label[] labels = new Label[10];
        TextField[] texts = new TextField[7];
        CheckBox male = new CheckBox("MALE");
        CheckBox female = new CheckBox("FEMALE");
        Button submit = new Button("SUBMIT");
        Button back = new Button("BACK");
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

        backg.setPreserveRatio(true);
        backg.setSmooth(true);
        backg.setCache(true);
        root.getChildren().add(backg);
        // logo
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
        Scene scene = new Scene(root, Color.PERU);
        l1.setLayoutX(550);
        l1.setLayoutY(-50);
        l1.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.ITALIC, 25));
        TranslateTransition regt1 = new TranslateTransition(Duration.millis(325));
        regt1.setNode(l1);
        regt1.setToY(80);
        regt1.setDuration(Duration.seconds(2));
        regt1.play();

        labels[0] = new Label("User Name");
        labels[1] = new Label("Email");
        labels[2] = new Label("Balance");
        labels[3] = new Label("Password");
        labels[4] = new Label("SSN");
        labels[5] = new Label(" Phone Number");
        labels[6] = new Label("Address");

        texts[0] = new TextField();
        texts[1] = new TextField();
        texts[2] = new TextField();
        texts[3] = new TextField();
        texts[4] = new TextField();
        texts[5] = new TextField();
        texts[6] = new TextField();

        for (int i = 0; i < 7; i++) {
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
        texts[5].setLayoutX(1500);
        texts[5].setLayoutY(y + 300);
        TranslateTransition numbert2 = new TranslateTransition(Duration.millis(325));
        numbert2.setNode(texts[6]);
        numbert2.setToX(-850);
        numbert2.setDuration(Duration.seconds(2));
        numbert2.play();

        TranslateTransition ssnt1 = new TranslateTransition(Duration.millis(325));
        ssnt1.setNode(labels[7]);
        ssnt1.setToX(670);
        ssnt1.setDuration(Duration.seconds(2));
        ssnt1.play();
        texts[6].setLayoutX(1500);
        texts[6].setLayoutY(y + 360);
        TranslateTransition ssnt2 = new TranslateTransition(Duration.millis(325));
        ssnt2.setNode(texts[5]);
        ssnt2.setToX(-850);
        ssnt2.setDuration(Duration.seconds(2));
        ssnt2.play();
        submit.setLayoutX(-200);
        submit.setLayoutY(y + 500);
        submit.setStyle("-fx-background-radius: 20px ;");
        submit.setPrefWidth(150);
        TranslateTransition submitt1 = new TranslateTransition(Duration.millis(325));
        submitt1.setNode(submit);
        submitt1.setToX(950);
        submitt1.setDuration(Duration.seconds(2));
        submitt1.play();
        root.getChildren().addAll(l1, labels[0], labels[1], texts[0], texts[1], texts[2], texts[3], texts[4], submit, back,
                texts[5], texts[6], labels[2], labels[3], labels[4], labels[5], labels[6]);
        ShopOnline.init();
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                primaryStage.close();
                Home u = new Home();
                try {
                    u.start(primaryStage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegestrationGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(RegestrationGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Guest g = new Guest();

                if (Validation.validate_string(".+", texts[0].getText())) {
                    if (Validation.validate_string(".+[@].+[.com]", texts[1].getText())) {
                        if (Validation.validate_string("^[1-9][0-9]*", texts[2].getText())) {
                            if (Validation.validate_string(".+.+.+.+.+.+", texts[3].getText())) {
                                String s = texts[4].getText();
                                if (s.length() == 14) {
                                    if (Validation.validate_string("[2][0-9]*", texts[4].getText())) {
                                        String r = texts[5].getText();
                                        if (r.length() == 11) {
                                            if (Validation.validate_string("[0-9]*", texts[5].getText())) {
                                                if (Validation.validate_string(".+", texts[6].getText())) {
                                                    try {
                                                        g.register(texts[0].getText(), texts[1].getText(), Integer.parseInt(texts[2].getText()), texts[3].getText(), texts[4].getText(), texts[5].getText(), texts[6].getText(), 1);
                                                    } catch (SQLException ex) {
                                                        Logger.getLogger(RegestrationGUI.class.getName()).log(Level.SEVERE, null, ex);
                                                        //System.out.println("muhammad");
                                                    }
                                                } else {
                                                    Validation.showalert("Error Message", "Address", "You should enter your address", Alert.AlertType.ERROR);
                                                }
                                            } else {
                                                Validation.showalert("Error Message", "Phone", "phone must be numbers", Alert.AlertType.ERROR);
                                            }
                                        } else {
                                            Validation.showalert("Error Message", "Phone", "you should enter 11 number", Alert.AlertType.ERROR);
                                        }
                                    } else {
                                        Validation.showalert("Error Message", "SSN", "you should start with 2 followed by 13 number", Alert.AlertType.ERROR);
                                    }
                                } else {
                                    Validation.showalert("Error Message", "SSN", "you should enter 14 number", Alert.AlertType.ERROR);
                                }
                            } else {
                                Validation.showalert("Error Message", "Password", "password must be at least 6 digit", Alert.AlertType.ERROR);
                            }
                        } else {
                            Validation.showalert("Error Message", "balance", "you should enter balance", Alert.AlertType.ERROR);
                        }
                    } else {
                        Validation.showalert("Error Message", "Email", "Invalid email", Alert.AlertType.ERROR);
                    }

                } ///////////////////////
                else {
                    Validation.showalert("Error Message", "Username", "you should enter user name", Alert.AlertType.ERROR);
                }

                primaryStage.close();
                Home u = new Home();
                try {
                    u.start(primaryStage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RegestrationGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(RegestrationGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });
        back.setLayoutX(1500);
        back.setLayoutY(y + 500);
        back.setStyle("-fx-background-radius: 20px ;");
        back.setPrefWidth(150);
        TranslateTransition backt = new TranslateTransition(Duration.millis(325));
        backt.setNode(back);
        backt.setToX(-1050);
        backt.setDuration(Duration.seconds(2));
        backt.play();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Registration");
        primaryStage.show();

    }

}
