/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.BitOperation;

/**
 *
 * @author Sam
 */
public class PowerOfTwo {
    
    public static boolean isPowerOfTwo(int n) {
        if( n <= 0 ) return false;
        while( n > 1){
            if( n % 2 != 0 ) return false;
            n /= 2;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }
}
