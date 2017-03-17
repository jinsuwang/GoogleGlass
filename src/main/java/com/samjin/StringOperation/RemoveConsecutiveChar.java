package com.samjin.StringOperation;


import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class RemoveConsecutiveChar {
    
    
    static String removeConsecutiveChar(String str){
        
        String ret = removeConsecutiveCharHelper(str);
               
        while( hasDuplicate(ret) ){
            ret = removeConsecutiveCharHelper(ret);
            
        }
        return ret;
    
    }
    
    
    public static String removeConsecutiveCharHelper(String str ){
        
        StringBuffer sb = new StringBuffer();
        int index = 0;
        int prev = 0;
      
        while( index < str.length() ){
            while( index < str.length()-1 && str.charAt(index) == str.charAt(index+1) ){
                index++;
            }
            
            if( prev == index ){
                sb.append(str.charAt(index));
            }
            index++;
            prev = index;  
        }                
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
        System.out.println( removeConsecutiveChar("abbabb") );
        
    }

    private static boolean hasDuplicate(String ret) {
        Set<Character> set = new HashSet<Character>();
        for( char c : ret.toCharArray()){
            set.add(c);
        }
        return ret.length() != 0 && set.size() != ret.length();
    }
}
