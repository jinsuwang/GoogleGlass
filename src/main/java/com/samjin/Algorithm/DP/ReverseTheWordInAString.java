package com.samjin.Algorithm.DP;


import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class ReverseTheWordInAString {
    public static String reverseWords(String s, char delimiter) {
        int pre = 0;
        char[] sChar = s.toCharArray();
//        System.out.println(Arrays.toString(sChar));
        for( int i = 0; i < s.length(); i++ ){
            if( s.charAt(i) == delimiter ){
                swap(sChar, pre, i-1);
                pre = i + 1;
            }else if( i == s.length()-1 ) swap( sChar, pre, i);
        }
        swap(sChar, 0, s.length()-1);
        return Arrays.toString(sChar);
    }

    private static void swap(char[] sChar, int i, int j) {
        while( i < j ){
            char tmp = sChar[i];
            sChar[i] = sChar[j];
            sChar[j] = tmp;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
//        char[] test = {'a','b','c','d','e'};
//        swap( test, 0, 4);
        String test = "the sky is blue";
        char delimiter = ' '; 
        System.out.println( reverseWords(test, delimiter) );
    }
}
