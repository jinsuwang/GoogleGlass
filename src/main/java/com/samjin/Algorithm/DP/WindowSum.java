/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class WindowSum {
    
    public static int[] windowSum( int[] arr, int k ){
        if( k > arr.length ) return null;
        int[] sol = new int[ arr.length - k + 1 ];
        
        for( int i = 0; i < arr.length - k +1; i++ ){
            int tmpSum = 0;
            for( int j = 0; j < k; j++ ){
                System.out.println(i + "  " + j);
                tmpSum += arr[i+j];
            }
            sol[i] = tmpSum;
        }
        return sol;
    }
    
    public static void main(String[] args) {
        int[] test = { 1, 2, 3, 4, 5, 6, 7 };
        int[] sol = windowSum( test, 5 );
        System.out.println(Arrays.toString(sol));
    }
}
