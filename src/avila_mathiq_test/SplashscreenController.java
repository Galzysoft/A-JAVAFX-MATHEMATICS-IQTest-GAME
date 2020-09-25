/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class SplashscreenController implements Initializable {

   private double xoffset=0;
    private double yoffset=0;
   


@FXML
    private AnchorPane root;

    @FXML
    private Pane logo;

    @FXML
    private Circle circleglow;
private void loadsplashscren(){ FadeTransition  trans21 = new FadeTransition(Duration.seconds(5), root);
                trans21.setFromValue(1);
                trans21.setToValue(0);
                trans21.setCycleCount(1);
                trans21.setAutoReverse(false);

        // TODO
     TranslateTransition  transision=new TranslateTransition();
        transision.setDuration(Duration.millis(1000));
transision.setNode(logo);
transision.setByY(350);
transision.setCycleCount(1);
transision.setAutoReverse(false);

     FadeTransition   trans2 = new FadeTransition(Duration.seconds(8), root);
                trans2.setFromValue(0);
                trans2.setToValue(1);
                trans2.setCycleCount(1);
                trans2.setAutoReverse(false);
         trans2.play();
        // anchor31.setVisible(true);
          trans2.setOnFinished((event1) -> {
         transision.play();
          });
 transision.setOnFinished(( event2)->{
                   trans21.play();
 });
 //trans21.setOnFinished((ActionEvent event21) -> {
              /*     try {
              System.out.println("student ooooooooooooooooooooooooo");
              Parent rooot = FXMLLoader.load(Splash_screenController.this.getClass().getResource("sign_in.fxml"));
              Stage stage=new Stage();
              stage.initStyle(StageStyle.UNDECORATED);
              stage.centerOnScreen();
              rooot.setOnMousePressed((MouseEvent event) -> {
              xoffset=event.getSceneX();
              yoffset= event.getSceneY();
              });           rooot.setOnMouseDragged((MouseEvent event) -> {
              stage.setX(event.getScreenX()-xoffset);
              stage.setY(event.getScreenY()-yoffset);
              });         Scene scene = new Scene(rooot);
              // stage.setIconified(true);
              stage.setScene(scene);
              scene.getStylesheets().add(STUDENT_PROJECT_MANAGEMENTSYS.class.getResource("sign_in.css").toExternalForm());
              stage.show();
              } catch (IOException ex) {
              Logger.getLogger(Splash_screenController.class.getName()).log(Level.SEVERE, null, ex);
               */
        //  });
    
        }
  
/**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadsplashscren();
            new SplashScreen().start();
  //new SplashScreen().st
           System.out.println("avila.Splash_screenController.initialize()");
        
          
    
  
        
    }    
   
           class SplashScreen extends Thread{
          @Override
          public void run(){
              try {
                  Thread.sleep(9000);
                  Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                      Parent root = null;
                          try {
                              root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                          } catch (IOException ex) {
                              System.out.println("error "+ex.getMessage());
                             }
                    
                  Stage stage = new Stage();
                  Scene scene = new Scene(root);
                  stage.getIcons().add(new Image(Avila_MathIQ_Test.class.getResourceAsStream("FullSizeRender.jpg")));
       
                  stage.setScene(scene);
                   
                   stage.initStyle(StageStyle.UNDECORATED);
              stage.centerOnScreen();
              root.setOnMousePressed((MouseEvent event) -> {
              xoffset=event.getSceneX();
              yoffset= event.getSceneY();
              });           root.setOnMouseDragged((MouseEvent event) -> {
              stage.setX(event.getScreenX()-xoffset);
              stage.setY(event.getScreenY()-yoffset);
              }); 
                  
                  
                  stage.show();
                  
                  logo.getScene().getWindow().hide();
                      }
                  });
                  
              } catch (InterruptedException ex) {
                  }
    }
    }
    
    
    
    
    
    
}
