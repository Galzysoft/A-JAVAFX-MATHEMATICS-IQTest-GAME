/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
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
public class BeginnerController implements Initializable {

    /**
     * Initializes the controller class.
     */
    ArrayList<String>answershuffle;
@FXML
    private JFXButton next;
  
private Timer t;
    private int counte=160;
    @FXML
    private JFXRadioButton o1;
@FXML
    private Label timer;
    @FXML
    private JFXRadioButton o2;

    @FXML
    private Text question;
 @FXML
    private Text congrats;
 @FXML
    private Text congrats1;
  @FXML
    private Text congrats11;
 int score;
    @FXML
    private JFXRadioButton o3;
@FXML
    private JFXRadioButton o31;
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
int count=0;int answer ;
String name;
int [] arrray;

@FXML
     private void example( Event event) {
//          System.out.println("e clickk   bb");
//         if (counte<160) {
//         System.out.println("e bb");
//         counte=160;
//         System.out.println("e bb");
//        t.cancel();
//        timer.setText("160 sec");
        
//    }
     }
     
     
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
  
        String sql=("select * from IQ_comparison11 where username='"+userr+"'" );   
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
         
        String sql="update IQ_comparison11 set username =?,grade =?,time_of_executional = ?,name=? where username =? ";
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
 
        String sql="insert into IQ_comparison11 (username,grade,time_of_executional,name) VALUES (?,?,?,?) ";  
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
         counte=160; 
         timer.setText("160");
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
     private void gotto( Event event) throws SQLException{
        selectt_lastscore_name();
     }
     int got;
     
@FXML
     private void question(ActionEvent event){
         
         if(o1.isSelected()||o2.isSelected()||o3.isSelected()||o31.isSelected()){ 
          if (numberofquestions>20) {
             
             System.out.println("reached limit nice game you answered = "+numberofquestions);
    } else {
    
         JFXRadioButton selectedRadioButton = (JFXRadioButton) answergroup.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();
        realans=Integer.parseInt(toogleGroupValue);
      
         if (got==realans) {System.out.println("correctanswer"+got);
         numberofquestions+=1; 
         System.out.println(" number of correct answers "+numberofquestions);
        
//         questionshuff();
    }else{System.out.println("falseanswer"+realans );}
         selectedRadioButton.setSelected(false);
          
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
       
		
  
      int a11=Integer. parseInt(questions.get(name).trim());
           int b11=    Integer. parseInt(answers.get(name).trim());
           int answer=a11*b11;
          question.setText(a11+" x "+b11);
          //         here we declare a count 
         int countt=0;
      
              
//               we get elements from the array list and convert it to integer
  got =answer;
int ext =got+3;
// let declare a destination arrayto store the  exr  3 numbers from the source bove
ArrayList<Integer> listoofdereven=new ArrayList<>();

//let get values within the range of 20 to 23
//for (int i = got; i <= ext; i++) {
////            let addthose values toa seprate arraylist
//listoofdereven.add(i);
// 
//        }
int aa=got+10;int aaa=got+10;int aaaa=got+20;int aaaaa=got+30;
listoofdereven.add(got);listoofdereven.add(aaa);listoofdereven.add(aaaa);listoofdereven.add(aaaaa);

     //     let declare three variables to store out random output
   int a=0;    int b=0;    int c=0; int d=0;
//using a foor loop
 
    int size = listoofdereven.size();
        
        

        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 0; i <size; i++) {
            list.add(i);
              }
  
        Random rand = new Random();
            while(list.size() > 0) {
                countt+=1;
            int index = rand.nextInt(list.size());
            switch(countt){
            case 1: 
                a= listoofdereven.get(list.remove(index));
                        o1.setText(""+a);
                
              
                
            break;
             case 2:
                b= listoofdereven.get(list.remove(index));
                        o2.setText(""+b);
               
            break;
            case 3:
                    c= listoofdereven.get(list.remove(index));
                  
                o3.setText(""+c);
                   
            break;
            case 4:
                d= listoofdereven.get(list.remove(index));
                       o31.setText(""+d);
                
            }
//                  System.out.println("Selected: "+"count"+countt+"  answer : "+listoofdereven.get(list.remove(index)));
      
       
       }   
  }else{    
   int time_offinish=160-counte;
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
        counte=160;
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
       questions.add("4");
     questions.add("4");
     questions.add("5");
  questions.add("7");
        questions.add("9");
            questions.add("9");
                questions.add("11");
                    questions.add("11");
                      questions.add("12");
                       questions.add("12");
     questions.add("9");
     questions.add("9");
  questions.add("13");
        questions.add("9");
            questions.add("11");
                questions.add("13");
                    questions.add("14");
                      questions.add("15");
                        questions.add("15");
                      questions.add("16");
//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
     questions.add("29");
    questions.add("26");
     questions.add("25");
     questions.add("19");
  questions.add("19");
        questions.add("18");
            questions.add("18");
                questions.add("17");
                    questions.add("17");
                      questions.add("15");
                       questions.add("15");
     questions.add("15");
     questions.add("33");
  questions.add("30");
        questions.add("20");
            questions.add("19");
                questions.add("18");
                    questions.add("16");
                      questions.add("14");
                        questions.add("18");
                      questions.add("12");
///////////////////////////////////////////////////////////////
          questions.add("7");
    questions.add("7");
     questions.add("15");
     questions.add(" 9" );
  questions.add("9");
        questions.add("9");
            questions.add("7");
                questions.add("5");
                    questions.add("8");
                      questions.add("8");
                       questions.add("8");
     questions.add("8");
     questions.add("10");
  questions.add("10");
        questions.add("11");
            questions.add("10");
                questions.add("10");
                    questions.add("10");
                      questions.add("16");
                        questions.add("27");
                      questions.add("26");
//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
     questions.add("25");
    questions.add("24");
     questions.add("23");
     questions.add("22");
  questions.add("21");
        questions.add("20");
            questions.add("19");
                questions.add("18");
                    questions.add("17");
                      questions.add("16");
                       questions.add("15");
     questions.add("14");
     questions.add("13");
  questions.add("12");
        questions.add("11");
            questions.add("10");
                questions.add("9");
                    questions.add("8");
                      questions.add(" 7");
                        questions.add("6");
                      questions.add(" 5");

//                    mmmmmmmmmmmmmm
    questions.add("4");
     questions.add("3");
     questions.add("2");
  questions.add("1");
        questions.add("0");
            questions.add("19");
                questions.add("18");
                    questions.add("17");
                      questions.add("16");
                       questions.add("15");
     questions.add("14");
     questions.add("13");
  questions.add("12");
        questions.add("11");
            questions.add("10");
                questions.add("9");
                    questions.add("6");
                    
                     
        
            }
   private void answers(){
   answers= new ArrayList<>();
   
          answers.add("9");
     answers.add("11");
     answers.add("13");
  answers.add("12");
        answers.add("12");
            answers.add("14");
                answers.add("10");
                    answers.add("12");
                      answers.add("13");
                       answers.add("15");
     answers.add("16");
     answers.add("18");
  answers.add("9");
        answers.add("15");
            answers.add("13");
                answers.add("6");
                    answers.add("6 ");
                      answers.add("10 ");
                        answers.add("3 ");
                      answers.add("4 ");
//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
     answers.add("29 ");
    answers.add("25 ");
     answers.add("21 ");
     answers.add("21 ");
  answers.add("19 ");
        answers.add("18 ");
            answers.add("17 ");
                answers.add("17 ");
                    answers.add("15 ");
                      answers.add("13 ");
                       answers.add("19 ");
     answers.add("30 ");
     answers.add("11 ");
  answers.add("9 ");
        answers.add("29 ");
            answers.add("5 ");
                answers.add("5 ");
                    answers.add("6  ");
                      answers.add("7  ");
                        answers.add("9 ");
                      answers.add("19 ");
///////////////////////////////////////////////////////////////
          answers.add("19 ");
    answers.add("15 ");
     answers.add("16 ");
     answers.add(" 13" );
  answers.add("17 ");
        answers.add("18");
            answers.add("16");
                answers.add("19");
                    answers.add("18");
                      answers.add("25");
                       answers.add("28");
     answers.add("29");
     answers.add("11");
      
  answers.add("15");
        answers.add("3");
            answers.add("18");
                answers.add("26 ");
                    answers.add("29");
                      answers.add("16");
                        answers.add("30");
                      answers.add("30");
//nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn
     answers.add("30");
    answers.add("30");
     answers.add("30");
     answers.add("30");
  answers.add("30");
        answers.add("30");
            answers.add("30");
                answers.add("30");
                    answers.add("30");
                      answers.add("30");
                       answers.add("30  ");
     answers.add("30 ");
     answers.add("30  ");
  answers.add("30 ");
        answers.add("30 ");
            answers.add("30 ");
                answers.add("30 ");
                    answers.add("30 ");
                      answers.add("30  ");
                        answers.add("30 ");
                      answers.add("30 ");

//                    mmmmmmmmmmmmmm
    answers.add("30 ");
     answers.add("30");
     answers.add("30 ");
  answers.add("30 ");
        answers.add("30");
            answers.add("20");
                answers.add("20");
                    answers.add("20");
                      answers.add("20");
                       answers.add("20");
     answers.add("20");
     answers.add("20");
  answers.add("20");
        answers.add("20");
            answers.add("120");
                answers.add("20");
                    answers.add("20");
                    
   
   
   
   
    
       
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
                         
                     
                         int time_offinish=160-counte;
   String tt=""+time_offinish;
                   int percentage=numberofquestions*100/20;
  congrats.setText(" congrats!!! "+name+" you answered "+numberofquestions+" correctly out of 20 question in "+tt+"% your IQ_speed is "+percentage+"% ");
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
        counte=160;
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
