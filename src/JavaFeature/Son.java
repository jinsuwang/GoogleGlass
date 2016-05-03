/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature;

/**
 *
 * @author Sam
 */
public class Son extends Father {
    Son(int x){
        super(x);
    }  
    
    public void say(){
        System.out.println("I am the son.");
    }
    
    public void say(String word){
        System.out.println("I am the " + word );
    }
   
}
