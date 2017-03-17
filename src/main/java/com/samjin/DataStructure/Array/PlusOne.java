/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class PlusOne {
    
    public static int[] plusOne(int[] digits) {
        if( digits == null ) return null;
        int carry = 0;
        int tmp = 0;
        for(int i=digits.length-1; i>=0; i-- ){
            if( i == digits.length-1 ){
                tmp = digits[i] + 1;
            }else{
                tmp = digits[i];
            }
            tmp += carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            
            digits[i] = tmp;
            if( i == 0 && carry != 0 ){
                int[] sol = new int[digits.length+1];
                System.arraycopy( digits, 0, sol, 1, digits.length );
                sol[0] = carry;
                return sol;
            }
            
        }
        return digits;
    }
    public static void main(String[] args) {
        int[] test = new int[]{ 9,9,9,8 };
        System.out.println( Arrays.toString( plusOne(test) ));
    }
}
