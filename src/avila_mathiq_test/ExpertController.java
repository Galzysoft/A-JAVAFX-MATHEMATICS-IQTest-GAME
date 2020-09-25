/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ONYEKA
 */
public class ExpertController implements Initializable {
  ArrayList<String>answershuffle;
@FXML
    private JFXButton next;
   @FXML
    private JFXTextField answert;
private Timer t;
    private int counte=170;
    
@FXML
    private Label timer;
     
    @FXML
    private Text question;
 @FXML
    private Text congrats;
 @FXML
    private Text congrats1;
  @FXML
    private Text congrats11;
 int score;
    
int countex=0;
    @FXML
    private JFXTabPane tabpaneeeee;

    @FXML
    private JFXButton prev;

    @FXML
    private HBox answerbase;

    @FXML
    private VBox v2;
    int questioncount=0;
 @FXML
    private Tab tq;
  int fail;
 @FXML
    private Tab tq1;
    @FXML
    private Tab home;
int numberofquestions=0;
int realans;

 Statement stmt=null;
 int previo;
    @FXML
    private ToggleGroup answergroup;
int count=0;
int answer ;
String name;
int [] arrray;

private void selectt_lastscore_name()    {
            try {   
      DB_manager db=new DB_manager();
      
                try {
                    con=db.connect();
                } catch (ClassNotFoundException ex) {
                    System.out.println("database not connected beginer");     }
       insertfirst_lastscore(); System.out.println("no record first but inserted");

       stmt=null;
     stmt = con.createStatement();
  
        String sql=("select * from IQ_comparisonexpert1 where username='"+userr+"'" );   
       System.out.println("sqllllll");
        ResultSet rst=stmt.executeQuery(sql);
                         System.out.println("aa");
                         
        while(rst.next()){ 
         
         
            
                     previo=Integer.parseInt(rst.getString("grade"));
                   
                     score=Integer.parseInt(rst.getString("time_of_executional"));
                  
               System.out.println("last record "+previo);      
             }
            
//        nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
  String sqll=("select * from LOGIN2 where username ='"+userr+"'" );   
       System.out.println("sqllllll");
        ResultSet rsst=stmt.executeQuery(sqll);
                         System.out.println("aa");
        while(rsst.next()){ 
         
         
            
                     name= rsst.getString("fullname");
               System.out.println("name "+name);      
             }  

            
             } catch (SQLException ex) {
            Logger.getLogger(BeginnerController.class.getName()).log(Level.SEVERE, null, ex);
}
            
 
  
        } 
 
     private void update_lastscore()  {
         
        String sql="update IQ_comparisonexpert1 set username =?,grade =?,time_of_executional = ?,name=? where username =? ";
    int time_offinish=160-counte;
                try {   
        PreparedStatement pst=con.prepareStatement(sql);
        int percentage=numberofquestions*100/20;
         pst.setString(1, userr);
          pst.setString(2, ""+percentage);
        pst.setString(3, ""+time_offinish);
         pst.setString(4, name);
         pst.setString(5, userr);
        
            pst.executeUpdate();
                    System.out.println("score updated");
  
     }  catch (SQLException ex) {
       System.out.println("score not updated"+ex.getMessage());  }
     }
 private void insertfirst_lastscore()  {
 
        String sql="insert into IQ_comparisonexpert1 (username,grade,time_of_executional,name) VALUES (?,?,?,?) ";  
   int insta =0;
                try {   
        PreparedStatement pst=con.prepareStatement(sql);
         pst.setString(1, userr);
          pst.setString(2, ""+insta);
        pst.setString(3, ""+insta);
        pst.setString(4, ""+insta);
       
            pst.executeUpdate();
            System.out.println("inserted ");  
  
     }  catch (SQLException ex) {
                    System.out.println("inserted beefore");   }
     }


@FXML
     private void getstart(ActionEvent event)  {
    selectt_lastscore_name();
    
        tabpaneeeee.getSelectionModel().select(home);
        numberofquestions=0;
        
        t.cancel();
        count=0;
         counte=170;  timer.setText("170");   
            } 
 @FXML
     private void getquestions(ActionEvent event)  {
        
        setTimer();
          next.setDisable(false);
           arrray = RandomizeArray(0, 100);
        tabpaneeeee.getSelectionModel().select(tq);
             questionshuff();
            } 
     @FXML
     private void example( Event event) throws SQLException{
//         counte=140;
//        t.cancel();
//        timer.setText("140 sec");
     }
     
     
     
@FXML
     private void gotto( Event event) throws SQLException{
        selectt_lastscore_name();
     }
     int got;
     
@FXML
     private void question(ActionEvent event){
   
         
         System.out.println("the answer to that question "+got);
         
         
//         nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
                
         if(!(answert.getText().isEmpty())){ 
          if (questioncount>20) {
            
             System.out.println("reached limit nice game you answered = "+numberofquestions);
             
    } else {
    
         
        String toogleGroupValue = answert.getText();
        realans=Integer.parseInt(toogleGroupValue);
      
         if (got==realans) {System.out.println("correctanswer"+got);
         numberofquestions+=1; 
         System.out.println(" number of correct answers "+numberofquestions);
        
//         questionshuff();
    }else{System.out.println("falseanswer"+realans );}
         answert.setText("");
          
          questionshuff();
//String toogleGroupValue = selectedRadioButton.getText();
     }
  
         }else{System.out.println("falseanswer no answer");
              
         questionshuff();}
        
           
           }
    
  private  void questionshuff(){
 
     
  
      if (!(countex>20)) {
  int connt= countex+=1 ;
             int name = arrray[connt];
        
		
  
//        we add elementsto the array lists

      int a11=Integer. parseInt(questions.get(name).trim());
           int b11=    Integer. parseInt(answers.get(name).trim());
           int answer=a11*b11;
          question.setText(a11+" x "+b11);
          //         here we declare a count 
         int countt=0;
      
              
//               we get elements from the array list and convert it to integer
  got =answer;
      
  }else{    
 
   int time_offinish=170-counte;
   String tt=""+time_offinish;
                int percentage=numberofquestions*100/20;
  congrats.setText(" congrats!!! "+name+" you answered "+numberofquestions+" correctly out of 20 question in "+tt+"sec your IQ_speed is "+percentage+"% ");
          if (previo<percentage) {
          congrats1.setText(" Your last IQ_speed is "+previo+"% & you really improved ");
      
          }else if(previo>percentage){
           congrats1.setText(" Your last IQ_speed is "+previo+"% & you really need to improve ");
              }
       else if(previo==percentage){
           congrats1.setText(" Your last IQ_speed is "+previo+"% & you need more effort ");
             }
         
       if (score>time_offinish) {
          congrats11.setText(" You are fast this time your last time is "+score+" sec");
      
          }else if(score<time_offinish){
          congrats11.setText(" You Are slow this time Your last time is "+score+" sec");
          }
       else if(score==time_offinish){
          congrats11.setText(" You need more effort Your last time is "+score+" sec");
          } 
  tabpaneeeee.getSelectionModel().select(tq1);
           update_lastscore();
                       next.setDisable(true);
	countex=0;
        counte=170;
             t.cancel();
      } 
  
          
       
  }
         @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       answers();
questions();
//             System.out.println("username   = "+ data2.get(0).getUSER()); 
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
    
      
          public   int[] RandomizeArray(int a, int b){
                  int countex=0;
		Random rgen = new Random();  // Random number generator		
		int size = b-a+1;
		int[] array = new int[size];
 
		for(int i=0; i< size; i++){
			array[i] = a+i;
		}
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
//		for(int s: array)
			     
         return array;
	}
    
    
    
    
        ArrayList<String> questions;
      ArrayList <String> answers;
   private void questions(){
  questions=new ArrayList<>();
    
     questions.add("111   ");
    questions.add("112   ");
     questions.add("105   ");
     questions.add("118   ");
  questions.add(" 132   ");
        questions.add("101   ");
            questions.add("101   ");
                questions.add("101   ");
                    questions.add("101   ");
                      questions.add("101   ");
                       questions.add("110   ");
     questions.add("102   ");
     questions.add("102   ");
  questions.add("102   ");
        questions.add("102   ");
            questions.add("102  ");
                questions.add("102   ");
                    questions.add("102   ");
                      questions.add("102    ");
                         questions.add("102     ");
//                     bbbbbbbbbbbbbbbbbbbbbbbb
 questions.add("102    ");
     
     questions.add("103    ");
    questions.add("103   ");
     questions.add("103   ");
     questions.add("103   ");
  questions.add(" 103   ");
        questions.add("103   ");
            questions.add(" 103   ");
                questions.add("103   ");
                    questions.add("103   ");
                      questions.add("103    ");
                       questions.add("104   ");
     questions.add("104   ");
     questions.add("104   ");
  questions.add("104   ");
        questions.add("104   ");
            questions.add("104   ");
                questions.add("104   ");
                    questions.add("104  ");
                      questions.add("104    ");
//                        lllllllllllllllllllllllllllllll
questions.add("104   ");
    questions.add("104   ");
     questions.add("104  ");
     questions.add("101 ");
  questions.add(" 101  ");
        questions.add("101  ");
            questions.add("101  ");
                questions.add("101 ");
                    questions.add("100 ");
                      questions.add("102  ");
                       questions.add("145 ");
     questions.add("140 ");
     questions.add("125 ");
  questions.add("125 ");
        questions.add("111 ");
            questions.add("107 ");
                questions.add("107 ");
                    questions.add("107 ");
                      questions.add("107  ");
                         questions.add("107  ");
                     //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
     questions.add("107  ");
     
        questions.add("108 ");
     questions.add("108 ");
    
  questions.add(" 108 ");
        questions.add("108 ");
            questions.add("108 ");
                questions.add("108 ");
                    questions.add("108 ");
  
                       questions.add("108 ");
     questions.add("108 ");
     questions.add("109 ");
  questions.add("110 ");
        questions.add("110 ");
            questions.add("110 "); 
                questions.add("111 ");
                    questions.add("91 ");
                      questions.add("92  ");
//                   nnnnnnnnnnnnnnnnnnnnnnnnnnn
    questions.add("93 ");
     questions.add("94 ");
     questions.add("95 ");
  questions.add(" 96 ");
        questions.add("97 ");
            questions.add("98 ");
                questions.add("99 ");
                    questions.add("25 ");
                      questions.add("85 ");
                       questions.add("75 ");
     questions.add("65 ");
     questions.add("55 ");
  questions.add("45 ");
        questions.add("35 ");
            questions.add("35 "); 
                questions.add("45 ");
                    questions.add("55 ");
                      questions.add("65  ");
                        questions.add("75 ");
                      questions.add("15  ");
                      
   questions.add("16  ");
                        questions.add("56 ");
                      questions.add("77  ");

                 
        
            }
   private void answers(){
   answers= new ArrayList<>();
    
   
    answers.add(" 70 ");
    answers.add(" 80 ");
     answers.add(" 90 ");
     answers.add("  100 ");
  answers.add("   150 ");
        answers.add("  11 ");
            answers.add("  12 ");
                answers.add("  13 ");
                    answers.add("  14 ");
                      answers.add("  15 ");
                       answers.add("  15 ");
     answers.add("  10 ");
     answers.add("  20 ");
  answers.add("  30 ");
        answers.add("  40 ");
            answers.add("  50 ");
                answers.add("  60 ");
                    answers.add("  70  ");
                      answers.add("  80   ");
                         answers.add("  90   ");
//                     bbbbbbbbbbbbbbbbbbbbbbbb
 answers.add("  100  ");
     
     answers.add("  10  ");
    answers.add("  20 ");
     answers.add("  30 ");
     answers.add("  40 ");
  answers.add("  50 ");
        answers.add("  60 ");
            answers.add("   70 ");
                answers.add("  90 ");
                    answers.add("  90 ");
                      answers.add("  100  ");
                       answers.add("  10 ");
     answers.add("  20 ");
     answers.add("  30 ");
  answers.add("  40 ");
        answers.add("  50 ");
            answers.add("  60 ");
                answers.add("  70 ");
                    answers.add(" 80 ");
                      answers.add(" 90  ");
//                        lllllllllllllllllllllllllllllll
answers.add("  100 ");
    answers.add(" 105 ");
     answers.add(" 110 ");
     answers.add(" 99 ");
  answers.add("  18 ");
        answers.add(" 30 ");
            answers.add(" 59 ");
                answers.add(" 86 ");
                    answers.add("  25 ");
                      answers.add(" 25 ");
                       answers.add(" 145");
     answers.add(" 139");
     answers.add(" 125");
  answers.add(" 126");
        answers.add(" 111");
            answers.add(" 5");
                answers.add(" 6");
                    answers.add(" 7");
                      answers.add(" 8 ");
                         answers.add(" 9 ");
                     //nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
     answers.add(" 10 ");
     
        answers.add(" 2");
     answers.add(" 3");
    
  answers.add("  4");
        answers.add(" 5");
            answers.add(" 6");
                answers.add(" 7");
                    answers.add(" 9");
  
                       answers.add(" 10");
     answers.add(" 11");
     answers.add(" 11");
  answers.add(" 11");
        answers.add(" 13");
            answers.add(" 8"); 
                answers.add(" 9");
                    answers.add(" 91");
                      answers.add(" 92 ");
//                   nnnnnnnnnnnnnnnnnnnnnnnnnnn
    answers.add(" 93");
     answers.add(" 94");
     answers.add(" 95");
  answers.add("  96");
        answers.add(" 97");
            answers.add(" 98");
                answers.add(" 99");
                    answers.add(" 25");
                      answers.add(" 85");
                       answers.add(" 75");
     answers.add(" 65");
     answers.add(" 55");
  answers.add(" 45");
        answers.add(" 35");
            answers.add(" 30"); 
                answers.add(" 40");
                    answers.add(" 50");
                      answers.add(" 50 ");
                        answers.add(" 80");
                      answers.add("90 ");
                      
   answers.add("30 ");
                        answers.add("56");
                      answers.add("77 ");

         
   
   
   
   
   
   
   
   
   }

 public void setTimer() {
    t = new Timer();
    t.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() { 
   
            if(counte >0)
            {
                Platform.runLater(() -> timer.setText(counte+""));
                   counte--;
                
                         if(counte==0){ t.cancel();
                         int fail= 20-numberofquestions;
            int time_offinish=170-counte;
   String tt=""+time_offinish;
             System.out.println("reached limit nice game you answered = "+numberofquestions+"you failed = "+fail);
             int percentage=numberofquestions*100/20;
  congrats.setText(" congrats!!! "+name+" you answered "+numberofquestions+" correctly out of 20 question in "+tt+"sec your IQ_speed is "+percentage+"% ");
          if (previo<percentage) {
          congrats1.setText(" Your last IQ_speed is "+previo+"% & you really improved ");
      
          }else if(previo>percentage){
           congrats1.setText(" Your last IQ_speed is "+previo+"% & you really need to improve ");
              }
       else if(previo==percentage){
           congrats1.setText(" Your last IQ_speed is "+previo+"% & you need more effort ");
             }
         
       if (score>time_offinish) {
          congrats11.setText(" You are fast this time your last time is "+score+" sec");
      
          }else if(score<time_offinish){
          congrats11.setText(" You Are slow this time Your last time is "+score+" sec");
          }
       else if(score==time_offinish){
          congrats11.setText(" You need more effort Your last time is "+score+" sec");
          }             
                          tabpaneeeee.getSelectionModel().select(tq1);
                          next.setDisable(true);
	countex=0;
        counte=170;
             t.cancel();
      }
            } 
            else
                t.cancel();
        }
    }, 1000,1000);
}
 public void username(String user){
 userr=user;
     System.out.println("user beginner "+userr);
 }
 String userr;
}
