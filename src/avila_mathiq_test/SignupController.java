/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class SignupController implements Initializable {
    private double xoffset=0;
       private double yoffset=0;
      @FXML
    private ImageView p;

    @FXML
    private VBox toastt;

    @FXML
    private ImageView p1;

    @FXML
    private JFXPasswordField password;

    @FXML
    private ImageView u11;

    @FXML
    private ImageView u;

    @FXML
    private JFXPasswordField password1;

     @FXML
    private ImageView u1;

    @FXML
    private JFXTextField username11;

    @FXML
    private JFXTextField username;

       @FXML
     private void minimize(ActionEvent event){
        
            ((Stage)  password.getScene().getWindow()).setIconified(true);
       
          
     
     } 
    @FXML
    private void exit(ActionEvent event) throws IOException {
               
            TranslateTransition transision=new TranslateTransition();
        transision.setDuration(Duration.millis(400));
transision.setNode(toastt);
transision.setByX(-600);
transision.setCycleCount(1);
transision.setAutoReverse(false);
transision.play();
transision.setOnFinished((event1) -> {
 
            try {
                Stage stage1 = (Stage) password.getScene().getWindow();
                
                Stage stage;
                Parent root;
                //if(event.getSource()==btn){
                stage = new Stage();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                
                root =  loader.load();
                
                
                
                
                
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
//scene.getStylesheets().add(STUDENT_PROJECT_MANAGEMENTSYS.class.getResource("sign_up.css").toExternalForm());
            } catch (IOException ex) {
                Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
            }
});
     }
 @FXML
     private void signup(ActionEvent event) throws FileNotFoundException, SQLException{
          if(username.getText().length()==0||password.getText().length()==0||password1.getText().length()==0||username11.getText().length()==0  )
             {
                   if(username.getText().length()==0){u.setVisible(true);}
                   else{u.setVisible(false);}
                    if (password.getText().length()==0){p.setVisible(true);}
                   else{p.setVisible(false);}
                    if (password1.getText().length()==0){p1.setVisible(true);}
                   else{p1.setVisible(false);}
                       if (username11.getText().length()==0){u11.setVisible(true);}
                   else{u11.setVisible(false);}
                  
                                     
                 JFXSnackbar bar=new JFXSnackbar(toastt);
//                bar.getStyle("-fx-background-color:green;");
bar.getStylesheets().add(Avila_MathIQ_Test.class.getResource("fail.css").toExternalForm());
        
                bar.show("One Or More Fields Are Empty", 2000);
                
                
//              Alert loginerror1 = new Alert(Alert.AlertType.ERROR);
//                loginerror1.setTitle("reg error");
//                loginerror1.setHeaderText(null);
//                loginerror1.setContentText( "One Or More Fields Are Empty");
//                loginerror1.initModality(Modality.APPLICATION_MODAL);
//                loginerror1.showAndWait();
//        
              }
          else{
               if(username.getText().length()==0){u.setVisible(true);}
                   else{u.setVisible(false);}
                    if (password.getText().length()==0){p.setVisible(true);}
                   else{p.setVisible(false);}
                    if (password1.getText().length()==0){p1.setVisible(true);}
                   else{p1.setVisible(false);}
                    if (username11.getText().length()==0){u11.setVisible(true);}
                   else{u11.setVisible(false);}
              if(password.getText().equalsIgnoreCase(password1.getText()) ){
                    
       
        
     
        String sql="INSERT INTO LOGIN2 (username,password,fullname) VALUES (?,?,?) ";
   
          try { 
        PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1, username.getText());
          pst.setString(2, password.getText());
        pst.setString(3, username11.getText());
               pst.executeUpdate();
 JFXSnackbar bar=new JFXSnackbar(toastt);
//                bar.getStyle("-fx-background-color:green;");
bar.getStylesheets().add(Avila_MathIQ_Test.class.getResource("good.css").toExternalForm());
        
                bar.show("You just sucessfully signed up", 2000);
   
                 
         
  
  
    } catch (SQLException ex) {
  JFXSnackbar bar=new JFXSnackbar(toastt);
//                bar.getStyle("-fx-background-color:green;");
bar.getStylesheets().add(Avila_MathIQ_Test.class.getResource("fail.css").toExternalForm());
        
                bar.show("user already existed", 2000);
   
//                Alert loginerror1 = new Alert(Alert.AlertType.ERROR);
//                loginerror1.setTitle("Signup Error");
//                loginerror1.setHeaderText(null);
//                loginerror1.setContentText( "unable to sign up");
//                loginerror1.initModality(Modality.APPLICATION_MODAL);
//                loginerror1.showAndWait();
             } 
          } else{ 
                   JFXSnackbar bar=new JFXSnackbar(toastt);
//                bar.getStyle("-fx-background-color:green;");
bar.getStylesheets().add(Avila_MathIQ_Test.class.getResource("fail.css").toExternalForm());
        
                bar.show("mismatched password and username in the text fields", 2000);
   
                  
                  
//                  Alert loginerror1 = new Alert(Alert.AlertType.ERROR);
//                loginerror1.setTitle("Mismatched password error");
//                loginerror1.setHeaderText(null);
//                loginerror1.setContentText("Please use the same password in the password fields");
//                loginerror1.initModality(Modality.APPLICATION_MODAL);
//                loginerror1.showAndWait();
              }}
              }
//   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username.setFocusTraversable(false); password.setFocusTraversable(false);
            password1.setFocusTraversable(false);
        username11.setFocusTraversable(false);  
       
         DB_manager db=new DB_manager();
        try {
           con = db.connect();
            System.out.println("DB created");
        } catch (ClassNotFoundException ex) {
            System.out.println("DB not created");
        }
        // TODO
    }    
     Connection con=null;
}
