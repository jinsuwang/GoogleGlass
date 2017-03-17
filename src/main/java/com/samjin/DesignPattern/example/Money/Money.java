/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DesignPattern.example.Money;

/**
 *
 * @author Sam
 */
public abstract class Money {
    
    private double amount;
    private double currency;
    
    public abstract double add( Money m ); 
    public abstract double substract( Money m ); 
    public double getVlaueWithDecimal( int d);

}
