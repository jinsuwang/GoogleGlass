/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Tricky;

/**
 *
 * @author Sam
 */
public class StringtoInteger {
    
    private static final int PREV = Integer.MAX_VALUE / 10;
    private static final int FINAL_DIGIT = Integer.MAX_VALUE - PREV * 10;
    
    public static int myAtoi(String str) {
        int len = str.length();
        int index = 0;
        int sign = 1;
        int result = 0;
        if( len == 0 ) return len;
        while( index < len && str.charAt(index) == ' ' ) index++; // remove emtry space
        if( index < len && str.charAt(index) == '-' ){
            index ++; 
            sign = -1;
        }else if( index < len &&  str.charAt(index) == '+') index++; // check positive and negative
        while( index < len && Character.isDigit(str.charAt(index)) ){
            int diff = str.charAt(index) - '0';
            if( result >= PREV ){
                if( sign == 1 && ( diff > FINAL_DIGIT || result > 1000000000 )) return Integer.MAX_VALUE;
                if( sign == -1 && diff > FINAL_DIGIT+1 || result > 1000000000  ) return Integer.MIN_VALUE;
            }
            result = result * 10 + diff;
            index++;
        }
        return sign * result;
    }

}
