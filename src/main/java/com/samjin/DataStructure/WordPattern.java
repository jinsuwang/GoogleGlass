/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WordPattern {
    public static  boolean wordPattern(String pattern, String str) {
        
        if( pattern == null || str == null ) return false;
        
        String[] strs = str.split(" ");
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> set = new HashSet();

        
        
        if( pattern.length() != strs.length ) return false;
        for( int i = 0; i < strs.length; i++ ){
            if( !map.containsKey(pattern.charAt(i)) ){
                if (!set.add(strs[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), strs[i]);
            }else{
                if( !map.get(pattern.charAt(i)).equals(strs[i]) ){
                    return false;
                }
            }
        }
        return true;
    }
    
    
    
    // follow up 
    public boolean wordPatternMatch(String pattern, String str) {
        int pLen = pattern.length();
        int segment = str.length() / pLen;
        if( segment * pLen != str.length() ) return false;
        
        
        
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        String str1 = "abba";
        String str2 = "dog dog dog dog";
        
        System.out.println( wordPattern(str1, str2) );
        
    }
}
