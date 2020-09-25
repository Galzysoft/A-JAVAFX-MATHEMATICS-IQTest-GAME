/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXSnackbar;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class Main_dashController implements Initializable {RotateTransition transision,transision2,transision3;Connection con; FXMLLoader dbm=new FXMLLoader(getClass().getResource("mainbody.fxml"));
      @FXML
    private TabPane taboo;
@FXML
    private VBox odi;
   @FXML
    private Tab vb;

  @FXML
    private Tab thome;
     @FXML
    private AnchorPane avila; 
    @FXML
    private AnchorPane rootpane;
  @FXML
    private HBox basepanee;

    @FXML
    private VBox beg;

    @FXML
    private Button b;

    @FXML
    private Text btext;

    @FXML
    private VBox inte;

    @FXML
    private Button i;

    @FXML
    private VBox exp;

    @FXML
    private Button e;
    
    
    
    
    
    @FXML
     private void beginner( ActionEvent event) {
      
        try {
//         AnchorPane root = FXMLLoader.load(getClass().getResource("beginner.fxml"));
             FXMLLoader loader=new FXMLLoader(getClass().getResource("beginner.fxml"));
              Parent root =  loader.load();
           
            BeginnerController dash = (BeginnerController)loader.getController(); 
               dash.username(userr);
               vb.setDisable(false);
              vb.setContent(root);
              taboo.getSelectionModel().select(vb);
              thome.setDisable(true);
               
               
//            rootpane.getChildren().setAll(root);
            
                     
                     
                     
                     
                     
        } catch (IOException ex) {                     

            System.out.println(ex.getMessage());
            } 
     }
       @FXML
     private void intermediate( ActionEvent event) {
         try {
//            AnchorPane root = FXMLLoader.load(getClass().getResource("beginner.fxml"));
             FXMLLoader loader=new FXMLLoader(getClass().getResource("intermediate.fxml"));
              Parent root =  loader.load();
           
            IntermediateController dash = (IntermediateController)loader.getController();
               dash.username(userr);vb.setDisable(false);
           vb.setContent(root);
              taboo.getSelectionModel().select(vb);
              thome.setDisable(true);
                  
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            } 
     }
      @FXML
     private void expert( ActionEvent event) {
         try {
//            AnchorPane root = FXMLLoader.load(getClass().getResource("beginner.fxml"));
             FXMLLoader loader=new FXMLLoader(getClass().getResource("expert.fxml"));
              Parent root =  loader.load();
           
            ExpertController dash = (ExpertController)loader.getController();
               dash.username(userr);vb.setDisable(false);
            vb.setContent(root);
              taboo.getSelectionModel().select(vb);
              thome.setDisable(true);
                 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            } 
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    bbnmm();
  // TODO
    }    
         public void bbnmm(){
    
           FadeTransition   trans2 = new FadeTransition(Duration.seconds(4),basepanee);
                trans2.setFromValue(0);
                trans2.setToValue(1);
                trans2.setCycleCount(1);
                trans2.setAutoReverse(false);
         trans2.play();
  trans2.setOnFinished((ActionEvent event1) -> {
 
        transision = new RotateTransition();
            transision.setDuration(Duration.millis(700));
            transision.setNode( beg);
            transision.setFromAngle(45);
            transision.setToAngle(360);
            transision.setCycleCount(2);
            transision.setAutoReverse(false);
            transision.play();// TODO

      transision.setOnFinished((ActionEvent event11) -> {
    
   
        transision2 = new RotateTransition();
            transision2.setDuration(Duration.millis(700));
            transision2.setNode( inte);
            transision2.setFromAngle(45);
            transision2.setToAngle(360);
            transision2.setCycleCount(2);
            transision2.setAutoReverse(false);
            transision2.play();// TODO

     transision2.setOnFinished((ActionEvent event111) -> {
        transision3 = new RotateTransition();
            transision3.setDuration(Duration.millis(700));
            transision3.setNode( exp);
            transision3.setFromAngle(45);
            transision3.setToAngle(360);
            transision3.setCycleCount(2);
            transision3.setAutoReverse(false);
            transision3.play();// TODO
 JFXSnackbar bar=new JFXSnackbar(basepanee);
                bar.getStylesheets().add(Avila_MathIQ_Test.class.getResource("good.css").toExternalForm());

                bar.show("Welcome To Avilas MathIQ 1", 3000);
            //    bbb1(text);
           
});         
     }) ;
    }) ;
    } 
          public void username1(String user){
 userr=user;
     System.out.println("user maindash don showooo "+userr);
 }
 String userr;
}
