package dokan;

import app.models.Validation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shoponline.ShopOnline;

public class ForgetPassword {
public static String  email(String myemail)
      {
          return myemail;
      }
    public static void display() throws FileNotFoundException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Group root = new Group();
        Scene scene = new Scene(root, 600, 250);
        //logo
        Image image1 = new Image(new FileInputStream("Untitled-2.png"));
        TextField emailtext = new TextField();
        TextField passtext = new TextField();
    try {
        ShopOnline.init();
    } catch (SQLException ex) {
        Logger.getLogger(ForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
    }
        ImageView iv1 = new ImageView();

        iv1.setImage(image1);
        iv1.setFitWidth(200);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        iv1.setX(0);
        iv1.setY(0);
        // background
        Image backgImage;
        String backgImagePath = "light.jpg";
        ImageView backg;
        backgImage = new Image(new FileInputStream(backgImagePath));
        backg = new ImageView(backgImage);
        backg.setX(0);
        backg.setY(0);
        backg.setFitWidth(700);

        backg.setPreserveRatio(true);
        backg.setSmooth(true);
        backg.setCache(true);
        root.getChildren().add(backg);
        Button submit = new Button("submit");
        TextField femail1 = new TextField();

        PasswordField fNewPass1 = new PasswordField();
        Label femail2 = new Label("Email");
        Label fNewPass2 = new Label("New Password");
        femail1.setLayoutX(230);
        femail1.setLayoutY(100);
        femail1.setPrefWidth(250);
        femail1.setStyle("-fx-background-radius:20px;");
        femail2.setLayoutX(50);
        femail2.setLayoutY(100);
        femail2.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.ITALIC, 21));
        submit.setLayoutX(380);
        submit.setLayoutY(200);
        submit.setPrefWidth(100);
        submit.setStyle("-fx-background-radius:20px;");
        fNewPass1.setLayoutX(230);
        fNewPass1.setLayoutY(150);
        fNewPass1.setPrefWidth(250);
        fNewPass1.setStyle("-fx-background-radius:20px;");
        fNewPass2.setLayoutX(50);
        fNewPass2.setLayoutY(150);
        fNewPass2.setFont(Font.font("Verdana", FontWeight.THIN, FontPosture.ITALIC, 21));
        
        
        Home h = new Home();
  app.models.Guest g = new app.models.Guest();
        femail1.setText(h.em);
         root.getChildren().addAll(femail2, fNewPass2, femail1, fNewPass1, submit, iv1);
        HashMap<String,Object> hm =new HashMap<>();
       
         submit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
        
     if(Validation.validate_string(".+.+.+.+.+.+",fNewPass1.getText())){
            
                 hm.put("password", fNewPass1.getText());
                try {
                    g.forget(hm,femail1.getText());
                    

                } catch (SQLException ex) {
                    Logger.getLogger(ForgetPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
                    window.close();
     }
       else 
                {
                      Validation.showalert("Error Message", "Password", " must be at least six digit", Alert.AlertType.ERROR);
                }
     
            }
        });
        window.setScene(scene);
        window.setTitle("ForgetPassword");
        window.show();
    }

}
