/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import app.models.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 *
 * @author Mourad
 */
public class GuestCategories extends Tools {

    int d;
    public void display() throws FileNotFoundException {
         primaryStage = new Stage();
         root = new Group();
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
        TextField emailtext = new TextField();
        TextField passtext = new TextField();
        ImageView iv1 = new ImageView();

        iv1.setImage(image1);
        iv1.setFitWidth(400);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        iv1.setX(0);
        iv1.setY(0);
        ScrollPane sp = new ScrollPane();
         l = new Label[6];
        Label[] b = new Label[4];

        // labels of  categories
        l[1] = new Label("First Category");

        l[2] = new Label("Second Category");

        l[3] = new Label("Third Category");

        l[4] = new Label("Fourth Category");

        l[5] = new Label("Fifth Category");
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
        root.getChildren().addAll(ball1, ball2, ball3, iv1);

        //table
        //table functions down
        table = new TableView<>();
        TableColumn<Product, String> id = new TableColumn("ID");
        id.setMinWidth(100);
        id.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<Product, String> name = new TableColumn("NAME");
        name.setMinWidth(100);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Integer> price = new TableColumn("PRICE");
        price.setMinWidth(200);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> details = new TableColumn("DETAILS");
        details.setMinWidth(350);
        details.setCellValueFactory(new PropertyValueFactory<>("description"));

        l[1].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override

            public void handle(MouseEvent t) {
                l[1].setTextFill(Color.web("red"));
            }
        });
        l[1].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[1].setTextFill(Color.web("DARKRED"));
            }
        });
        l[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d=1;
                try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(GuestCategories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });
        l[2].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[2].setTextFill(Color.web("red"));
            }
        });
        l[2].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[2].setTextFill(Color.web("DARKRED"));
            }
        });
        l[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d=2;
                try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(GuestCategories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });
        l[3].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[3].setTextFill(Color.web("red"));
            }
        });
        l[3].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[3].setTextFill(Color.web("DARKRED"));
            }
        });
        l[3].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d=3;
                try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(GuestCategories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });
        l[4].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[4].setTextFill(Color.web("red"));
            }
        });
        l[4].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[4].setTextFill(Color.web("DARKRED"));

            }
        });
        l[4].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d=4;
                try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(GuestCategories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });
        l[5].setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[5].setTextFill(Color.web("red"));
            }
        });
        l[5].setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                l[5].setTextFill(Color.web("DARKRED"));
            }
        });
        l[5].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d=5;
              try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(GuestCategories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });

        // labels of  add purchase back
        b[1] = new Label("Back");

        b[1].setLayoutX(220);
        b[1].setLayoutY(665);
        b[1].setTextFill(Color.web("white"));
        b[1].setFont(Font.font("Copperplate Gothic Light", 20));

        // Button btn = new Button();
//         btn.setText("Say 'Hello World'");
        b[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                Guest c = new Guest();
                primaryStage.close();
                try {
                    c.dispaly();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
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
   

        //table functions
        table.getColumns().addAll(id, name, price, details);
        table.setVisible(false);
        table.setTableMenuButtonVisible(true);
        table.getStyleClass().add("table");

        sp.setContent(table);
        sp.setPrefSize(750, 500);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setLayoutX(200);
        sp.setLayoutY(120);
        sp.setFitToHeight(true);
        sp.getStyleClass().add("sp");

        root.getChildren().addAll(table, sp);
        for (int set = 1; set < l.length; set++) {

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

        for (int i = 1; i <= 5; i++) {
            root.getChildren().add(l[i]);
        }

        root.getChildren().add(b[1]);

        TranslateTransition[] lt = new TranslateTransition[6];
        for (int k = 1; k <= 5; k++) {
            lt[k] = new TranslateTransition();
        }
        for (int j = 1; j <= 5; j++) {

            lt[j].setNode(l[j]);
            lt[j].setToY(-(800 - (j * 120)));
            lt[j].setDuration(Duration.seconds(2));
            lt[j].play();
        }

        Scene scene = new Scene(root, Color.PERU);
        scene.getStylesheets().add("customer.css");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Categories");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    

    public ObservableList<Product> buildData() throws SQLException {
        ObservableList<Product> data = FXCollections.observableArrayList();
        Product cs = new Product();
        ArrayList<HashMap<String, Object>> j = cs.showProduct(d);

        for (HashMap<String, Object> obj : j) {

            data.add(new Product((int) obj.get("ID"), (String) obj.get("name"), (int) obj.get("price"), (String) obj.get("description")));

        }
        return data;
    }
}
