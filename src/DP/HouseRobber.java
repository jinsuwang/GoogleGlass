/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Sam
 */
public class HouseRobber {
    
    public int rob(int[] nums) {
        
        if (nums==null || nums.length == 0) return 0;  
        if( nums.length == 1) return nums[0];

        
        int[] dp = new int[nums.length+1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for( int i = 2; i <= nums.length; i++ ){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length];
    }
    
    
}
