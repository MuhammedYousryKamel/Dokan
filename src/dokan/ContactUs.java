package dokan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import shoponline.ShopOnline;

public class ContactUs {

    static void display() throws FileNotFoundException, SQLException {
        Stage window = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, Color.web("#837D7D"));
        Label contact = new Label("CONTACT US");
        Label name = new Label("NAME");
        Label email = new Label("EMAIL");
        Label message = new Label("MESSAGE");
        Label subject = new Label("SUBJECT");
        TextField tname = new TextField();
        TextField temail = new TextField();
        TextField tsubject = new TextField();
        TextArea tmessage = new TextArea();
        Button send = new Button("SEND");
        // background
        Image backgImage;
        String backgImagePath = "Contac.jpg";
        ImageView backg;
        backgImage = new Image(new FileInputStream(backgImagePath));
        backg = new ImageView(backgImage);
        backg.setX(-400);
        backg.setY(-190);
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

        contact.setLayoutX(750);
        contact.setLayoutY(80);
        contact.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 25));
        contact.setTextFill(Color.web("black"));
        name.setLayoutX(750);
        name.setLayoutY(180);
        name.setTextFill(Color.web("black"));
        name.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 21));
        email.setLayoutX(750);
        email.setLayoutY(280);
        email.setTextFill(Color.web("black"));
        email.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 21));
        subject.setLayoutX(750);
        subject.setLayoutY(380);
        subject.setTextFill(Color.web("black"));
        subject.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 21));
        message.setLayoutX(750);
        message.setLayoutY(480);
        message.setTextFill(Color.web("black"));
        message.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 21));

        tname.setLayoutX(870);
        tname.setLayoutY(180);
        tname.setPrefWidth(300);
        tname.setStyle("-fx-background-radius: 20px ;");

        temail.setLayoutX(870);
        temail.setLayoutY(280);
        temail.setPrefWidth(300);
        temail.setStyle("-fx-background-radius: 20px ;");

        tsubject.setLayoutX(870);
        tsubject.setLayoutY(380);
        tsubject.setPrefWidth(300);
        tsubject.setStyle("-fx-background-radius: 20px ;");

        tmessage.setLayoutX(870);
        tmessage.setLayoutY(480);
        tmessage.setMaxSize(450, 100);
          

        send.setLayoutX(1175);
        send.setLayoutY(590);
        send.setPrefWidth(150);
        send.setStyle("-fx-background-radius: 20px ;");
           ShopOnline.init();
           send.setOnMouseClicked(new EventHandler<Event>() {

            @Override
            public void handle(Event event) {
                app.models.Guest g = new app.models.Guest();
                try {
                    g.contact_us(tname.getText(),  temail.getText(),tsubject.getText() ,tmessage.getText() );
                } catch (SQLException ex) {
                    Logger.getLogger(ContactUs.class.getName()).log(Level.SEVERE, null, ex);
                }
                CustomerGui c = new CustomerGui();
                window.close();
                try {
                    c.display();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CustomerGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ContactUs.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        root.getChildren().addAll(contact, name, email, message, subject, tname, temail, tsubject, tmessage, send, iv1);
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
        logo.setY(625);
        logo.setFitWidth(800);
        logo.setPreserveRatio(true);
        logo.setSmooth(true);
        logo.setCache(true);
        root.getChildren().add(logo);
        window.setFullScreen(true);
        window.setScene(scene);
        window.setTitle("ContactUs");
        window.show();

    }
}
