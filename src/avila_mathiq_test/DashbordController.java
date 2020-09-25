/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.transitions.hamburger.HamburgerNextArrowBasicTransition;
 
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class DashbordController implements Initializable {RotateTransition transision,transision2,transision3;Connection con;   FXMLLoader loader=new FXMLLoader(getClass().getResource("main_dash.fxml"));
    
    @FXML
    private VBox beg;
    private HBox basepanee;
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
    private VBox odi;

    @FXML
    private Button e;
    @FXML
    private BorderPane penaa;
String usesr; 
    @FXML
    private JFXHamburger viewdrawer;
  private double xoffset=0;
    private double yoffset=0;
   
    @FXML
    private JFXDrawer drawer;
private void dashboard(){
 try {
                     
            FXMLLoader loader=new FXMLLoader(getClass().getResource("main_dash.fxml"));
              Parent root =  loader.load();
           
            Main_dashController dash = (Main_dashController)loader.getController();
               dash.username1(usesr); 
                 
        
                    
            penaa.setCenter(root);
        } catch (IOException ex) {
                     } }
private void exit(){
 System.exit(0);
}
   
 
    private void logout() throws IOException {Stage stage;
    Stage stage1 = (Stage) penaa.getScene().getWindow();
                Parent root;
            //if(event.getSource()==btn){
                    stage = new Stage();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
             
              root =  loader.load();
                
              
              
                    stage.setScene(new Scene(root));
                     stage.getIcons().add(new Image(Avila_MathIQ_Test.class.getResourceAsStream("FullSizeRender.jpg")));
       
                    stage.initModality(Modality.NONE);
                    stage.initOwner(penaa.getScene().getWindow());
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.UNDECORATED);
                    //
                    
                    
                    
                   // stage.centerOnScreen();
                    //scene.getStylesheets().add(STUDENT_PROJECT_MANAGEMENTSYS.class.getResource("sign_up.css").toExternalForm());
                        stage1.close();
         
                         root.setOnMousePressed(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            xoffset=event.getSceneX();
            yoffset= event.getSceneY();
        }
    });           root.setOnMouseDragged(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            stage.setX(event.getScreenX()-xoffset);
            stage.setY(event.getScreenY()-yoffset);
        }
    });
                        
                        
                        
                    stage.showAndWait();
                    
                  
                //  stage.showAndWait();
                    
                 }
private void beginner(){
 try {
                     
            FXMLLoader loader=new FXMLLoader(getClass().getResource("beginner.fxml"));
              Parent root =  loader.load();
           
            BeginnerController dash = (BeginnerController)loader.getController();
               dash.username(usesr); 
                 
        
                    
            penaa.setCenter(root);
        } catch (IOException ex) {
                     } }
    private void iq(){
 try {
                     
            FXMLLoader loader=new FXMLLoader(getClass().getResource("grade_sort.fxml"));
              Parent root =  loader.load();
           
           
                 
        
                    
            penaa.setCenter(root);
        } catch (IOException ex) {
                     } }





 private void intermediakhte(){
 try {
                     
            FXMLLoader loader=new FXMLLoader(getClass().getResource("intermediate.fxml"));
              Parent root =  loader.load();
           
            IntermediateController dash = (IntermediateController)loader.getController();
               dash.username(usesr); 
                 
        
                    
            penaa.setCenter(root);
        } catch (IOException ex) {
                     } 
}
  private void about(){
 try {
        Parent root = FXMLLoader.load(getClass().getResource("about.fxml"));
        Dialog dd=new Dialog();
        
      
           
 
        dd.getDialogPane().setContent(root);
             
 

        dd.initStyle(StageStyle.UNDECORATED);
        dd.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage()); }
        
}
 
 private void expert(){
 try {
                     
            FXMLLoader loader=new FXMLLoader(getClass().getResource("expert.fxml"));
              Parent root =  loader.load();
           
            ExpertController dash = (ExpertController)loader.getController();
               dash.username(usesr); 
                 
        
                    
            penaa.setCenter(root);
        } catch (IOException ex) {
                     } 
}
 
  @FXML
     private void drawer1(MouseEvent event){
          HamburgerNextArrowBasicTransition back=new HamburgerNextArrowBasicTransition(viewdrawer);
        back.setRate(-1);
     try {
         VBox box=FXMLLoader.load(getClass().getResource("drawer.fxml"));
          
        drawer.setSidePane(box); 
        
             if(drawer.isOpened()){drawer.close();} 
            
            
       // TODO
    } catch (IOException ex) {
       System.out.println("error awuf "+ex.getMessage());
    }}
           
@FXML
    private void beginner(MouseEvent event) throws IOException {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("beginner.fxml"));
        Dialog dd=new Dialog();
        
      
           
 
        dd.getDialogPane().setContent(root);
             
 

        dd.initStyle(StageStyle.UNDECORATED);
        dd.show();
    } catch (IOException ex) {
        System.out.println(ex.getMessage()); }
        
          /*       Stage stage;
                Parent root;
            //if(event.getSource()==btn){
                    stage = new Stage();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("fxdialog.fxml"));
             
              root =  loader.load();
              
               
              
                    stage.setScene(new Scene(root));
                    stage.initModality(Modality.NONE);
                    stage.initOwner(motherpane.getScene().getWindow());
                    stage.setResizable(false);
                    stage.initStyle(StageStyle.UNDECORATED);
                    //
                    
                    
                    
                    stage.centerOnScreen();
                    //scene.getStylesheets().add(STUDENT_PROJECT_MANAGEMENTSYS.class.getResource("sign_up.css").toExternalForm());
                    
                    
                   // btn.getScene().getWindow().hide();
                    

                    stage.show();
             //  
    
    
    
        
    
    
    
    
    
    */ 
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
    
         
      new SplashScreen().start();
             try {   
                Parent root;
                          
                              root = loader.load();
                          
                penaa.setCenter(root);
                    // TODO
  } catch (IOException ex) {
                          System.out.println("error just occure"+ex.getMessage());    // TO     
  }
        
//jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj
      try {
      VBox box1=FXMLLoader.load(getClass().getResource("drawer.fxml"));
       drawer.setSidePane(box1); 
          for (Node node : box1.getChildren()) {
              if (node.getAccessibleText()!=null) {
                  if (node.getAccessibleText()=="user") {
                     node.getAccessibleText().replaceAll("Logged User  : ThankGod Johnbosco", usesr);
                  }
                          node.addEventHandler(MouseEvent.MOUSE_CLICKED,(e)->{
                      switch (node.getAccessibleText()){
                  case "home":
                       dashboard();
                       break;
                        case "expert":
                       expert();
                       break;
                      case "about":
                       about();
                       break;
                        case "exit":
                            exit();
                       break;
                        
                       case "intermediate":
                       intermediakhte();
                       break;
                        
                       case "IQ":
                       iq();
                       break;
                      
                       case "logout":
                      {
                          try {
                              logout();
                          } catch (IOException ex) {
                              Logger.getLogger(DashbordController.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      }
                       break;
                       case "beginner":
                           beginner(); 
                      
            
                  }
                  });
                  
              }
              
          }
       // drawer.open();
        //drawer.open();
      
        HamburgerNextArrowBasicTransition back=new HamburgerNextArrowBasicTransition(viewdrawer);
        back.setRate(-1);
        viewdrawer.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            back.setRate(back.getRate()*-1);back.play();
            
            if(drawer.isOpened()){drawer.close();}else{
              
                
                
                
                
                
                drawer.setVisible(true);
                
                
                drawer.open();drawer.toFront();}
            
            
        });// TODO
    } catch (IOException ex) {
      Logger.getLogger(DashbordController.class.getName()).log(Level.SEVERE, null, ex);
   }  // TODO
    }    public void usersss  (String sss){
    
    usesr=sss;
            System.out.println("recieved"+usesr);    
    
    }
    
    
    
    
         class SplashScreen extends Thread{
          @Override
          public void run(){
              try {
                  Thread.sleep(500);
                  Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                 Main_dashController bbn= (Main_dashController)loader.getController();
        
                         bbn.username1(usesr);
         System.out.println("i just passed main   ="+usesr);
  
                     
    
                      
                      
                      
                      }
                  });
                  
              } catch (InterruptedException ex) {
                  }
    }
    }
    
    
}
