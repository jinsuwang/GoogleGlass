/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class MinTwoNumber {
    
    public static int[] findMinTwoNumber( int[] arr ){
        if( arr.length <= 2 ) return arr;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for( int i = 0; i < arr.length; i++ ){
            int curr = arr[i];
            if( curr < min2 ){
                if( curr < min1 ){
                    min2 = min1;
                    min1 = curr;
                }else{
                    min2 = curr;
                }
            }
        }
        return new int[]{ min1, min2 };
    }
    
    public static void main(String[] args) {
        int[] test = {4,6,8,3,9,33,22};
        System.out.println(  Arrays.toString( findMinTwoNumber( test ) ));
    }
}
