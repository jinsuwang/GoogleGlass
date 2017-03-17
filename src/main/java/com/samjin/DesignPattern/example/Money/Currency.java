/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DesignPattern.example.Money;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Sam
 */
public class Currency {
    
    private static Map<String, TreeMap<String, Long>> c = new HashMap<String, TreeMap<String, Long>>();
    
    private Currency( ){}
    
    public static Map<String, TreeMap<String, Long>> getCurreny(){
        return c;
    }
    
    public void addCurrency( Country a, Country b, double rate ){
    }
    
    public int size(){
        return c.size();
    }
}
