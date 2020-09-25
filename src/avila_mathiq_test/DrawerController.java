/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXRippler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class DrawerController implements Initializable {
  @FXML
    private Button big;
   @FXML
    private Button ab1;
 @FXML
    private Button big1;

    @FXML
    private Button inter;

    @FXML
    private Button ex;

    @FXML
    private Button log;
     @FXML
    private Button exit;

    @FXML
    private Button ab;
   @FXML
    private VBox basepane;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        big.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
     inter.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
     ex.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
     exit.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
     ab.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
     log.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
     big1.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
   ab1.getStylesheets().add(Avila_MathIQ_Test.class.getResource("drawer.css").toExternalForm());
   
    }    
    
}
