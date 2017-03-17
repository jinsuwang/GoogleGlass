/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.JavaFeature;

import java.util.Vector;

/**
 *
 * @author Sam
 */
public class JavaVector {
    
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("this is a string");
        v.add(3);
        
        System.out.println(v.toString());
    }
    
}
