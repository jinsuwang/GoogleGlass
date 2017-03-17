/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.SearchAndSort;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class InsertionSort {
    
    // 
    
    public static void myInsertionSort( int[] nums ){
        int tmp;
        for( int i=1; i < nums.length; i++ ){
            for( int j=i; j>0; j--){
                if( nums[j-1] > nums[j]){
                    tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp; 
                }
                System.out.println( Arrays.toString(nums) );
            }
        }
    }
    
    public static void main(String[] args) {
        int[] test = { 5,4,3,2,1 };
        myInsertionSort( test );
        System.out.println(Arrays.toString(test));
    }
}
