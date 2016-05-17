/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature.Locks;

import java.util.Random;

/**
 *
 * @author Sam
 */
public class LocksTest {
    
    public static void main(String[] args) {
        
        final Locks readWrite = new Locks();
        
        for( int i=0; i<3; i++ ){
            new Thread( new Runnable(){
                @Override
                public void run(){
                    readWrite.get();
                }
            }).start();
            
            new Thread( new Runnable(){
                @Override
                public void run(){
                    readWrite.put( new Random().nextInt(8) );
                }
            }).start();
        }    
    }
}
