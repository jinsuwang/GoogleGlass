/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.JavaFeature;

/**
 *
 * @author Sam
 */
public class MyThread extends Thread{
    
    private String name;
    public MyThread( String name ){
        this.name = name;
    }
    public void run(){
        for( int i = 0; i < 5; i++ ){
            System.out.println(this.name + " running " + i);
            try {
                
                // avoid current thread use too much Resource. 
                sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        MyThread A = new MyThread("A");
        MyThread B = new MyThread("B");
        
        // It's not actually start. just mark thread as "Runable", 
        // the system will determine when to run.
        A.start();
        B.start();
        
    }
}
