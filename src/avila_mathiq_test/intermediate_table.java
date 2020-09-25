/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avila_mathiq_test;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ONYEKA
 */
public class intermediate_table {
 private final StringProperty NAME;
         private final StringProperty IQ;
        
        
 
 
    public intermediate_table(String NAME, String IQ ) {
    
      this.NAME=new SimpleStringProperty(NAME);
            this.IQ=new SimpleStringProperty(IQ);
                      }

    public String getName() {
        return NAME.get();
    }
 public String get1Q() {
        return IQ.get();
    } 
  
    public void setName(String fName) {
        NAME.set(fName);
    }
     public void setIQ(String fName) {
        IQ.set(fName);
    }
         
    public StringProperty NAMEProperty()
    {return NAME;}
    public StringProperty IQProperty()
    {return IQ;}
   

}
