/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.StringOperation;

/**
 *
 * @author Sam
 */
public class RepeatedString {
    public static boolean isReaptedString(String s){
        for( int i = 1; i <= s.length() / 2; i++ ){
            String sub = s.substring(0,i);
            System.out.println(sub);
            for( int j = i; j <= s.length() - i; j += i ){
                System.out.println(s.substring(j, j+i) + " " + j);
                if( !s.substring(j, j+i).equals(sub)) break;
                if( j+i == s.length() ) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "abcabcabc";
        String s2 = "abcdabcabc";
        String s3 = "ababababababab";
        System.out.println(isReaptedString(s3));
    }
}
