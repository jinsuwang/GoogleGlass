/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

/**
 *
 * @author Sam
 */
public class RegularExpressionMatch {
    
    
    /*
    
    
    - RE is typical divide and conquer question.in each sub-problem, we do the same stuff.
    
    - check string have been consumed, if yes, check the rest pattern of could mean empty.
    - check pattern is empty, if string is not empty but pattern is empty, return false.
    - get current char, current pattern char and next pattern char
    - if next pattern char is *
        - if current string char matched, jump to next string char or remove current pattern
        - else remove current pattern
    - if next pattern is not char:
        - if current string char matched, both move one char.
        - if not match, return false.
    
    
    
    */
    
    
    
    public static boolean isMatch(String s, String p ) {
        
        
        // check string length and pattern length;
        
        /* if consume all the string, generally it already fit, 
           just need double check the pattern have * 
        */
        if( s.length() == 0 ) return checkEmpty(p);
        
        // consume all the pattern, return false;
        if( p.length() == 0 ) {
            return false;
        }
        
        /* 
        fetch first char in string and pattern, and use a variable
        to store is next string is *;    
        */
        char c1 = s.charAt(0);
        char d1 = p.charAt(0);
        char d2 = '0';
        
        if(p.length() > 1) d2 = p.charAt(1);
            
        // if next string is *,
        if( d2 == '*' ){ 
            // compare current char
            if( compare(c1, d1)){
                // eliminate current char and do it again, or ignore current pattern
                // either one works will be fine
                return isMatch( s.substring(1), p ) || isMatch( s, p.substring(2) );
            }else{
                // ignore current char.
                return isMatch(s, p.substring(2));
            }
        }else{
            if( compare(c1, d1) ){
                // compare current string
                return isMatch(s.substring(1), p.substring(1));
            }else{
                // return false
                return false;
            }      
        }
    }
    
    private static boolean compare( char c1, char d1 ){
        return d1 == '.' || c1 == d1;
    }

    private static boolean checkEmpty(String p) {
        // if pattern is not even.
        if( p.length() % 2 != 0 ) return false;
        for( int i=1; i < p.length(); i+=2 )
            if( p.charAt(i) != '*') return false;
        return true;
    }
    
    public static void main(String[] args) {
        
        String s = "aa"; 
        String p = "a*b";
//        isMatch("aa","a") → false 
//        isMatch("aa","aa") → true 
//        isMatch("aaa","aa") → false 
//        isMatch("aa", "a*") → true 
//        isMatch("aa", ".*") → true 
//        isMatch("ab", ".*") → true 
//        isMatch("aab", "c*a*b") → true
        System.out.println(isMatch(s, p));
    }
}
