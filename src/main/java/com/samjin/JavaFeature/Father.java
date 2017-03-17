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
public class Father {
    public int x;
    Father( int x ){
        this.x = x;
    }
    
    public void say(){
        System.out.println("I am the father.");
    }

    public void sing() {
        System.out.println("Father is singing");
    }
    
}
