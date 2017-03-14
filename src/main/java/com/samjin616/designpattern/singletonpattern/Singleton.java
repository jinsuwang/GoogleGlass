/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin616.designpattern.singletonpattern;
import static java.lang.System.identityHashCode;

/**
 *
 * @author Sam
 */
public class Singleton {
    
    private static Singleton uniqueInstance = null;
    
    private Singleton(){
        System.out.println("Create new Instance.");
    }
        
    public static Singleton getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
    
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(identityHashCode(s1));
        System.out.println(identityHashCode(s2));
    }
}
