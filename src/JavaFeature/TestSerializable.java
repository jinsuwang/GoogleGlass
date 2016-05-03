/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sam
 */
public class TestSerializable implements Serializable{
    
    private static final long serialVersionUID = 1L;  
    public String name = "Sam";
    
    public static void main(String[] args) { 
        try {
            
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("my.out") );
            TestSerializable ts = new TestSerializable();
            oos.writeObject( ts );
            oos.flush(); 
            oos.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }   
        
        
        // deserialization
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream( new FileInputStream("my.out") );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        TestSerializable ts2 = null;
        try {
            ts2 = (TestSerializable)ois.readObject();      
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        System.out.println(ts2.name);
        
    } 
}
