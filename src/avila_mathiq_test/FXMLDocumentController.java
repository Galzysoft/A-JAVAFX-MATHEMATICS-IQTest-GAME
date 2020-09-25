/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ONYEKA
 */
public class FXMLDocumentController implements Initializable {
     Connection con=null;
     Statement stmt=null;
      String user ; String pass ;
                @FXML
    private JFXSpinner pi;
           
    

    @FXML
    private VBox toastt;
      @FXML
    private AnchorPane anchoo;
        @FXML
    private JFXButton btn;
  
    @FXML
    private JFXButton minimize;

    @FXML
    private JFXButton exit;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton signup;

    @FXML
    private JFXTextField username;
 private double xoffset=0;
       private double yoffset=0;
  
    @FXML
    private void login1(ActionEvent event) throws IOException  {          
    
     
                pi.setVisible(true);
         new progressionnns().start();
         
    }
          @FXML
     private void minimize(ActionEvent event){
        
            ((Stage)  anchoo.getScene().getWindow()).setIconified(true);
       
          
     
     }@FXML
    private void exit(ActionEvent event) {
    System.exit(0);}
    @FXML
    private void login(ActionEvent event) throws IOException {
 Stage stage1 = (Stage) btn.getScene().getWindow();

                Stage stage;
                Parent root;
            //if(event.getSource()==btn){
                    stage = new Stage();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("signup.fxml"));
             
              root =  loader.load();
       
   
                        stage.setTitle("Avila Math_IQ_Test");
                      

//decorator.setMinWidth(989);
//decorator.setMinHeight(1007);
// root.getStylesheets().add(BIZ_APP.class.getResource("mainoo.css").toExternalForm());

           
Scene scene = new Scene(root);  

     stage.getIcons().add(new Image(Avila_MathIQ_Test.class.getResourceAsStream("FullSizeRender.jpg")));
       
                stage.setScene(scene);
          stage.setResizable(false);stage.centerOnScreen();
            stage.initStyle(StageStyle.UNDECORATED); 
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
     @Override
     public void handle(MouseEvent event) {
         xoffset=event.getSceneX();
         yoffset= event.getSceneY();
     }
 });           
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
     @Override
     public void handle(MouseEvent event) {
         stage.setX(event.getScreenX()-xoffset);
         stage.setY(event.getScreenY()-yoffset);
     }
 }); 
                       stage1.close();

                    stage.show();
                  
              }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         username.setFocusTraversable(false); password.setFocusTraversable(false);
        btn.setFocusTraversable(false); 
//        bb.setFocusTraversable(false); 
        
       
    // TODO
    } 
     class progressionnns extends Thread{
          @Override
          public void run(){
              try {
                  Thread.sleep(1200);
                  Platform.runLater(() -> {
                      //  Parent root = null;
                      
                      try {
                          log();
                      } catch (IOException ex) {
                 Alert loginerror1 = new Alert(Alert.AlertType.ERROR);
                loginerror1.setTitle("SignIn Error");
                loginerror1.setHeaderText(null);
                loginerror1.setContentText("unable to sign in");
                loginerror1.initModality(Modality.APPLICATION_MODAL);
                loginerror1.showAndWait();
                }
                  });
                  
              } catch (InterruptedException ex) {
                  }
    }
    }
    private void log() throws IOException  {
      pi.setVisible(true);
        new SplashScreen().start();
     
     }
     class SplashScreen extends Thread{
          @Override
          public void run(){
              try { 
                  Thread.sleep(1000);
                  Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                     try {
      DB_manager db=new DB_manager();
        con=db.connect();
       stmt=null;
     stmt = con.createStatement();
  
        String sql="select * from LOGIN2 where username='"+username.getText()+"' and password='"+password.getText()+"' ";    
       System.out.println("sqllllll");
        ResultSet rst=stmt.executeQuery(sql);
                         System.out.println("aa");
        while(rst.next()){ 
         
         
            System.out.println("passed");
                     user=rst.getString("username");
            System.out.println("aa "+user);
              pass=rst.getString("password");
              System.out.println("aa"+pass);
            System.out.println( "userr"+user);
        System.out.println( "passss"+pass);
        }
            
            if (username.getText().equalsIgnoreCase(user)&&password.getText().equalsIgnoreCase(pass))
                
                
                
                
                
                
            {   
                   
        
     
           
                 
                
                Stage stage1 = (Stage) btn.getScene().getWindow();

                Stage stage;
                Parent root;
            //if(event.getSource()==btn){
                    stage = new Stage();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Dashbord.fxml"));
                   root =  loader.load(); DashbordController consst=(DashbordController)loader.getController();
                             
       consst.usersss(user);
 
             System.out.println("loadeazud"+user);
               
         System.out.println("111111111111");
           
  
  stage .setMinWidth(1100);stage .setMinHeight(600);
                        stage.setTitle("Avila MathIQ 1");
                     JFXDecorator decorator =new JFXDecorator(stage, root);
decorator.setCustomMaximize(true);

//decorator.setMinWidth(989);
//decorator.setMinHeight(1007);
// root.getStylesheets().add(BIZ_APP.class.getResource("mainoo.css").toExternalForm());

           
Scene scene = new Scene(decorator, 1139, 625);  
 stage.getIcons().add(new Image(Avila_MathIQ_Test.class.getResourceAsStream("FullSizeRender.jpg")));
       
    
                  stage.setScene(scene);
                 
             //     stage.initStyle(StageStyle.UNIFIED);
                //  stage.setResizable(true);
                  
                 // stage.setMinHeight(661);
  // stage.setMinWidth(1285);
    
              stage.centerOnScreen(); 
//              root.setOnMousePressed((MouseEvent event1) -> {
//                  xoffset = event1.getSceneX();
//                  yoffset = event1.getSceneY();
// });          
//                      
//              
//              root.setOnMouseDragged((MouseEvent eventa) -> {
//              stage.setX(eventa.getScreenX()-xoffset);
//              stage.setY(eventa.getScreenY()-yoffset);
//              });  stage.centerOnScreen();
//                    //scene.getStylesheets().add(STUDENT_PROJECT_MANAGEMENTSYS.class.getResource("sign_up.css").toExternalForm());
//                    
//                    
                   // btn.getScene().getWindow().hide();
                    stage1.close();

                    stage.show();
       
               // }
            /*
                JFXSnackbar bar=new JFXSnackbar(motherpane);
                
                bar.show("Welcome To Galzy Students Project Management System", 3000);
                Alert loginerror = new Alert(Alert.AlertType.CONFIRMATION);
                loginerror.setTitle("SignIn Sucessfull");
                loginerror.setHeaderText(null);
                
                loginerror.setContentText("welcome");
                loginerror.initModality(Modality.APPLICATION_MODAL);
                loginerror.showAndWait();*/
                
            } else
            { System.out.println("eroooorrrrrrrrrro");
        System.out.println( "userr"+user);
        System.out.println( "passss"+pass);
    
               pi.setVisible(false);
        JFXSnackbar bar=new JFXSnackbar(anchoo);
//                bar.getStyle("-fx-background-color:green;");
bar.getStylesheets().add(Avila_MathIQ_Test.class.getResource("fail.css").toExternalForm());
        
                bar.show("wrong username or password", 2000);
   
                 
              
            }
        
    } catch (SQLException ex) {
      Alert loginerror1 = new Alert(Alert.AlertType.ERROR);
                loginerror1.setTitle("SignIn Error");
                loginerror1.setHeaderText(null);
                loginerror1.setContentText("login error via server"+ex.getErrorCode());
                loginerror1.initModality(Modality.APPLICATION_MODAL);
                loginerror1.showAndWait();
                }         catch (IOException ex) {
                              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                          } catch (ClassNotFoundException ex) {
                              Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                          }
        
        
        
     
                      }
                  });
                  
              } catch (InterruptedException ex) {
                  }
    }
    }
    
}
