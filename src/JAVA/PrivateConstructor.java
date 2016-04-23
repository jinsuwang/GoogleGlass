package JAVA;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class PrivateConstructor {
    
    class InnerClass{
        public InnerClass(){
            System.out.println("I am a Inner Class");
        }
    }
    
    private PrivateConstructor(){
        InnerClass ic = new InnerClass();
        System.out.println("I am Private Construcure");
    }    
    
    public static void main(String[] args) {
        PrivateConstructor a = new PrivateConstructor();
    }
}
