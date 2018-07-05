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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import shoponline.ShopOnline;

/**
 *
 * @author Mourad
 */
public class Profile extends Tools {

    TableView<product> table = new TableView<>();
    Button del;

    ScrollPane sp = new ScrollPane();
    public static Image proImage;
    private String proImagePath = "pp1.png";
    public ImageView pro;

    public void display() throws FileNotFoundException, SQLException {
        primaryStage = new Stage();
        root = new Group();
        
        // background
        Image backgImage;
        String backgImagePath = "light2.jpg";
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

        proImage = new Image(new FileInputStream(proImagePath));
        pro = new ImageView(proImage);

        pro.setX(625);
        pro.setY(250);
        pro.setFitWidth(200);
        pro.setFitHeight(300);

        pro.setPreserveRatio(true);
        pro.setSmooth(true);
        pro.setCache(true);
        

        pro.setEffect(new DropShadow(60, Color.BLACK));
//        pro.setStyle("-fx-border-style:solid;-fx-border-width : 4;-fx-border-color: whitesmoke; -fx-background-radius: 45 ;");
        root.getChildren().add(pro);

        Label[] l = new Label[6];
        Label[] info = new Label[5];
        l[1] = new Label("Home");

        l[2] = new Label("My Invoices");

        l[3] = new Label("Edit Profile");

        l[4] = new Label("Contact Us");

        l[5] = new Label("Logout");

        for (int set = 1; set < l.length; set++) {

            l[set].setLayoutX(1160);
            l[set].setLayoutY(900);
            l[set].setTextFill(Color.WHITESMOKE);
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
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        l[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                sp.setVisible(true);
                table.setVisible(true);

            }
        });
        l[3].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                primaryStage.close();

                EditProfile e = new EditProfile();
                try {
                    e.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        l[4].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {

                try {
                    try {
                        ContactUs.display();
                    } catch (SQLException ex) {
                        Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        l[5].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                primaryStage.close();

                Home h = new Home();
                try {
                    h.start(primaryStage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        ShopOnline.init();
       Customer c = (Customer)App.getCurrentCustomer();
        
        info[0] = new Label(c.getName());
        info[1] = new Label(c.getEmail());

        info[2] = new Label(c.getAddress());

        info[3] = new Label(c.getPhone());

        info[4] = new Label(c.getSSN());

        for (int setinfo = 0; setinfo <= 4; setinfo++) {

            info[setinfo].setLayoutX(100);
            info[setinfo].setLayoutY(900);
            info[setinfo].setTextFill(Color.BLACK);
            info[setinfo].setFont(Font.font("Copperplate Gothic Light", 20));

        }
        for (int iinfo = 0; iinfo <= 4; iinfo++) {
            root.getChildren().add(info[iinfo]);
        }
        TranslateTransition[] infot = new TranslateTransition[9];
        for (int kinfo = 0; kinfo <= 4; kinfo++) {
            infot[kinfo] = new TranslateTransition();
        }
        for (int jinfo = 0; jinfo <= 4; jinfo++) {

            infot[jinfo].setNode(info[jinfo]);
            infot[jinfo].setToY(-(650 - (jinfo * 90)));
            infot[jinfo].setDuration(Duration.seconds(2));
            infot[jinfo].play();
        }

        //table
        //table functions down
        TableColumn<product, String> id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(new PropertyValueFactory<>("Pid"));

        TableColumn<product, String> name = new TableColumn("DATE");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("Pname"));

        TableColumn<product, Integer> price = new TableColumn("TOTAL");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("Pprice"));

        TableColumn delete = new TableColumn("Show");
        delete.setMinWidth(100);
        delete.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<product, Button>, ObservableValue<Button>>() {

            @Override
            public ObservableValue<Button> call(
                    TableColumn.CellDataFeatures<product, Button> arg0) {
                product user = arg0.getValue();
                del = new Button("Show");
                del.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {

                        try {
                            invoices v = new invoices();
                            v.display();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                return new SimpleObjectProperty<Button>(del);
            }
        });

        //table functions
        table.setVisible(false);
        table.getColumns().addAll(id, name, price, delete);
        table.setVisible(true);
        table.setTableMenuButtonVisible(true);
        table.getStyleClass().add("table");
        sp.getStyleClass().add("sp");
        sp.setVisible(false);
        sp.setContent(table);
        sp.setPrefSize(500, 250);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setLayoutX(625);
        sp.setLayoutY(532);
        sp.setFitToHeight(true);

        root.getChildren().addAll(table, sp);

//        root.getChildren().add();
        table.setItems(getproduct());

        Image logoImage;
        String logoImagePath = "name.png";
        ImageView logo;
        logoImage = new Image(new FileInputStream(logoImagePath));
        logo = new ImageView(logoImage);
        logo.setX(50);
        logo.setY(250);
        logo.setFitWidth(25);
        logo.setPreserveRatio(true);
        logo.setSmooth(true);
        logo.setCache(true);
        root.getChildren().add(logo);
        Image logoImage4;
        String logoImagePath4 = "email.png";
        ImageView logo4;
        logoImage4 = new Image(new FileInputStream(logoImagePath4));
        logo4 = new ImageView(logoImage4);
        logo4.setX(50);
        logo4.setY(341);
        logo4.setFitWidth(25);
        logo4.setPreserveRatio(true);
        logo4.setSmooth(true);
        logo4.setCache(true);
        root.getChildren().add(logo4);
        Image logoImage1;
        String logoImagePath1 = "cack.png";
        ImageView logo1;
        logoImage1 = new Image(new FileInputStream(logoImagePath1));
        logo1 = new ImageView(logoImage1);
        logo1.setX(50);
        logo1.setY(430);
        logo1.setFitWidth(25);
        logo1.setPreserveRatio(true);
        logo1.setSmooth(true);
        logo1.setCache(true);
        root.getChildren().add(logo1);
        Image logoImage2;
        String logoImagePath2 = "phone.png";
        ImageView logo2;
        logoImage2 = new Image(new FileInputStream(logoImagePath2));
        logo2 = new ImageView(logoImage2);
        logo2.setX(50);
        logo2.setY(521);
        logo2.setFitWidth(25);
        logo2.setPreserveRatio(true);
        logo2.setSmooth(true);
        logo2.setCache(true);
        root.getChildren().add(logo2);
        Image logoImage3;
        String logoImagePath3 = "gender.png";
        ImageView logo3;
        logoImage3 = new Image(new FileInputStream(logoImagePath3));
        logo3 = new ImageView(logoImage3);
        logo3.setX(50);
        logo3.setY(610);
        logo3.setFitWidth(25);
        logo3.setPreserveRatio(true);
        logo3.setSmooth(true);
        logo3.setCache(true);
        root.getChildren().add(logo3);
        Scene scene = new Scene(root, Color.web("#837D7D"));
        scene.getStylesheets().add("customer.css");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Profile");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    

    public void deleteb() {
        ObservableList<product> productselected, allproducts;
        allproducts = table.getItems();
        productselected = table.getSelectionModel().getSelectedItems();
        productselected.forEach(allproducts::remove);
    }

    public ObservableList<product> getproduct() {
        ObservableList<product> products = FXCollections.observableArrayList();
        products.add(new product(1, "2/3/2014", "5000", "This is the details"));
        products.add(new product(2, "1/4/2015", "3000", "This is the details,"));
        products.add(new product(3, "10/8/2012", "5000", "This is the details,"));
        products.add(new product(4, "20/1/2011", "6000", "This is the details"));
        products.add(new product(5, "21/6/2017", "1000", "This is the details"));
        products.add(new product(6, "19/9/2010", "1000", "This is the details"));
        products.add(new product(7, "19/9/2010", "1000", "This is the details"));
        products.add(new product(8, "19/9/2010", "1000", "This is the details"));
        products.add(new product(9, "19/9/2010", "1000", "This is the details"));
        products.add(new product(10, "19/9/2010", "1000", "This is the details"));
        products.add(new product(11, "19/9/2010", "1000", "This is the details"));
        products.add(new product(12, "19/9/2010", "1000", "This is the details"));
        products.add(new product(13, "19/9/2010", "1000", "This is the details"));
        products.add(new product(14, "19/9/2010", "1000", "This is the details"));

        return products;
    }
}
