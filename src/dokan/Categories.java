/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dokan;

import app.models.Category;
import app.models.Product;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.ObjectProperty;
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
import javafx.scene.control.TableRow;
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
import shoponline.ShopOnline;

/**
 *
 * @author Mourad
 */
public class Categories extends Tools {

    public static Image carImage;
    private String carImagePath = "cart.png";
    public ImageView car;
    public int u;
    public static ArrayList<HashMap<String, Object>> list = new ArrayList<>();
    public int c = 0;
    ArrayList<CheckBox> checkbox = new ArrayList<>();
    public int d = 0;
    public HashMap<String, Object> list3 = new HashMap<>();
    static String selectedItem2;
    static int s;
 static TextField text;
    public void display() throws FileNotFoundException, SQLException {
        Stage primaryStage = new Stage();

        root = new Group();
        // background
        ShopOnline.init();
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
        sp = new ScrollPane();
        l = new Label[6];
        Label[] b = new Label[4];
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
        Category ca = new Category();
        // ca.getcategory(1).get(0).get("name");
        // labels of  categories
        l[1] = new Label();
        l[2] = new Label();
        l[3] = new Label();
        l[4] = new Label();
        l[5] = new Label();
        if(ca.getcategory(7).isEmpty() == false){
        l[1].setText((String) ca.getcategory(7).get(0).get("name"));
        }
        if(ca.getcategory(8).isEmpty() == false){
        l[2] = new Label((String) ca.getcategory(8).get(0).get("name"));
        }
        if(ca.getcategory(9).isEmpty() == false){
        l[3] = new Label((String) ca.getcategory(9).get(0).get("name"));
        }
        if(ca.getcategory(10).isEmpty() == false){
        l[4] = new Label((String) ca.getcategory(10).get(0).get("name"));
        }
        if(ca.getcategory(11).isEmpty() == false){
        l[5] = new Label((String) ca.getcategory(11).get(0).get("name"));
        }
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
        root.getChildren().addAll(ball1, ball2, ball3, iv1);
        Rectangle back = new Rectangle(150, 650, 200, 50);
        back.setArcWidth(40);
        back.setArcHeight(40);
        back.setStyle("-fx-fill: #5BAAEC;");

        Rectangle purchase = new Rectangle(450, 650, 200, 50);
        purchase.setArcWidth(40);
        purchase.setArcHeight(40);
        purchase.setStyle("-fx-fill: #5BAAEC;");

        Rectangle add = new Rectangle(750, 650, 200, 50);
        add.setArcWidth(40);
        add.setArcHeight(40);
        add.setStyle("-fx-fill: #5BAAEC;");

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
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, String> details = new TableColumn("DETAILS");
        details.setMinWidth(350);
        details.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn select = new TableColumn("SELECT");
        select.setMinWidth(100);
        select.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, CheckBox>, ObservableValue<CheckBox>>() {

            @Override
            public ObservableValue<CheckBox> call(
                    TableColumn.CellDataFeatures<Product, CheckBox> arg0) {
                Product user = arg0.getValue();

                CheckBox checkBox2 = new CheckBox();
                checkbox.add(checkBox2);

                checkBox2.selectedProperty().addListener(new ChangeListener<Boolean>() {
                    public void changed(ObservableValue<? extends Boolean> ov,
                            Boolean old_val, Boolean new_val) {
                        HashMap<String, Object> selectedItem = table.getSelectionModel().getSelectedItem().getHash();
                        selectedItem2 = table.getSelectionModel().getSelectedItem().getName();
//                        list3.put("quantity#",s);
//                        try {
////                    user.editProduct(list3,selectedItem2);
//                } catch (SQLException ex) {
//                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
//               }
                       s = Integer.parseInt(text.getText());
                       selectedItem.put("buyNumber", s);
                        list.add(selectedItem);
                        

                    }

                });

                return new SimpleObjectProperty<CheckBox>(checkBox2);

            }
        });

        TableColumn quantity = new TableColumn("QUANTITY");
        quantity.setMinWidth(100);
        quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Product, TextField>, ObservableValue<TextField>>() {

            @Override
            public ObservableValue<TextField> call(
                    TableColumn.CellDataFeatures<Product, TextField> arg0) {
                Product user = arg0.getValue();
                 text = new TextField();

                return new SimpleObjectProperty<TextField>(text);
            }
        });
        table.getStyleClass().add("table");

        /* TableColumn quantity = new TableColumn("QUANTITY");
         quantity.setMinWidth(100);
         quantity.setCellValueFactory(new PropertyValueFactory<product, TextField>("Pquantity"));
         */
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

        l[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                try {
                    // table.setItems();
                    checkbox.clear();
                    d = 7;
                    c = 0;

                    ObservableList<Product> data = FXCollections.observableArrayList();
                    Product cs = new Product();
                    ArrayList<HashMap<String, Object>> j = cs.showProduct(d);

                    for (HashMap<String, Object> obj : j) {

                        data.add(new Product((int) obj.get("ID"), (String) obj.get("name"), (int) obj.get("price"), (String) obj.get("description")));
                        c++;
                    }
                    table.setItems(data);
                } catch (SQLException ex) {
                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });

        l[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                try {
                    // table.setItems();
                    checkbox.clear();
                    d = 8;
                    c = 0;

                    ObservableList<Product> data = FXCollections.observableArrayList();
                    Product cs = new Product();
                    ArrayList<HashMap<String, Object>> j = cs.showProduct(d);

                    for (HashMap<String, Object> obj : j) {

                        data.add(new Product((int) obj.get("ID"), (String) obj.get("name"), (int) obj.get("price"), (String) obj.get("description")));
                        c++;
                    }
                    table.setItems(data);
                } catch (SQLException ex) {
                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });

        l[3].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d = 9;
                try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });

        l[4].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d = 10;
                try {
                    table.setItems(buildData());
                } catch (SQLException ex) {
                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                }
                table.setVisible(true);
            }
        });

        l[5].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                d = 11;
                //table.setItems(getproduct5());
                table.setVisible(true);
            }
        });

        // labels of  add purchase back
        b[1] = new Label("Back");
        b[2] = new Label("Purchase");
        b[3] = new Label("Add To Chart");
        b[1].setLayoutX(220);
        b[1].setLayoutY(665);
        b[1].setTextFill(Color.web("white"));
        b[1].setFont(Font.font("Copperplate Gothic Light", 20));
        b[2].setLayoutX(500);
        b[2].setLayoutY(665);
        b[2].setTextFill(Color.web("white"));
        b[2].setFont(Font.font("Copperplate Gothic Light", 20));
        b[3].setLayoutX(780);
        b[3].setLayoutY(665);
        b[3].setTextFill(Color.web("white"));
        b[3].setFont(Font.font("Copperplate Gothic Light", 20));

        // Button btn = new Button();
//         btn.setText("Say 'Hello World'");
        b[1].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                CustomerGui c = new CustomerGui();
                primaryStage.close();
                try {
                    c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        b[2].setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                purshace p = new purshace();
                primaryStage.close();
                try {
                    p.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Categories.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        b[3].setOnMouseClicked(new EventHandler<Event>() {

            @Override

            public void handle(Event event) {

                for (int i = 0; i < list.size(); i++) {
                    // System.out.println( "list = "+list.size());
                    System.out.println(list.get(i));
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

        //table functions
        table.getColumns().addAll(id, name, price, details, select, quantity);
        table.setVisible(false);
        table.setTableMenuButtonVisible(true);

        sp.setContent(table);
        sp.setPrefSize(800, 500);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setLayoutX(150);
        sp.setLayoutY(100);
        sp.setFitToHeight(true);
        sp.getStyleClass().add("sp");

        root.getChildren().addAll(table, sp);
//        root.getChildren().add(add);
//        root.getChildren().add(purchase);
//        root.getChildren().add(back);
        for (int i = 1; i <= 5; i++) {
            root.getChildren().add(l[i]);
        }
        for (int j = 1; j <= 3; j++) {
            root.getChildren().add(b[j]);
        }
        TranslateTransition[] lt = new TranslateTransition[6];
        for (int k = 1; k <= 5; k++) {
            lt[k] = new TranslateTransition();
        }
        for (int j = 1; j <= 5; j++) {

            lt[j].setNode(l[j]);
            lt[j].setToY(-(750 - (j * 120)));
            lt[j].setDuration(Duration.seconds(2));
            lt[j].play();
        }
        carImage = new Image(new FileInputStream(carImagePath));
        car = new ImageView(carImage);

        car.setX(460);
        car.setY(660);
        car.setFitWidth(35);
        car.setPreserveRatio(true);
        car.setSmooth(true);
        car.setCache(true);
        root.getChildren().add(car);
        sp.getStyleClass().add("sp");
        Scene scene = new Scene(root, Color.web("WHITESMOKE"));
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
