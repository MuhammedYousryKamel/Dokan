/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author moham
 */
public class Validation {
    
    
     public static void showalert(String title, String headertext, String message, Alert.AlertType type) {
        Alert alerting = new Alert(type);
        alerting.setTitle(title);
        alerting.setHeaderText(headertext);
        alerting.setContentText(message);
        alerting.showAndWait();
    }

    public static boolean validate_string(String pattern, String input) {
        Pattern pattern_ = Pattern.compile(pattern);
        return pattern_.matcher(input).matches();

    }
}
