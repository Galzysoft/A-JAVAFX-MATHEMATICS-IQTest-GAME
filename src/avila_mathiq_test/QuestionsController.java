/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class QuestionsController implements Initializable {
  

   
  @FXML
    private HBox answerbase;
    @FXML
    private Text question;

     
    @FXML
    private JFXButton prev;

    @FXML
    private ToggleGroup q2group;
    /**
     * Initializes the controller class.
     */
            ArrayList<String> shuffler;
           
    int i;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   for(i=0;i<7;i++){
//        int index=rand.nextInt(shuffler.size());
//       
JFXRadioButton radio=new JFXRadioButton("b");
        ToggleGroup groupp=new ToggleGroup();
         
        radio.setToggleGroup(groupp);
        answerbase.getChildren().add(i,radio);
        }
         
    }    
    public   void answersoptions(String a1,String a2, String a3,String a4,String a5,String a6){
 shuffler=new ArrayList<>();
        shuffler.add(a6);  shuffler.add(a1);  shuffler.add(a2);  shuffler.add(a3);  shuffler.add(a4);  shuffler.add(a5);
             Random rand = null;
        
        
        
    }
    
    public   void questions(String a1 ){
          a1="12";
        
        question.setText(a1);
        
        
    }
}
