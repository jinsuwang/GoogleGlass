/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.StringOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class StrobogrammaticNumber {
    
    public static boolean isStrobogrammatic(String num) {
        if( num.length() == 0 ) return true;  
        Map<Character, Character> hash =  new HashMap<Character,Character>();
        
        hash.put('0','0');
        hash.put('1','1');
        hash.put('2','#');
        hash.put('2','#');
        hash.put('3','#');
        hash.put('4','#');
        hash.put('5','#');
        hash.put('6','9');
        hash.put('7','#');
        hash.put('8','8');
        hash.put('9','6');
        
        String result = "";  
        for(int i = num.length()-1; i >=0; i--)  
            result += hash.get( num.charAt(i) );  
        return num.equals(result);  
       
    }
    
    // find all  Strobogrammatic Number by given length
    public List<String> findStrobogrammatic(int n) {
        List<String> sol = new ArrayList<String>();
        
        
    }
    
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));
    }
}
