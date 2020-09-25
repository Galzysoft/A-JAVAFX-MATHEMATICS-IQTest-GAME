/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ONYEKA
 */
public class Avila_MathIQ_Test extends Application {
     private double xoffset=0;
       private double yoffset=0;
 Connection con=null;
    @Override
    public void start(Stage stage) throws IOException   {
            Parent root = FXMLLoader.load(getClass().getResource("splashscreen.fxml"));
//            stage.getIcons().add(new Image("FullSizeRender.jpg"));
            stage.getIcons().add(new Image(Avila_MathIQ_Test.class.getResourceAsStream("FullSizeRender.jpg")));
        
  stage.initStyle(StageStyle.UNDECORATED); 
   stage.centerOnScreen();
          
    
    
    Scene scene = new Scene(root);
    
     
     
     // stage.setIconified(true);
    
     
    
     
        stage.setScene(scene);
        
        stage.show();   //gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg
          DB_manager db=new DB_manager();
        try {
           con= db.connect();
            System.out.println("DB created");
        } catch (ClassNotFoundException ex) {
            System.out.println("DB not created");
        } 
        
      
        
        try {
            db.create_tables();
            System.out.println("tables  created");
        } catch (SQLException ex) {
         System.out.println("Tables not created"+ex.getMessage());   }
try {
            db.iq1();
            System.out.println("tables  created");
        } catch (SQLException ex) {
         System.out.println("Tables not created"+ex.getMessage());   }
try {
            db.iqinterme1();
            System.out.println("tables  created");
        } catch (SQLException ex) {
         System.out.println("Tables not created"+ex.getMessage());   }

try {
            db.iqexpert1();
            System.out.println("tables  created");
        } catch (SQLException ex) {
         System.out.println("Tables not created"+ex.getMessage());   }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
