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
public class LongestCommonprefix {
    public static String longestCommonPrefix(String[] strs) {
        if( strs == null || strs.length == 0 ) return "";
        int maxLen = 0;
        String first = strs[0];
        
        for( int i = 0; i < first.length(); i++ ){
            for( int j = 1; j < strs.length; j++ ){
                String curr = strs[j];
                if( i >= curr.length() ||  curr.charAt(i) != first.charAt(i) ){
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }
    
    public static void main(String[] args) {
        String a = "aa";
        String b = "a";
        String[] test = { a, b };
//        System.out.println(a.substring(0,1));
        System.out.println( longestCommonPrefix( test ));
    }
    
}
