package dokan;

import app.App;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import app.models.Category;
import app.models.Customer;
import app.models.Feedback;
import app.models.Offer;
import app.models.Pair;
import app.models.Product;
import static dokan.Category_features.alert;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import shoponline.ShopOnline;
import app.models.Validation;

public class Category_features {

    static Category category = new Category();
    static Product product = new Product();
    static Feedback feedbackk = new Feedback();
    static Offer offerobj = new Offer();
    static Customer customer = new Customer();

    // add new category
    public static Rectangle rectangle = new Rectangle();
    public static Label addcateg = new Label();
    public static Button btn = new Button();
    public static Label cname = new Label();
    public static Label cdetails = new Label();
    public static TextField categoryname = new TextField();
    public static TextArea categorydetails = new TextArea();
    public static Alert alert;

    // edit product 
    public static Label editproduct = new Label();
    public static ChoiceBox<String> menuButton_edit = new ChoiceBox<>();
    public static TextField searchfield = new TextField();
    public static Image imagesearch;
    public static ImageView searchview = new ImageView(imagesearch);
    public static Button edit = new Button();
    public static Button delete = new Button();
    public static Label pcategory = new Label();
    public static Label pname = new Label();
    public static Rectangle editrectangle = new Rectangle();
    // addnewproduct attributes
    public static Label product_add = new Label();
    public static Label pprice_add = new Label();
    public static Label pdetails_add = new Label();
    public static TextField productname_add = new TextField();
    public static TextField productprice_add = new TextField();
    public static TextArea Productdetails_add = new TextArea();
    public static Button submit_add = new Button();
    public static Label pname_add = new Label();
    public static Label pcategory_add = new Label();
    public static ChoiceBox<String> menuButton_add = new ChoiceBox<>();
    public static Label pquantity_add = new Label();
    public static TextField productquantity_add = new TextField();
    public static Rectangle addrectangle = new Rectangle();

    // edit product form
    public static Label pquantity_editform = new Label();
    public static TextField productquantity_editform = new TextField();
    public static Label product_editform = new Label();
    public static Label pname_editform = new Label();
    public static Label pprice_editform = new Label();
    public static Label pdetails_editform = new Label();
    public static Label pcategory_editform = new Label();
    public static TextField productname_editform = new TextField();
    public static TextField productprice_editform = new TextField();
    public static TextArea Productdetails_editform = new TextArea();
    public static Button back_edit = new Button();
    public static Button submit_editform = new Button();
    public static ChoiceBox<String> menuButton_editform = new ChoiceBox<>();
    public static Rectangle editformrectangle = new Rectangle();

    // Attribute  diactivate customer
    public static Label diactcustomer = new Label();
    public static Label customeremail = new Label();
    public static TextField email = new TextField();
    public static Button Diactivate = new Button();
    public static Rectangle diacativaterectangle = new Rectangle();

    // Attribute  show feedback
    public static Label feed = new Label();

    public static ListView listview_show = new ListView();
    public static Button showbutton = new Button();
    public static Rectangle showrectangle = new Rectangle();

    // feedbacks
    public static Label feedshow = new Label();
    public static TextArea feedback = new TextArea();
    public static Button back_feed = new Button();
    public static Rectangle feedrectangle = new Rectangle();
    // Attribute  make offer
    public static Label makenewoffer = new Label();
    public static Label poffer = new Label();
    public static Label pcategory_offer = new Label();
    public static TextField productoffer = new TextField();
    public static Button makeit = new Button();
    public static ChoiceBox<String> menuButton_offer = new ChoiceBox<>();
    public static Label pname_offer = new Label();
    public static Label pprice_offer = new Label();
    public static TextField productname_offer = new TextField();
    public static TextField productprice_offer = new TextField();
    public static TextArea Productdetails_offer = new TextArea();
    public static Rectangle makerectangle = new Rectangle();
    //  delete offer
    public static Label offer = new Label();
    public static Button delete_offer = new Button();
    public static ListView listview_offer = new ListView();
    public static Rectangle deleterectangle = new Rectangle();
    // show report
    public static Label Report = new Label();
    public static ListView listview_reports = new ListView();
    public static Rectangle showreportrectangle = new Rectangle();

// add category 
    public static void addcategoryform(boolean set) {

//    public static Rectangle rectangle = new Rectangle();
//    public static Label addcateg = new Label("Add Category");
//    public static Button btn = new Button("Submit");
//    public static Label cname = new Label("Category Name");
//    public static Label cdetails = new Label("Product Details");
//    public static TextField categoryname = new TextField("Enter The Category name...");
//    public static TextArea categorydetails = new TextArea("The Category details..... ");
        addcateg.setText("Add Category");
        btn.setText("Submit");
        cname.setText("Category Name");
        cdetails.setText("Product Details");
        categorydetails.setText("The Category details..... ");
        categoryname.setText("Enter The Category name...");

        // visability
        addcateg.setVisible(set);
        btn.setVisible(set);
        cname.setVisible(set);
        cdetails.setVisible(set);
        categoryname.setVisible(set);
        categorydetails.setVisible(set);
        rectangle.setVisible(set);

        //    
        //Design 
        DropShadow shadow = new DropShadow();

        addcateg.getStyleClass().add("headlabel");
        addcateg.setTextFill(Color.BLACK);
        addcateg.setEffect(shadow);
        btn.getStyleClass().add("buttons");
        cname.getStyleClass().add("genariclabel");
        cname.setTextFill(Color.web("#5BAAEC"));
//        cname.setEffect(shadow);
        cdetails.setTextFill(Color.web("#5BAAEC"));
//        cdetails.setEffect(shadow);
        cdetails.getStyleClass().add("genariclabel");
        categoryname.getStyleClass().add("textfields");
        categoryname.setStyle("-fx-font-style: bold");
        categorydetails.getStyleClass().add("textfields");
        categorydetails.setPrefSize(300, 200);
        btn.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        btn.setPrefSize(70, 30);
        Customer cu = (Customer) App.getCurrentCustomer();

        btn.setOnMouseEntered(e -> {
            btn.setEffect(shadow);
        });

        btn.setOnMouseExited(e -> {

            btn.setEffect(null);
        });

        btn.setOnMouseClicked(e -> {
            btn.setStyle("-fx-background-color : white");

        });

        // Actions
        btn.setOnAction(e -> {

            try {
                if (category.Search_Category(categoryname.getText()).isEmpty()) {

                    if (Validation.validate_string("^[A-Za-z_]+", categoryname.getText())) {
                        if (Validation.validate_string(".+", categorydetails.getText())) {

                            category.addCategory(categoryname.getText(), categorydetails.getText(), cu.getID());
                            Validation.showalert("Information Message", "Category :" + categoryname.getText(), "Is Added", AlertType.INFORMATION);
                        } else {
                            Validation.showalert("Error Message", "Category Details ", "you entered empty filed", AlertType.ERROR);
                        }
                    } else {
                        Validation.showalert("Error Message", "Category Name", "Characters and underscore only is allowed", AlertType.ERROR);

                    }

                } else {
                    Validation.showalert("Error Message", "The Category : " + categoryname.getText(), "Is Exist", AlertType.ERROR);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        //
        //// rectangle
        rectangle.setX(300);
        rectangle.setY(300);
        rectangle.setWidth(700);
        rectangle.setHeight(400);
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        //  rectangle.getStyleClass().add("rect");
        //rectangle.setOpacity(.5);
        rectangle.setFill(null);
        rectangle.setStrokeWidth(6);
        rectangle.setStroke(Color.BLACK);
        rectangle.setEffect(shadow);

        ////    
        // layout sets
        addcateg.setLayoutX(320);
        addcateg.setLayoutY(310);

        categoryname.setLayoutX(590);
        cname.setLayoutX(400);
        categoryname.setLayoutY(400);
        cname.setLayoutY(400);

        categorydetails.setLayoutX(590);
        cdetails.setLayoutX(400);
        categorydetails.setLayoutY(450);
        cdetails.setLayoutY(450);

        btn.setLayoutX(900);
        btn.setLayoutY(650);

    }

    // EDIT Product
    public static void editproduct(boolean set) throws FileNotFoundException, SQLException {
        editproduct.setText("Edit Product");
        searchfield.setText("Enter The Product Name ... ");
//        pcategory.setText("Category Name");
        pname.setText("Product Name");
        edit.setText("Edit");
        delete.setText("Delete");

        // visability 
        editproduct.setVisible(set);
//        menuButton_edit.setVisible(set);
        searchfield.setVisible(set);
        searchview.setVisible(set);
        edit.setVisible(set);
        delete.setVisible(set);
//        pcategory.setVisible(set);
        pname.setVisible(set);
        editrectangle.setVisible(set);
        //
        // top down menu 
        //set categories

        //
        // search image field 
        imagesearch = new Image(new FileInputStream("search-icon-2.png"));
        searchview.setImage(imagesearch);
        searchview.setX(730);
        searchview.setY(423);
        searchview.setFitWidth(50);
        searchview.setPreserveRatio(true);
        searchview.setSmooth(true);
        searchview.setCache(true);
        //  searchview.setOnMouseClicked(e -> System.out.println("Muhammed"));

        //
        // Actions 
        edit.setOnAction(e -> {
            if (!Validation.validate_string("^[A-Za-z_]++", searchfield.getText())) {

                Validation.showalert("Error Message", "product name", "characters and underscored are only allowed", AlertType.ERROR);
            } else {
                try {
                    if (product.Search(searchfield.getText()).isEmpty()) {
                        Validation.showalert("Error Message", "Product Name", "The product that you entered is not Exist", AlertType.ERROR);

                    } else {
                        Category_features.editproductform(true, searchfield.getText());
                    }

                    editproduct.setVisible(false);
//            menuButton_edit.setVisible(false);
                    searchfield.setVisible(false);
                    searchview.setVisible(false);
                    edit.setVisible(false);
                    delete.setVisible(false);
//            pcategory.setVisible(false);
                    pname.setVisible(false);
                    editrectangle.setVisible(false);

                } catch (SQLException ex) {
                    Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        delete.setOnAction(e -> {
            if (!Validation.validate_string("^[A-Za-z_]++", searchfield.getText())) {

                Validation.showalert("Error Message", "product name", "characters and underscored are only allowed", AlertType.ERROR);
            } else {
                try {
                    if (product.Search(searchfield.getText()).isEmpty()) {
                        Validation.showalert("Error Message", "Product Name", "The product that you entered is not Exist", AlertType.ERROR);

                    } else {
                        try {
                            product.deleteProduct(searchfield.getText());
                            Validation.showalert("Information Message", "Done ^_^", "The Product : " + searchfield.getText() + "is deleted", AlertType.INFORMATION);
                        } catch (SQLException ex) {
                            Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                    Validation.showalert("Error Message", "oops -_-", "your system has an error", AlertType.WARNING);
                }
            }

        });

        //Design 
        DropShadow shadow = new DropShadow();

//        menuButton_edit.getStyleClass().add("menubutton_");
//        menuButton_edit.setPrefSize(200, 30);
        editproduct.getStyleClass().add("headlabel");
        editproduct.setTextFill(Color.BLACK);
        editproduct.setEffect(shadow);
        edit.getStyleClass().add("buttons");
        delete.getStyleClass().add("buttons");
//        pcategory.getStyleClass().add("genariclabel");
//        pcategory.setTextFill(Color.web("#5BAAEC"));
//        cname.setEffect(shadow);
        pname.setTextFill(Color.web("#5BAAEC"));
//        cdetails.setEffect(shadow);
        pname.getStyleClass().add("genariclabel");
        searchfield.getStyleClass().add("textfields");
        searchfield.setStyle("-fx-font-style: bold");
        edit.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        delete.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        edit.setPrefSize(70, 30);
        delete.setPrefSize(70, 30);

        delete.setOnMouseEntered(e -> {
            delete.setEffect(shadow);
        });
        edit.setOnMouseEntered(e -> {
            edit.setEffect(shadow);
        });

        edit.setOnMouseExited(e -> {

            edit.setEffect(null);
        });

        delete.setOnMouseExited(e -> {

            delete.setEffect(null);
        });

        edit.setOnMouseClicked(e -> {
            edit.setStyle("-fx-background-color : black");
        });
        delete.setOnMouseClicked(e -> {
            delete.setStyle("-fx-background-color : black");
        });

        //
        //// rectangle
        editrectangle.setX(300);
        editrectangle.setY(300);
        editrectangle.setWidth(600);
        editrectangle.setHeight(400);
        editrectangle.setArcWidth(20);
        editrectangle.setArcHeight(20);

        editrectangle.setFill(null);
        editrectangle.setStrokeWidth(6);
        editrectangle.setStroke(Color.BLACK);
        editrectangle.setEffect(shadow);

        // layout sets
        searchfield.setPrefWidth(200);

        editproduct.setLayoutX(320);
        editproduct.setLayoutY(310);

//        pcategory.setLayoutX(410);
//        pcategory.setLayoutY(490);
//        menuButton_edit.setValue("Select A Category");
//        menuButton_edit.setLayoutX(580);
//        menuButton_edit.setLayoutY(490);
        pname.setLayoutX(410);
        pname.setLayoutY(430);
        searchfield.setLayoutX(580);
        searchfield.setLayoutY(430);

        edit.setLayoutX(410);
        delete.setLayoutX(580);
        edit.setLayoutY(600);
        delete.setLayoutY(600);

        //
    }

    // edit product form 
    public static void addnewproduct(boolean set) throws SQLException {
        // Attribute  
        product_add.setText("Product Data");
        pname_add.setText("Product Name");
        pprice_add.setText("Product Price");
        pdetails_add.setText("Product Details");
        pcategory_add.setText("Choose A Category");
        productname_add.setText("Enter The Product Name...");
        productprice_add.setText("Price");

        pquantity_add.setText("Product Quantity");
        productquantity_add.setText("Quantity");
        submit_add.setText("Submit");

//
        productname_add.setPrefWidth(200);
        productprice_add.setPrefWidth(100);
        productquantity_add.setPrefWidth(100);
// visabiliry 
        Productdetails_add.setVisible(set);
        product_add.setVisible(set);
        pname_add.setVisible(set);
        pprice_add.setVisible(set);
        productname_add.setVisible(set);
        submit_add.setVisible(set);
        productprice_add.setVisible(set);
        pcategory_add.setVisible(set);
        pdetails_add.setVisible(set);
        menuButton_add.setVisible(set);
        addrectangle.setVisible(set);
        pquantity_add.setVisible(set);
        productquantity_add.setVisible(set);
        //
        // drop down menu

        menuButton_add.getItems().clear();
        menuButton_add.getItems().add("Select A Category");
        // menuButton_add.getItems().add();
        app.App database = new app.App();
        ArrayList<String> category = database.getCategoryName();
        for (String category1 : category) {
            menuButton_add.getItems().add(category1);
        }

//        menuButton_add.setValue("Select A Category");
//
// actions
        String quantity = productquantity_add.getText();

        submit_add.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                try {
                    if (!Validation.validate_string("^[A-Za-z_]++", productname_add.getText())) {

                        Validation.showalert("Error Message", "product name", "characters and underscored are only allowed", AlertType.ERROR);
                    } else if (!product.Search(productname_add.getText()).isEmpty()) {
                        Validation.showalert("Error Message", "Product Name", "The product that you entered is already Exist", AlertType.ERROR);

                    } else if (!Validation.validate_string("^[0-9]++", productquantity_add.getText())) {
                        Validation.showalert("Error Message", "Product quantity", "The unsigned integers numbers are only allowed", AlertType.ERROR);
                    } else if (!Validation.validate_string("^[1-9][0-9]++|[1-9][0-9]*[.][0-9]+", productprice_add.getText())) {
                        Validation.showalert("Error Message", "Product Price", "The Float numbers are only allowed", AlertType.ERROR);
                    } else if (!Validation.validate_string("^[A-Za-z_]++", menuButton_add.getSelectionModel().getSelectedItem())) {

                        Validation.showalert("Error Message", "Category name", "characters and underscored are only allowed", AlertType.ERROR);
                    } else if (!Validation.validate_string(".+", Productdetails_add.getText())) {

                        Validation.showalert("Error Message", "Product Details", "you insert an empty field", AlertType.ERROR);
                    } else {
                        product.addProduct(productname_add.getText(), Integer.parseInt(productquantity_add.getText()), (int) Float.parseFloat(productprice_add.getText()), Productdetails_add.getText(), menuButton_add.getSelectionModel().getSelectedItem());
                        Validation.showalert("Information", "Done ^_^", "you have new product :" + productname_add.getText() + "is added to category :"
                                + menuButton_add.getSelectionModel().getSelectedItem(), AlertType.INFORMATION);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                    Validation.showalert("Error Message", "Look, an Error Dialog", "Ooops you have an error in your system", AlertType.ERROR);
                }
            }
        });

//
// layout sets
        product_add.setLayoutX(320);
        product_add.setLayoutY(270);

        pname_add.setLayoutX(390);
        pname_add.setLayoutY(350);
        productname_add.setLayoutX(600);
        productname_add.setLayoutY(350);

        pprice_add.setLayoutX(390);
        pprice_add.setLayoutY(410);
        productprice_add.setLayoutX(600);
        productprice_add.setLayoutY(410);

        pquantity_add.setLayoutX(390);
        pquantity_add.setLayoutY(470);
        productquantity_add.setLayoutX(600);
        productquantity_add.setLayoutY(470);

        pcategory_add.setLayoutX(390);
        pcategory_add.setLayoutY(530);
        menuButton_add.setLayoutX(600);
        menuButton_add.setLayoutY(530);

        pdetails_add.setLayoutX(390);
        pdetails_add.setLayoutY(590);
        Productdetails_add.setLayoutX(600);
        Productdetails_add.setLayoutY(590);

        submit_add.setLayoutX(380);
        submit_add.setLayoutY(680);

//
        //Design 
        DropShadow shadow = new DropShadow();
        menuButton_add.getStyleClass().add("menubutton_");
        menuButton_add.setPrefSize(200, 30);
        //headlabel
        product_add.getStyleClass().add("headlabel");
        product_add.setTextFill(Color.BLACK);
        product_add.setEffect(shadow);
        //buttons
        submit_add.getStyleClass().add("buttons");
        //labels
        pquantity_add.getStyleClass().add("genariclabel");
        pquantity_add.setTextFill(Color.web("#5BAAEC"));
        pcategory_add.getStyleClass().add("genariclabel");
        pcategory_add.setTextFill(Color.web("#5BAAEC"));
        pname_add.setTextFill(Color.web("#5BAAEC"));
        pname_add.getStyleClass().add("genariclabel");
        pprice_add.setTextFill(Color.web("#5BAAEC"));
        pprice_add.getStyleClass().add("genariclabel");
        pdetails_add.setTextFill(Color.web("#5BAAEC"));
        pdetails_add.getStyleClass().add("genariclabel");
        // textfields
        productname_add.getStyleClass().add("textfields");
        productname_add.setStyle("-fx-font-style: bold");
        productquantity_add.getStyleClass().add("textfields");
        productquantity_add.setStyle("-fx-font-style: bold");
        productprice_add.getStyleClass().add("textfields");
        productprice_add.setStyle("-fx-font-style: bold");
        Productdetails_add.getStyleClass().add("textfields");
        Productdetails_add.setStyle("-fx-font-style: bold");
        Productdetails_add.setPrefSize(300, 150);

        submit_add.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");

        submit_add.setPrefSize(70, 30);
        submit_add.setOnMouseEntered(e -> {
            submit_add.setEffect(shadow);
        });
        submit_add.setOnMouseExited(e -> {

            submit_add.setEffect(null);
        });
        submit_add.setOnMouseClicked(e -> {
            submit_add.setStyle("-fx-background-color : black");
        });

        //
        //// rectangle
        addrectangle.setX(300);
        addrectangle.setY(250);
        addrectangle.setWidth(700);
        addrectangle.setHeight(500);
        addrectangle.setArcWidth(20);
        addrectangle.setArcHeight(20);
        addrectangle.setFill(null);
        addrectangle.setStrokeWidth(6);
        addrectangle.setStroke(Color.BLACK);
        addrectangle.setEffect(shadow);

        ////  
    }

    public static void editproductform(boolean set, String product_name) {

        String category_name = "";
        try {
            // edit product form

            for (HashMap<String, Object> products : product.Search(product_name)) {
//               for (Map.Entry<String,Object> product : products.entrySet()) {
//                   System.out.println(product.getValue());
//               }
                productname_editform.setText((String) products.get("name"));
                productprice_editform.setText("" + products.get("price"));
                Productdetails_editform.setText((String) products.get("description"));
                productquantity_editform.setText("" + products.get("quantity#"));

                for (HashMap<String, Object> products_ : category.getcategory((int) products.get("category_id"))) {

                    category_name = (String) products_.get("name");

                }

            }

            menuButton_editform.setValue(category_name);

            // Attribute
        } catch (SQLException ex) {
            Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Attribute  
        product_editform.setText("Product name is  " + product_name);
        pname_editform.setText("Product Name");
        pprice_editform.setText("Product Price");
        pdetails_editform.setText("Producr Details");
        pcategory_editform.setText("Choose A Category");
        pquantity_editform.setText("Product Quantity");

        back_edit.setText("Back");
        submit_editform.setText("Submit");

//
        productname_editform.setPrefWidth(200);
        productprice_editform.setPrefWidth(100);
        productquantity_editform.setPrefWidth(100);
// visabiliry 

        Productdetails_editform.setVisible(set);
        product_editform.setVisible(set);
        pname_editform.setVisible(set);
        pprice_editform.setVisible(set);
        productname_editform.setVisible(set);
        submit_editform.setVisible(set);
        productprice_editform.setVisible(set);
        pcategory_editform.setVisible(set);
        pdetails_editform.setVisible(set);
        menuButton_editform.setVisible(set);
        back_edit.setVisible(set);
        editformrectangle.setVisible(set);
        pquantity_editform.setVisible(set);
        productquantity_editform.setVisible(set);
        //
        // drop down menu

//
// actions
        submit_editform.setOnAction(e -> {
            HashMap<String, Object> productdata = new HashMap<>();
            productdata.put("name", productname_editform.getText());
            productdata.put("quantity#", productquantity_editform.getText());
            productdata.put("price", productprice_editform.getText());
            productdata.put("description", pdetails_editform.getText());

            if (!Validation.validate_string("^[A-Za-z_]++", productname_editform.getText())) {

                Validation.showalert("Error Message", "product name", "characters and underscored are only allowed", AlertType.ERROR);
            } else if (!Validation.validate_string("^[0-9]++", productquantity_editform.getText())) {
                Validation.showalert("Error Message", "Product quantity", "The unsigned integers numbers are only allowed", AlertType.ERROR);
            } else if (!Validation.validate_string("^[1-9][0-9]++|[1-9][0-9]*[.][0-9]+", productprice_editform.getText())) {
                Validation.showalert("Error Message", "Product Price", "The Float numbers are only allowed", AlertType.ERROR);
            } else if (!Validation.validate_string("^[A-Za-z_]++", menuButton_editform.getSelectionModel().getSelectedItem())) {

                Validation.showalert("Error Message", "Category name", "characters and underscored are only allowed", AlertType.ERROR);
            } else if (!Validation.validate_string(".+", Productdetails_editform.getText())) {

                Validation.showalert("Error Message", "Product Details", "you insert an empty field", AlertType.ERROR);
            } else {
                try {
                    if (product.editProduct(productdata, product_name)) {
                        Validation.showalert("Information", "Done ^_^", "you have edited product :" + productname_editform.getText() + "is added to category :"
                                + menuButton_editform.getSelectionModel().getSelectedItem(), AlertType.INFORMATION);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                    Validation.showalert("Error Message", "Look, an Error Dialog", "Ooops you have an error in your system", AlertType.ERROR);
                }
            }

        });

        back_edit.setOnAction(e -> {

            try {
                Category_features.editproduct(set);

                Productdetails_editform.setVisible(false);
                product_editform.setVisible(false);
                pname_editform.setVisible(false);
                pprice_editform.setVisible(false);
                productname_editform.setVisible(false);
                submit_editform.setVisible(false);
                productprice_editform.setVisible(false);
                pcategory_editform.setVisible(false);
                pdetails_editform.setVisible(false);
                menuButton_editform.setVisible(false);
                back_edit.setVisible(false);
                editformrectangle.setVisible(false);
                pquantity_editform.setVisible(false);
                productquantity_editform.setVisible(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

//
// layout sets
        product_editform.setLayoutX(320);
        product_editform.setLayoutY(270);

        pname_editform.setLayoutX(390);
        pname_editform.setLayoutY(350);
        productname_editform.setLayoutX(600);
        productname_editform.setLayoutY(350);

        pprice_editform.setLayoutX(390);
        pprice_editform.setLayoutY(410);
        productprice_editform.setLayoutX(600);
        productprice_editform.setLayoutY(410);

        pquantity_editform.setLayoutX(390);
        pquantity_editform.setLayoutY(470);
        productquantity_editform.setLayoutX(600);
        productquantity_editform.setLayoutY(470);

        pcategory_editform.setLayoutX(390);
        pcategory_editform.setLayoutY(530);
        menuButton_editform.setLayoutX(600);
        menuButton_editform.setLayoutY(530);

        pdetails_editform.setLayoutX(390);
        pdetails_editform.setLayoutY(590);
        Productdetails_editform.setLayoutX(600);
        Productdetails_editform.setLayoutY(590);

        submit_editform.setLayoutX(380);
        submit_editform.setLayoutY(680);
        back_edit.setLayoutX(480);
        back_edit.setLayoutY(680);

//
        //Design 
        DropShadow shadow = new DropShadow();
        menuButton_editform.getStyleClass().add("menubutton_");
        menuButton_editform.setPrefSize(200, 30);
        product_editform.getStyleClass().add("headlabel");
        product_editform.setTextFill(Color.BLACK);
        product_editform.setEffect(shadow);
        submit_editform.getStyleClass().add("buttons");
        back_edit.getStyleClass().add("buttons");
        pcategory_editform.getStyleClass().add("genariclabel");
        pcategory_editform.setTextFill(Color.web("#5BAAEC"));
        pquantity_editform.getStyleClass().add("genariclabel");
        pquantity_editform.setTextFill(Color.web("#5BAAEC"));
        pname_editform.setTextFill(Color.web("#5BAAEC"));
        pname_editform.getStyleClass().add("genariclabel");
        pprice_editform.setTextFill(Color.web("#5BAAEC"));
        pprice_editform.getStyleClass().add("genariclabel");
        pdetails_editform.setTextFill(Color.web("#5BAAEC"));
        pdetails_editform.getStyleClass().add("genariclabel");
        productname_editform.getStyleClass().add("textfields");
        productname_editform.setStyle("-fx-font-style: bold");
        productprice_editform.getStyleClass().add("textfields");
        productprice_editform.setStyle("-fx-font-style: bold");
        productquantity_editform.getStyleClass().add("textfields");
        productquantity_editform.setStyle("-fx-font-style: bold");
        Productdetails_editform.getStyleClass().add("textfields");
        Productdetails_editform.setStyle("-fx-font-style: bold");
        Productdetails_editform.setPrefSize(300, 100);
        submit_editform.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        back_edit.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        submit_editform.setPrefSize(70, 30);

        back_edit.setPrefSize(70, 30);

        submit_editform.setOnMouseEntered(e -> {
            submit_editform.setEffect(shadow);
        });
        back_edit.setOnMouseEntered(e -> {
            back_edit.setEffect(shadow);
        });

        back_edit.setOnMouseExited(e -> {

            back_edit.setEffect(null);
        });

        submit_editform.setOnMouseExited(e -> {

            submit_editform.setEffect(null);
        });

        back_edit.setOnMouseClicked(e -> {
            back_edit.setStyle("-fx-background-color : black");
        });
        submit_editform.setOnMouseClicked(e -> {
            submit_editform.setStyle("-fx-background-color : black");
        });

        //
        //// rectangle
        editformrectangle.setX(300);
        editformrectangle.setY(250);
        editformrectangle.setWidth(700);
        editformrectangle.setHeight(500);
        editformrectangle.setArcWidth(20);
        editformrectangle.setArcHeight(20);
        //  rectangle.getStyleClass().add("rect");
        //rectangle.setOpacity(.5);
        editformrectangle.setFill(null);
        editformrectangle.setStrokeWidth(6);
        editformrectangle.setStroke(Color.BLACK);
        editformrectangle.setEffect(shadow);

        ////  
    }

    //-----------------------------------------------------Customer--------------------------------------------------------//
    public static void diactivateaccount(boolean setdiac) {
        diactcustomer.setText("Diactivation Panel");
        customeremail.setText("Customer Email");
        email.setText("Enter The Customer Email");
        Diactivate.setText("Diactivate");

// visabiliry 
        diactcustomer.setVisible(setdiac);
        Diactivate.setVisible(setdiac);
        email.setVisible(setdiac);
        customeremail.setVisible(setdiac);
        diacativaterectangle.setVisible(setdiac);
//

// actions
//
// layout sets
        diactcustomer.setLayoutX(320);
        diactcustomer.setLayoutY(310);

        customeremail.setLayoutX(410);
        customeremail.setLayoutY(380);
        email.setLayoutX(600);
        email.setLayoutY(380);

        Diactivate.setLayoutX(700);
        Diactivate.setLayoutY(450);

//
        //Design 
        DropShadow shadow = new DropShadow();

        diactcustomer.getStyleClass().add("headlabel");
        diactcustomer.setTextFill(Color.BLACK);
        diactcustomer.setEffect(shadow);

        Diactivate.getStyleClass().add("buttons");

        customeremail.getStyleClass().add("genariclabel");
        customeremail.setTextFill(Color.web("#5BAAEC"));

        email.getStyleClass().add("textfields");
        email.setStyle("-fx-font-style: bold");
        email.setPrefSize(250, 20);

        Diactivate.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        Diactivate.setPrefSize(90, 30);

        Diactivate.setOnMouseEntered(e -> {
            Diactivate.setEffect(shadow);
        });

        Diactivate.setOnMouseExited(e -> {

            Diactivate.setEffect(null);
        });

        Diactivate.setOnMouseClicked(e -> {
            Diactivate.setStyle("-fx-background-color : black");
        });
        //

        Diactivate.setOnAction(e -> {

            try {

                if (customer.Search_Customer(email.getText()).isEmpty()) {
                    Validation.showalert("Error Message", "Customer Email", "this email : " + email.getText() + "not exist", AlertType.ERROR);
                } else {

                    customer.diactivatecustomer(email.getText());
                    Validation.showalert("Information Message", "" + email.getText(), "IS Deactivated", AlertType.INFORMATION);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                Validation.showalert("Error Message", "HOOPS -_-", "Your System Have An Error", AlertType.ERROR);
            }

        });
//
        //// rectangle
        diacativaterectangle.setX(300);
        diacativaterectangle.setY(300);
        diacativaterectangle.setWidth(600);
        diacativaterectangle.setHeight(200);
        diacativaterectangle.setArcWidth(20);
        diacativaterectangle.setArcHeight(20);
        diacativaterectangle.setFill(null);
        diacativaterectangle.setStrokeWidth(6);
        diacativaterectangle.setStroke(Color.BLACK);
        diacativaterectangle.setEffect(shadow);

        //// 
        //
    }

    //-----------------------------------------------------Feedback-------------------------------------------------------------//  
    public static void showfeedback(boolean set) throws SQLException {

        feed.setText("Our Feedbacks");
        showbutton.setText("Show");

// visabiliry 
        feed.setVisible(set);
        // listview.setVisible(set);
        listview_show.setVisible(set);
        showbutton.setVisible(set);
        showrectangle.setVisible(set);
        showbutton.setOnAction(e -> {

            try {
                if (listview_show.getSelectionModel().getSelectedItem() == null) {
                    Validation.showalert("Error Message", null, "You Should Select one ", AlertType.ERROR);
                } else {
                    Category_features.feedbacks(set, (String) listview_show.getSelectionModel().getSelectedItem());
                }
            } catch (SQLException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
            }
            feed.setVisible(false);
            listview_show.setVisible(false);
            showbutton.setVisible(false);
            showrectangle.setVisible(false);

        });

//         listview_show.getItems().addAll("mohamed","ali");
        listview_show.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

// layout sets
        feed.setLayoutX(320);
        feed.setLayoutY(310);
        listview_show.setLayoutX(370);
        listview_show.setLayoutY(350);
        showbutton.setLayoutX(600);
        showbutton.setLayoutY(660);
//

        // design
        listview_show.setPrefWidth(600);
        listview_show.setPrefHeight(300);
        listview_show.getStyleClass().add("listvieww");

        //Design 
        DropShadow shadow = new DropShadow();

        feed.getStyleClass().add("headlabel");
        feed.setTextFill(Color.BLACK);
        feed.setEffect(shadow);
        showbutton.getStyleClass().add("buttons");
        showbutton.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        showbutton.setPrefSize(70, 30);
        showbutton.setOnMouseEntered(e -> {
            showbutton.setEffect(shadow);
        });

        showbutton.setOnMouseExited(e -> {

            showbutton.setEffect(null);
        });

        showbutton.setOnMouseClicked(e -> {
            showbutton.setStyle("-fx-background-color : white");
        });
        //

        //// rectangle
        showrectangle.setX(300);
        showrectangle.setY(300);
        showrectangle.setWidth(700);
        showrectangle.setHeight(400);
        showrectangle.setArcWidth(20);
        showrectangle.setArcHeight(20);
        showrectangle.setFill(null);
        showrectangle.setStrokeWidth(6);
        showrectangle.setStroke(Color.BLACK);
        showrectangle.setEffect(shadow);

        ////    
    }

    public static void feedbacks(boolean set, String email) throws SQLException {

        feedshow.setText("Feedback of " + email);

        back_feed.setText("Back");

//
        feedback.setPrefSize(500, 200);
// visabiliry 
        feedshow.setVisible(set);
        feedback.setVisible(set);
        back_feed.setVisible(set);
        feedrectangle.setVisible(set);
//

// actions
        for (HashMap<String, Object> feedbackobject : feedbackk.showFeedback(email)) {

            feedback.setText("" + feedbackobject.get("message"));

        }

        back_feed.setOnAction(e -> {

            try {
                Category_features.showfeedback(set);
            } catch (SQLException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
            }
            feedshow.setVisible(false);
            feedback.setVisible(false);
            back_feed.setVisible(false);
            feedrectangle.setVisible(false);

        });

// 
// design 
        feedback.setEditable(false);
        feedback.getStyleClass().add("textfields");

        //Design 
        DropShadow shadow = new DropShadow();

        feedshow.getStyleClass().add("headlabel");
        feedshow.setTextFill(Color.BLACK);
        feedshow.setEffect(shadow);
        back_feed.getStyleClass().add("buttons");
        feedback.getStyleClass().add("textfields");
        feedback.setPrefSize(500, 200);
        back_feed.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        back_feed.setPrefSize(70, 30);
        back_feed.setOnMouseEntered(e -> {
            back_feed.setEffect(shadow);
        });

        back_feed.setOnMouseExited(e -> {

            back_feed.setEffect(null);
        });

        back_feed.setOnMouseClicked(e -> {
            back_feed.setStyle("-fx-background-color : white");
        });
        //

        //// rectangle
        feedrectangle.setX(300);
        feedrectangle.setY(300);
        feedrectangle.setWidth(700);
        feedrectangle.setHeight(400);
        feedrectangle.setArcWidth(20);
        feedrectangle.setArcHeight(20);
        //  rectangle.getStyleClass().add("rect");
        //rectangle.setOpacity(.5);
        feedrectangle.setFill(null);
        feedrectangle.setStrokeWidth(6);
        feedrectangle.setStroke(Color.BLACK);
        feedrectangle.setEffect(shadow);

        //// 
//
// layout sets
        feedshow.setLayoutX(320);
        feedshow.setLayoutY(310);

        feedback.setLayoutX(380);
        feedback.setLayoutY(380);

        back_feed.setLayoutX(380);
        back_feed.setLayoutY(600);

//
    }

    //---------------------------------------------------Offers---------------------------------------------------------------//
    public static void MakeOffer(boolean set) {

//        
        makenewoffer.setText("Make New Offer");
        pname_offer.setText("Product Name");
//        pprice_offer.setText("Product Price");
//        pcategory_offer.setText("Choose A Category");
        poffer.setText("Offer");
        productname_offer.setText("Enter Thw Product Name");
        // productprice_offer.setText("Enter  The Product's price");
        productoffer.setText("Enter The Product Offer");
        makeit.setText("Make IT");

//
// visabiliry 
        makenewoffer.setVisible(set);
//        menuButton_offer.setVisible(set);
//        pcategory_offer.setVisible(set);
        makeit.setVisible(set);
        pname_offer.setVisible(set);
//        pprice_offer.setVisible(set);
        poffer.setVisible(set);
        productname_offer.setVisible(set);
//        productprice_offer.setVisible(set);
        productoffer.setVisible(set);
        makerectangle.setVisible(set);
//

// actions
//
        //Design 
        DropShadow shadow = new DropShadow();
        menuButton_offer.getStyleClass().add("menubutton_");
        menuButton_offer.setPrefSize(200, 30);
        //headlabel
        makenewoffer.getStyleClass().add("headlabel");
        makenewoffer.setTextFill(Color.BLACK);
        makenewoffer.setEffect(shadow);
        //buttons
        makeit.getStyleClass().add("buttons");
        //labels
        pname_offer.getStyleClass().add("genariclabel");
        pname_offer.setTextFill(Color.web("#5BAAEC"));
        pprice_offer.setTextFill(Color.web("#5BAAEC"));
        pprice_offer.getStyleClass().add("genariclabel");
        pcategory_offer.setTextFill(Color.web("#5BAAEC"));
        pcategory_offer.getStyleClass().add("genariclabel");
        poffer.setTextFill(Color.web("#5BAAEC"));
        poffer.getStyleClass().add("genariclabel");
        // textfields
        productname_offer.getStyleClass().add("textfields");
        productname_offer.setStyle("-fx-font-style: bold");
        productprice_offer.getStyleClass().add("textfields");
        productprice_offer.setStyle("-fx-font-style: bold");
        productoffer.getStyleClass().add("textfields");
        productoffer.setStyle("-fx-font-style: bold");

        makeit.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");

        makeit.setPrefSize(80, 30);
        makeit.setOnMouseEntered(e -> {
            makeit.setEffect(shadow);
        });
        makeit.setOnMouseExited(e -> {

            makeit.setEffect(null);
        });
        makeit.setOnMouseClicked(e -> {
            makeit.setStyle("-fx-background-color : black");
        });
        makeit.setOnAction(e -> {

            try {
                if (product.Search(productname_offer.getText()).isEmpty()) {
                    Validation.showalert("Error Message", "Product Name", "The product that you entered is not Exist", AlertType.ERROR);

                } else if (!Validation.validate_string("^[1-9][0-9]++|[1-9][0-9]*[.][0-9]+", productoffer.getText())) {
                    Validation.showalert("Error Message", "Product offer", "The Float numbers are only allowed", AlertType.ERROR);
                } else {
                    offerobj.makeOffer(productname_offer.getText(), Integer.parseInt(productoffer.getText()));
                    Validation.showalert("Information Message", "Product :" + productname_offer.getText(), "Has offer : " + productoffer.getText(), AlertType.INFORMATION);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                Validation.showalert("Error Message", "Hoops", "you Have An Error in your System", AlertType.ERROR);
            }

        });

        //
        //// rectangle
        makerectangle.setX(300);
        makerectangle.setY(250);
        makerectangle.setWidth(700);
        makerectangle.setHeight(500);
        makerectangle.setArcWidth(20);
        makerectangle.setArcHeight(20);
        makerectangle.setFill(null);
        makerectangle.setStrokeWidth(6);
        makerectangle.setStroke(Color.BLACK);
        makerectangle.setEffect(shadow);

        ////  
// layout sets
        makenewoffer.setLayoutX(320);
        makenewoffer.setLayoutY(270);

        pcategory_offer.setLayoutX(390);
        pcategory_offer.setLayoutY(350);
        menuButton_offer.setLayoutX(600);
        menuButton_offer.setLayoutY(350);

        pname_offer.setLayoutX(390);
        pname_offer.setLayoutY(410);
        productname_offer.setLayoutX(600);
        productname_offer.setLayoutY(410);

        pprice_offer.setLayoutX(390);
        pprice_offer.setLayoutY(470);
        productprice_offer.setLayoutX(600);
        productprice_offer.setLayoutY(470);

        poffer.setLayoutX(390);
        poffer.setLayoutY(530);
        productoffer.setLayoutX(600);
        productoffer.setLayoutY(530);

        makeit.setLayoutX(480);
        makeit.setLayoutY(680);

//
    }

    public static void deleteoffer(boolean set) throws SQLException {
        offer.setText("Offers Panel");
        delete_offer.setText("Delete");

        listview_offer.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // visabiliry 
        offer.setVisible(set);
        listview_offer.setVisible(set);
        delete_offer.setVisible(set);
        deleterectangle.setVisible(set);
//

// actions
        delete_offer.setOnAction(e -> {
            String product_name = null;
            if (listview_offer.getSelectionModel().getSelectedItem() == null) {
                Validation.showalert("Error Message", null, "You Should Select one ", AlertType.ERROR);
            } else {
                product_name = (String) listview_offer.getSelectionModel().getSelectedItem();

                String[] splitStr = product_name.split("\\s+");

                try {
                    offerobj.deleteOffer(splitStr[6]);
                    Validation.showalert("Information Message", null, "You deleted the " + splitStr[6] + "offer", AlertType.INFORMATION);
                } catch (SQLException ex) {
                    Logger.getLogger(Category_features.class.getName()).log(Level.SEVERE, null, ex);
                    Validation.showalert("Error Message", null, "You have an error in your system the ", AlertType.WARNING);
                }
            }
        });

//
// layout sets
        offer.setLayoutX(320);
        offer.setLayoutY(310);
        listview_offer.setLayoutX(350);
        listview_offer.setLayoutY(350);
        delete_offer.setLayoutX(820);
        delete_offer.setLayoutY(660);
//

        // design
        listview_offer.setPrefWidth(600);
        listview_offer.setPrefHeight(300);
        listview_offer.getStyleClass().add("listvieww");
        ///

// design 
        feedback.setEditable(false);
        feedback.getStyleClass().add("textfields");

        //Design 
        DropShadow shadow = new DropShadow();

        offer.getStyleClass().add("headlabel");
        offer.setTextFill(Color.BLACK);
        offer.setEffect(shadow);
        delete_offer.getStyleClass().add("buttons");
        delete_offer.setStyle("-fx-font: 14 arial  ; -fx-font-style: bold ");
        delete_offer.setPrefSize(70, 30);
        delete_offer.setOnMouseEntered(e -> {
            delete_offer.setEffect(shadow);
        });

        delete_offer.setOnMouseExited(e -> {

            delete_offer.setEffect(null);
        });

        delete_offer.setOnMouseClicked(e -> {
            delete_offer.setStyle("-fx-background-color : white");
        });
        //

        //// rectangle
        deleterectangle.setX(300);
        deleterectangle.setY(300);
        deleterectangle.setWidth(700);
        deleterectangle.setHeight(400);
        deleterectangle.setArcWidth(20);
        deleterectangle.setArcHeight(20);
        //  rectangle.getStyleClass().add("rect");
        //rectangle.setOpacity(.5);
        deleterectangle.setFill(null);
        deleterectangle.setStrokeWidth(6);
        deleterectangle.setStroke(Color.BLACK);
        deleterectangle.setEffect(shadow);

        //// 
    }

    public static void showreport(boolean set) {

        Report.setText("Offers Panel");

        listview_reports.getItems().addAll("50% on  Samsung s5", "30% on iphone 4 ", "5% on 4k tv");
        listview_reports.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // visabiliry 
        Report.setVisible(set);
        listview_reports.setVisible(set);
        showreportrectangle.setVisible(set);
//

// actions
//
// layout sets
        Report.setLayoutX(320);
        Report.setLayoutY(310);
        listview_reports.setLayoutX(350);
        listview_reports.setLayoutY(350);

//
        // design
        listview_reports.setPrefWidth(600);
        listview_reports.setPrefHeight(300);
        listview_reports.getStyleClass().add("listvieww");
        ///

        //Design 
        DropShadow shadow = new DropShadow();

        Report.getStyleClass().add("headlabel");
        Report.setTextFill(Color.BLACK);
        Report.setEffect(shadow);

        //
        //// rectangle
        showreportrectangle.setX(300);
        showreportrectangle.setY(300);
        showreportrectangle.setWidth(700);
        showreportrectangle.setHeight(400);
        showreportrectangle.setArcWidth(20);
        showreportrectangle.setArcHeight(20);
        //  rectangle.getStyleClass().add("rect");
        //rectangle.setOpacity(.5);
        showreportrectangle.setFill(null);
        showreportrectangle.setStrokeWidth(6);
        showreportrectangle.setStroke(Color.BLACK);
        showreportrectangle.setEffect(shadow);

        //// 
    }

}
