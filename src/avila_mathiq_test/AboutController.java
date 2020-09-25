/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class AboutController implements Initializable {
 @FXML
    private AnchorPane root;
@FXML
    private Hyperlink link;

    @FXML
    private Text txt1;

    @FXML
    private ImageView imm;

    @FXML
    private Pane logo;
    /**
     * Initializes the controller class.
     */
     @FXML
     private void exitt(ActionEvent event)  {
         root     .getScene().getWindow().hide();
     } @FXML
     private void web(ActionEvent event)  {
      
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
    
}
