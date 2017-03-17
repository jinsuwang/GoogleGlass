/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class MaximumSizeSubarraySumEqualsk {
    
    
    public int maxSubArrayLen(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxLen = -1;
        map.put(0, -1);
        
        for( int i = 0; i < nums.length; i++ ){
            sum += nums[i];
            if( !map.containsKey(sum)){
                map.put(sum, i);
            }
            // difference is result
            if( map.containsKey( sum-k ))
                maxLen = Math.max( maxLen, i-map.get(sum-k) ); 
        }
        return maxLen;
    }
}
