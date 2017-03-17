/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Tricky;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse( nums, 0, len-1-k );
        reverse( nums, len-k,len-1);
        reverse( nums, 0, len-1 );
    }

    private static void reverse(int[] nums, int left, int right) {
        while( left < right ){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }        
    }
    
    public static void main(String[] args) {
        int[] test = { 1,2,3,4,5,6,7};
        rotate( test, 3);
        System.out.println(Arrays.toString(test));
    }
}
