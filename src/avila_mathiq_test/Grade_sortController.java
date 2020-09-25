/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class Grade_sortController implements Initializable {
    private ObservableList<beginner_table> data1;
     private ObservableList<intermediate_table> data2;
      private ObservableList<expert_table> data3;
 Connection con=null;
    @FXML
    private Text txt1;

    @FXML
    private TableView<beginner_table> tbeginner;

    @FXML
    private TableColumn<beginner_table, String> bname;

    @FXML
    private TableColumn<beginner_table, String>biq;

    @FXML
    private Text btext;

    @FXML
    private TableView<intermediate_table> tintermediate;

    @FXML
    private TableColumn<intermediate_table, String> iname;

    @FXML
    private TableColumn<intermediate_table, String> iiq;

    @FXML
    private TableView<expert_table> texpert;

    @FXML
    private TableColumn<expert_table, String> ename;

    @FXML
    private TableColumn<expert_table, String> eiq;
    /**
     * Initializes the controller class.
     */
       private void refreshtable()  {
 
        
   try{
       
        data1=FXCollections.observableArrayList();
        ResultSet rs=con.createStatement().executeQuery("select name,grade from IQ_comparison11 ORDER BY grade DESC ");
        while (rs.next()){ 
 
            data1.add(new beginner_table(rs.getString("name"),rs.getString("grade")));
         } }catch(SQLException se){
            System.out.println("Error connecting to database !");
        }
        bname.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        biq.setCellValueFactory(new PropertyValueFactory<>("IQ" ) );
             tbeginner.setItems(null);
     tbeginner.setItems(data1);
      //  college.getItems().addAll(data);
           
   
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DB_manager db=new DB_manager();
      
                try {
                    con=db.connect();
                } catch (ClassNotFoundException ex) {
                    System.out.println("database not connected beginer");     }
    refreshtable();
     refreshtable1(); refreshtable2();
        // TODO
    }    
    
    
    
    
    
     private void refreshtable1()  {
 
        
   try{
       
        data2=FXCollections.observableArrayList();
        ResultSet rs=con.createStatement().executeQuery("select name,grade  from IQ_comparisoninterme1 ORDER BY grade DESC ");
        while (rs.next()){ 
//            System.out.println("int "+rs.getInt("time_of_executional"));
            data2.add(new intermediate_table(rs.getString("name"),rs.getString("grade")));
         } }catch(SQLException se){
            System.out.println("Error connecting to database !");
        }
        iname.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        iiq.setCellValueFactory(new PropertyValueFactory<>("IQ" ) );
             tintermediate.setItems(null);
     tintermediate.setItems(data2);
      //  college.getItems().addAll(data);
           
   
   }
     
    private void refreshtable2()  {
 
        
   try{
       
        data3=FXCollections.observableArrayList();
        ResultSet rs=con.createStatement().executeQuery("select name,grade from IQ_comparisonexpert1 ORDER BY grade DESC ");
        while (rs.next()){ 
//            System.out.println("IQQQQQ "+rs.getString("grade"));
            data3.add(new expert_table(rs.getString("name"),rs.getString("grade")));
         } }catch(SQLException se){
            System.out.println("Error connecting to database !");
        }
        ename.setCellValueFactory(new PropertyValueFactory<>("NAME"));
        eiq.setCellValueFactory(new PropertyValueFactory<>("IQ" ) );
             texpert.setItems(null);
     texpert.setItems(data3);
      //  college.getItems().addAll(data);
           
   
   }  
     
}
