/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

/**
 *
 * @author Sam
 */
public class MaximumSubarray {
    
    public int maxSubArray(int[] nums) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        
        for( int i = 0; i < nums.length; i++ ){
            sum += nums[i];
            max = Math.max( sum, max );
            sum = Math.max( sum, 0 );
        }
        
        return max;
    }
}
