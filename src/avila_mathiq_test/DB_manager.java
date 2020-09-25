/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javax.swing.JOptionPane;

/**
 *
 * @author ONYEKA
 */
public class DB_manager {
//     
    Connection con=null; 
    DB_manager(){}
    public Connection connect() throws ClassNotFoundException{
  
         
    try {
        //   jdbc:mysql://localhost:3306/project_manager?zeroDateTimeBehavior=convertToNull [root on Default schema]
        
        Class.forName("org.h2.Driver");
             
       
        
             con = (Connection)DriverManager.getConnection("jdbc:h2:~/avila_math_iqDB","test","test");
  System.out.println("connected successfull"); 
 /* 
          con = (Connection)DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2243538", "sql2243538","vZ6%dN2*");
  System.out.println("connected successfull"); 
 
      */ 
        //   String url = "jdbc:mysql://localhost/project_manager";
      } catch (SQLException ex) {
     Alert loginerror1 = new Alert(Alert.AlertType.ERROR);
                loginerror1.setTitle("Connection Error");
                loginerror1.setHeaderText(null);
                loginerror1.setContentText(" Server Timed Out OR UnReachable");
                loginerror1.initModality(Modality.APPLICATION_MODAL);
                loginerror1.showAndWait();
    
      
      
      }
        return con;
    
    
    }
    public void create_tables() throws SQLException{
    Statement stmt=con.createStatement();
    stmt.execute("CREATE TABLE LOGIN2 "
                    + "(username VARCHAR(20),"
                    + "password VARCHAR(20),"
                    + "fullname VARCHAR(20),"
                     + "PRIMARY KEY(username))" 
                 ); 
    stmt.execute("CREATE TABLE IQ_comparison"
         + "(username VARCHAR(20)  NOT NULL ,"  
             + "grade VARCHAR(40) NOT NULL," 
                      + "time_of_executional VARCHAR(20)  NOT NULL,"
                    + "no_of_question VARCHAR(20)  NOT NULL," 
                      + "date VARCHAR(20)  NOT NULL,"  
            + "PRIMARY KEY(username))" 
); 
     stmt.execute("CREATE TABLE IQ_comparison1"
         + "(username VARCHAR(20)  NOT NULL ,"  
             + "grade VARCHAR(40) NOT NULL," 
                      + "time_of_executional VARCHAR(20)  NOT NULL,"
                      
            
);         
    }
   public void iq1() throws SQLException{
    Statement stmt=con.createStatement();
     
     stmt.execute("CREATE TABLE IQ_comparison11"
         + "(username VARCHAR(20)  NOT NULL ,"  
             + "grade INT NOT NULL," 
                      + "time_of_executional VARCHAR(20)  NOT NULL,"
              + "name VARCHAR(20)  NOT NULL ,"  
                        + "PRIMARY KEY(username))" 
            
);         
    }
   
   public void iqinterme1() throws SQLException{
    Statement stmt=con.createStatement();
     
     stmt.execute("CREATE TABLE IQ_comparisoninterme1"
         + "(username VARCHAR(20)  NOT NULL ,"  
             + "grade INT NOT NULL," 
                      + "time_of_executional VARCHAR(20)  NOT NULL,"
              + "name VARCHAR(20)  NOT NULL ,"  
                        + "PRIMARY KEY(username))" 
            
);         
    }
   
   public void iqexpert1() throws SQLException{
    Statement stmt=con.createStatement();
     
     stmt.execute("CREATE TABLE IQ_comparisonexpert1"
         + "(username VARCHAR(20)  NOT NULL ,"  
             + "grade INT NOT NULL," 
                      + "time_of_executional VARCHAR(20)  NOT NULL,"
              + "name VARCHAR(20)  NOT NULL ,"  
        
                        + "PRIMARY KEY(username))" 
            
);         
    }
   
  public void altereextpert() throws SQLException{
    Statement stmt=con.createStatement();
        stmt.execute( "ALTER TABLE IQ_comparisonexpert1 MODIFY grade INT NOT NULL;" 

       );         
    }
}  


// try {
//            // TODO code application logic here
//            Class.forName("org.h2.Driver");
//   Connection con= DriverManager.getConnection("jdbc:h2:~/bizappDB","test","test");
//            Statement stmt=con.createStatement();
//       /*    stmt.execute("CREATE TABLE LOGIN1 "
//                    + "(adminuser VARCHAR(20),"
//                    + "adminpass VARCHAR(20),"
//                    + "secuser VARCHAR(20),"
//                    + "secpass VARCHAR(20))" 
//                 ); 
//    stmt.execute("CREATE TABLE SALES11"
//         + "(ID VARCHAR(400)  NOT NULL ," 
//            
//             + "datestamp VARCHAR(40) NOT NULL," 
//                      + "costomername VARCHAR(20)  NOT NULL,"
//                    + "phone VARCHAR(20)  NOT NULL," 
//                      + "goodsname VARCHAR(20)  NOT NULL," 
//                     + "goodsquantity VARCHAR(20)  NOT NULL,"
//            + "qty_per_cartons VARCHAR(20)  NOT NULL,"
//     
//                     + "goodscost VARCHAR(200)  NOT NULL,"
//                     + "totalcostofgoods VARCHAR(700)  NOT NULL,"
//                     + "totalamountpaid VARCHAR(700)  NOT NULL,"
//                      + "date VARCHAR(20),"
//        + "paymentstatus VARCHAR(20),"
//       + "datereg VARCHAR(20),"
//        
//            
//            + "PRIMARY KEY(ID))" 
//); 
//           
//     stmt.execute("CREATE TABLE GOODS_RECORD"
//         + "(gooodsname VARCHAR(400)  NOT NULL ," 
//                       + "goods_detail VARCHAR(900)  NOT NULL," 
//                     + "pieces_per_cartons VARCHAR(200)  NOT NULL,"
//                     + "qty_of_carton VARCHAR(200)  NOT NULL,"
//                       + "prize_per_piece VARCHAR(20)  NOT NULL," 
//                     + "prize_per_carton VARCHAR(700)  NOT NULL,"
//                    // + "qty_sold VARCHAR(700)  NOT NULL,"
//                    //  + "qty_remaining VARCHAR(200)  NOT NULL,"
//                    // + "date VARCHAR(700)  NOT NULL,"
//                    // + "amount_sold VARCHAR(700)  NOT NULL,"
//                  //  + "amount_expected VARCHAR(200)  NOT NULL,"
//                    // + "goods_status VARCHAR(700)  NOT NULL,"
//                    + "date VARCHAR(700)  NOT NULL,"
//                    + "MFD VARCHAR(40)  NOT NULL,"
//                    + "EXP_DATE VARCHAR(40)  NOT NULL,"
//                 
//                    
//            
//            + "PRIMARY KEY(gooodsname))" 
//);        
//            */
//         //  stmt.execute("ALTER TABLE `SALES11` CHANGE `goodsquantity` `goodsquantity` INT(20) NOT NULL;   "
//      //    stmt.execute("ALTER TABLE GOODS_RECORD DROP goods_pics ; " 
//// );
//   System.out.println("asssss");
//            String insert;String adp="adp";
// String adu="adu";
// 
// String sep="sep";
// 
// String seu="seu";
// 
// 
//      //      insert = "INSERT INTO LOGIN1 VALUES('"+adu+"','"+adp+"','"+seu+"','"+sep+"')";
//        
////  String display="SELECT COURSE_NAME FROM new_course";
//           
//      // stmt.executeUpdate( insert);
//            
//            System.out.println("TABLE ALTERED");
//        } catch (ClassNotFoundException ex) {
//         System.out.println("CONNECTION ERROR");    
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex .getMessage());      }  
//      
//    
//    
//    
//    }
//    
//}
