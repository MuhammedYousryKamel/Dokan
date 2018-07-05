package dokan;

import app.models.Category;
import app.models.Customer;
import app.models.Offer;
import app.models.Pair;
import static dokan.Category_features.feedbackk;
import static dokan.Category_features.listview_offer;
import static dokan.Category_features.menuButton_add;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import app.models.Category;
import app.models.Validation;
import javafx.scene.control.Alert;

/**
 *
 * @author moham
 */
public class AdminPanal extends Main {

    Stage window;
    Scene scene1;
    public static Image logoutImage, refershimage;
    private String logoutImagePath = "logout-512.png";
    private String refershImagePath = "recurring-appointment-xxl.png";
    public ImageView logoutview, refreshImageview;
    public static Image logoImage;
    private String logoImagePath = "Untitled-1.png-.png";
    public ImageView logo;
    Group layout = new Group();

    public void display() throws FileNotFoundException, SQLException {
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
        layout.getChildren().add(backg);
        // layout
//////////
        //menus   
        Stage primaryStage = new Stage();
        Menu categorymenu = new Menu("Categories");
        Menu customermenu = new Menu("Customer");
        Menu feedbackmenu = new Menu("FeedBack");
        Menu offersmenu = new Menu("Offers");
        Menu reportsmenu = new Menu("Reports");
        //actions 
        MenuItem addcategory = new MenuItem("Add new Category");

        addcategory.setOnAction(e -> {

            Category_features.addcategoryform(true);
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.MakeOffer(false);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.showreport(false);

        });
        addcategory.getStyleClass().add("add");
        MenuItem addproduct = new MenuItem("Add new product");
        Category category_ = new Category();
          
        addproduct.setOnAction(e -> {
            
           
            try {
                Category_features.addnewproduct(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.MakeOffer(false);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.showreport(false);
        });
       

        MenuItem editproduct = new MenuItem("Edit Product");
        editproduct.setOnAction(e -> {
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.MakeOffer(false);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.showreport(false);
        }
        );

        addcategory.getStyleClass().add("diac");
        addproduct.getStyleClass().add("diac");
        editproduct.getStyleClass().add("diac");

        // customer 
        MenuItem diactivate = new MenuItem("Diactivate");
        diactivate.setOnAction((ActionEvent e) -> {
            Category_features.diactivateaccount(true);
            Category_features.addcategoryform(false);

            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.MakeOffer(false);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.showreport(false);
        });
        diactivate.getStyleClass().add("diac");
        // feedback

        MenuItem showfeedback = new MenuItem("Show Feedback");
        showfeedback.setOnAction(e -> {
            try {
                for (HashMap<String, Object> feedbackobject : feedbackk.showFeedbackEmails()) {
                    
                  Category_features.listview_show.getItems().add(feedbackobject.get("email"));
                    
                    
                    
                }  } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.showfeedback(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            Category_features.MakeOffer(false);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.showreport(false);
        });
        showfeedback.getStyleClass().add("diac");
        //offers
        MenuItem makeoffer = new MenuItem("Make Offer");
        makeoffer.setOnAction(e -> {

            Category_features.MakeOffer(true);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            Category_features.showreport(false);
        });

        MenuItem deleteoffer = new MenuItem("delete offer");
        
        
        
        deleteoffer.setOnAction(e -> {
            
            Offer offer = new Offer();
         ArrayList<Pair<String,Integer>> showoffer = new ArrayList();
          
         
            try {
                showoffer =offer.showOffers();
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        for(Pair getter :  showoffer){
            
      //   System.out.println(""+getter.getL()+getter.getR());
           if(getter.getL() == null || getter.getR()==null) {
               Validation.showalert("Error Message","Offers", "NO offer existed", Alert.AlertType.ERROR);
           }
           else{
       Category_features.listview_offer.getItems().addAll("We Have a new discount on "+getter.getL()+" = "+getter.getR());
        
        }
        }
            try {
                Category_features.deleteoffer(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.MakeOffer(false);
            Category_features.showreport(false);

        });

        makeoffer.getStyleClass().add("diac");
        deleteoffer.getStyleClass().add("diac");
// reports
        MenuItem showreport = new MenuItem("Show Report");
        showreport.setOnAction(e->{
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.MakeOffer(false);
            Category_features.showreport(true);
        
        
        
        });
        showreport.getStyleClass().add("diac");
        
        
        //////////////////////////////////
        //items of category menu
        categorymenu.getItems().add(addcategory);
        categorymenu.getItems().add(new SeparatorMenuItem());
        categorymenu.getItems().add(addproduct);
        categorymenu.getItems().add(editproduct);

        //items for customer menu
        customermenu.getItems().add(diactivate);

        //items for feedback menu 
        feedbackmenu.getItems().add(showfeedback);

        //items for offers menu
        offersmenu.getItems().add(makeoffer);
        offersmenu.getItems().add(deleteoffer);
        //items for reports menu
        reportsmenu.getItems().add(showreport);
        
        // the menu bar of panel 
        MenuBar bar = new MenuBar();
        bar.getMenus().add(categorymenu);
        bar.getMenus().add(customermenu);
        bar.getMenus().add(feedbackmenu);
        bar.getMenus().add(offersmenu);
        bar.getMenus().add(reportsmenu);
        bar.getStyleClass().add("bar-m");
        //////////////////////////
        bar.setLayoutX(200);
        bar.setLayoutY(120);
       ///////////////////////////

        //logo photo
        logoImage = new Image(new FileInputStream(logoImagePath));
        logo = new ImageView(logoImage);
        logo.setX(0);
        logo.setY(0);
        logo.setFitWidth(400);
        logo.setPreserveRatio(true);
        logo.setSmooth(true);
        logo.setCache(true);
        layout.getChildren().add(logo);

        //logout photo
        logoutImage = new Image(new FileInputStream(logoutImagePath));
        logoutview = new ImageView(logoutImage);
        logoutview.setX(1250);
        logoutview.setY(40);
        logoutview.setFitWidth(50);
        logoutview.setPreserveRatio(true);
        logoutview.setSmooth(true);
        logoutview.setCache(true);
        logoutview.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                primaryStage.close();

                Home h = new Home();
                try {
                    try {
                        h.start(primaryStage);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //refersh photo 
        refershimage = new Image(new FileInputStream(refershImagePath));
        refreshImageview = new ImageView(refershimage);
        refreshImageview.setX(1150);
        refreshImageview.setY(40);
        refreshImageview.setFitWidth(50);
        refreshImageview.setPreserveRatio(true);
        refreshImageview.setSmooth(true);
        refreshImageview.setCache(true);
        refreshImageview.setOnMouseClicked(e -> {
            Category_features.MakeOffer(false);
            try {
                Category_features.deleteoffer(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.diactivateaccount(false);
            Category_features.addcategoryform(false);
            try {
                Category_features.editproduct(false);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.addnewproduct(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.editproductform(false, null);
            try {
                Category_features.showfeedback(false);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Category_features.feedbacks(false, null);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
            }
            Category_features.showreport(false);

        }
        );

        /////////////
        layout.getChildren().addAll(bar, logoutview, refreshImageview);
        layout.getChildren().addAll(Category_features.rectangle, Category_features.addcateg, Category_features.btn, Category_features.cname,
                Category_features.cdetails, Category_features.categoryname, Category_features.categorydetails);

        layout.getChildren().addAll(Category_features.pquantity_add,Category_features.productquantity_add,Category_features.addrectangle, Category_features.product_add, Category_features.pprice_add, Category_features.pdetails_add, Category_features.productname_add,
                Category_features.productprice_add, Category_features.Productdetails_add, Category_features.submit_add, Category_features.pname_add, Category_features.pcategory_add, Category_features.menuButton_add
        );
        layout.getChildren().addAll(Category_features.editrectangle, Category_features.editproduct, Category_features.edit, Category_features.searchfield, Category_features.searchview, Category_features.delete, Category_features.pname);

        layout.getChildren().addAll(Category_features.pquantity_editform,Category_features.productquantity_editform,Category_features.editformrectangle, Category_features.product_editform, Category_features.pname_editform, Category_features.pprice_editform, Category_features.pdetails_editform,
                Category_features.pcategory_editform, Category_features.productname_editform, Category_features.productprice_editform, Category_features.Productdetails_editform,
                Category_features.back_edit, Category_features.submit_editform, Category_features.menuButton_editform
        );

        layout.getChildren().addAll(Category_features.diacativaterectangle, Category_features.diactcustomer, Category_features.customeremail, Category_features.Diactivate, Category_features.email);

        layout.getChildren().addAll(Category_features.listview_show,Category_features.feedrectangle, Category_features.showrectangle, Category_features.showbutton, Category_features.feed, Category_features.feedshow, Category_features.feedback, Category_features.back_feed);
        layout.getChildren().addAll(Category_features.deleterectangle, Category_features.makerectangle, Category_features.makeit, Category_features.makenewoffer,  Category_features.offer, Category_features.pname_offer, Category_features.poffer,
                Category_features.productname_offer,  Category_features.productoffer, Category_features.delete_offer, Category_features.listview_offer);

        layout.getChildren().addAll(Category_features.showreportrectangle,Category_features.Report,Category_features.listview_reports);
        
        
        Category_features.MakeOffer(false);
        Category_features.deleteoffer(false);
        Category_features.diactivateaccount(false);
        Category_features.addcategoryform(false);
        try {
            Category_features.editproduct(false);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdminPanal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Category_features.addnewproduct(false);
        Category_features.editproductform(false, null);
        Category_features.showfeedback(false);
        Category_features.feedbacks(false, null);
        Category_features.showreport(false);

        //
        window = primaryStage;
        //
        scene1 = new Scene(layout, Color.WHITESMOKE);
        scene1.getStylesheets().add("Adminpanelcss.css");
        Category_features.addcategoryform(false);
        window.setScene(scene1);
        window.setFullScreen(true);
        window.setTitle("Admin Panel");
        window.show();

    }

}
