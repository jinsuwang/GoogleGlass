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
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if( m <= 0 || n <= 0 || nums1 == null || nums2 == null ) return; 
    
        while( m > 0 && n > 0 ){
            int tmpN = nums2[n-1];
            int tmpM = nums1[m-1];
            
            if( tmpN >= tmpM ){
                nums1[n+m-1] = tmpN;
                n--;
            }else{
                nums1[n+m-1] = tmpM;
                m--;
            }
        } 
        
        while( n >= 0 ){
            nums1[n] = nums2[n];
            n--;
        }
    }
    
    public static void main(String[] args) {
        int[] num1 = { 1,3,5,6,7,0,0,0,0,0 };
        int[] num2 = { 2,4,6,8 };
        merge( num1, 5, num2, 4);
        System.out.println( Arrays.toString(num1) );
    }
}
