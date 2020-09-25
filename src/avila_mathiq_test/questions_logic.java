/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

/**
 *
 * @author ONYEKA
 */
public class questions_logic {
questions_logic(){
questions();
    answers();
}
    
    
      ArrayList<String> questions;
      ArrayList <String> answers;
   private void questions(){
  questions=new ArrayList<>();
     
    questions.add("1) 4 x 9 = ");
     questions.add("(2) 4 x 11 = 44");
     questions.add("3) 5 x 13 = 65");
  questions.add(" 4) 7 x 12 = 84");
        questions.add("5) 9 x 12 = 108");
            questions.add("6) 9 x 14 = 126");
                questions.add("7) 11 x 10 = 110");
                    questions.add("8) 11 x 12 = 132");
                      questions.add("9) 12 x 13 = 156");
                       questions.add("10) 12 x 15 = 180");
     questions.add("11) 9 x 16 = 114");
     questions.add("12) 9 x 18 = 162");
  questions.add("13) 13 x 9 = 117");
        questions.add("14) 9 x 15 = 135");
            questions.add("15) 11 x 13 = 143");
                questions.add("16) 13 x 6 = 78");
                    questions.add("17) 14 x 6 = 84");
                      questions.add("18) 15 x 10 = 150 ");
                        questions.add("19) 15 x 3 = 45");
                      questions.add("20) 16 x 4 = 64");

                 
        
            }
   private void answers(){
   answers= new ArrayList<>();
   answers.add("36");
      answers.add("44");
       answers.add("65");
      answers.add("84");
       answers.add("108");
      answers.add("126");
      answers.add("110");
      answers.add("132");
       answers.add("156");
      answers.add("180");
       answers.add("114");
      answers.add("162");
    answers.add("117");
      answers.add("135");
       answers.add("143");
      answers.add("78");
       answers.add("84");
      answers.add("150");
      answers.add("45");
      answers.add("64");
        
 
 

   
   
   }
   private void create_tab(){
       for (int i=0;i<19;i++)
   {   Tab vt=new Tab("q"+i);
   vt.setId("q"+i);
  
    try {  
              FXMLLoader loader=new FXMLLoader(getClass().getResource("questions.fxml"));
              Parent root =  loader.load();
                
         
           vt.setContent(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }
    
   
   }
   }
   

}
