package dokan;

import app.App;
import app.models.Customer;
import app.models.Validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Labels;
import shoponline.ShopOnline;

/**
 *
 * @author darkboy55
 */
public class Home extends Application {
    Customer cu;
    static  String em;
    public static  TextField emailtext = new TextField();
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, SQLException {
        Group root = new Group();
        Scene scene = new Scene(root, Color.web("#837D7D"));
        // background
        Image backgImage;
        String backgImagePath = "backg.jpg";
        ImageView backg;
        backgImage = new Image(new FileInputStream(backgImagePath));
        backg = new ImageView(backgImage);
        backg.setX(-375);
        backg.setY(-375);
            backg.setFitWidth(1775);

            backg.setPreserveRatio(true);
        backg.setSmooth(true);
        backg.setCache(true);
        root.getChildren().add(backg);

        //logo
        Image image1 = new Image(new FileInputStream("Untitled-2.png"));
        

        PasswordField passtext = new PasswordField();

        Label elabel = new Label("Email");
        Label plabel = new Label("Password");

        Label register = new Label("You Can LogIn Now For Free");
        Button loginbtn = new Button("LOGIN");
        Button forgetbtn = new Button("Forget password");
        Button regbtn = new Button("Registration");
        Button gbtn = new Button("Login as a guest");
        ImageView iv1 = new ImageView();

        iv1.setImage(image1);
        iv1.setFitWidth(600);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        iv1.setX(0);
        iv1.setY(0);

        emailtext.setLayoutX(300);
        emailtext.setLayoutY(200);
        emailtext.setPrefWidth(250);
        passtext.setLayoutX(300);
        passtext.setLayoutY(250);
        passtext.setPrefWidth(250);
        elabel.setLayoutX(190);
        elabel.setLayoutY(200);
        plabel.setLayoutX(190);
        plabel.setLayoutY(250);
        register.setLayoutX(250);
        register.setLayoutY(400);
        register.setTextFill(Color.web("#BCFFF2"));
        elabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        plabel.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 18));
        register.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        loginbtn.setLayoutX(350);
        loginbtn.setLayoutY(300);
        forgetbtn.setLayoutX(450);
        forgetbtn.setLayoutY(300);
        regbtn.setLayoutX(350);
        regbtn.setLayoutY(450);
        gbtn.setLayoutX(450);
        gbtn.setLayoutY(450);
        loginbtn.getStyleClass().add("loginbtn");
        forgetbtn.getStyleClass().add("forgetbtn");
        regbtn.getStyleClass().add("regbtn");
        gbtn.getStyleClass().add("gbtn");
        passtext.getStyleClass().add("passtext");
        emailtext.getStyleClass().add("emailtext");
        passtext.getStyleClass().add("passtext");
        root.getChildren().addAll(iv1, emailtext, passtext, elabel, plabel, loginbtn, forgetbtn, regbtn, gbtn, register);
        ShopOnline.init();
        loginbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                String e = emailtext.getText();
                String p = passtext.getText();
                try {
                    if (Customer.login(e, p)) {
                        cu = (Customer)App.getCurrentCustomer();
                        System.out.println(cu.getRole_id());
                        if(cu.getRole_id() == 1)
                        {
                        CustomerGui c = new CustomerGui();
                        try {
                            c.display();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                        else 
                        {
                            AdminPanal a = new AdminPanal();
                            try {
                                a.display();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    else {
                        primaryStage.close();
                        Home h = new Home();
                        try {
                            h.start(primaryStage);
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        regbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                try {
                    try {
                        RegestrationGUI.display();
                    } catch (SQLException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        gbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
                try {
                    Guest g = new Guest();
                    g.dispaly();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
       forgetbtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
               app.models.Guest g = new app.models.Guest();
               ArrayList<String> ar = new ArrayList<String>();
                try {
                   
                 ar = g.Forget_password(emailtext.getText());
                
                em =emailtext.getText();
           
                  
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
             
                    
                       if (ar.size()>0)
                {
                     if(Validation.validate_string(".+",emailtext.getText())){
                try {
                    ForgetPassword.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                }
                else 
                {
                      Validation.showalert("Error Message", "Email", "is invalid", Alert.AlertType.ERROR);
                }

            }
        });
        Rectangle categorybox = new Rectangle(0, 640, 1450, 250);
//        categorybox.setArcWidth(30);
//        categorybox.setArcHeight(30);

        categorybox.setStyle("-fx-fill: #222;");
        categorybox.setEffect(new DropShadow(40, Color.BLACK));
        root.getChildren().add(categorybox);
        Image logoImage;
        String logoImagePath = "FOOTER.png";
        ImageView logo;
        logoImage = new Image(new FileInputStream(logoImagePath));
        logo = new ImageView(logoImage);
        logo.setX(350);
        logo.setY(630);
        logo.setFitWidth(800);
        logo.setPreserveRatio(true);
        logo.setSmooth(true);
        logo.setCache(true);

        root.getChildren().add(logo);
        scene.getStylesheets().add("customer.css");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Home");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }

}
