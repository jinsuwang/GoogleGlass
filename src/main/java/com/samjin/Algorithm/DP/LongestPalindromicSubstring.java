/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

/**
 *
 * @author Sam
 */
public class LongestPalindromicSubstring {
    
    
    public static String longestPalindrome(String s) {
        if( s == null ) return null;
        String longestString = "";

        for( int i=0; i < s.length(); i++ ){
            String s1 = helper(s, i, i);
            String s2 = helper(s, i, i+1);
            if( s1.length() > longestString.length() ) longestString = s1;
            if( s2.length() > longestString.length() ) longestString = s2;
        }
        return longestString;
    }

    private static String helper(String s, int i, int j) {
        while( i >= 0 && j <= s.length()-1 ){
            if ( s.charAt(i) != s.charAt(j) ){
                break;
            }else{
                i--; 
                j++;
            };
        }
        return s.substring(i+1, j);
    }
    public static void main(String[] args) {
        String a = "abacd";
        System.out.println( longestPalindrome(a) );
//        System.out.println(a.substring(0, 5));
    }
}
