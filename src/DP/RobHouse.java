package DP;


import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class RobHouse {
    
    /*
        [ 1 ,3, 2, 4, 6, 8 ];
    
    */
    
    public static int findMaximumValue( int[] nums ){
        
        if (nums==null || nums.length == 0) return 0;  
        if( nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length+1];
        
        dp[0] = 0;
        dp[1] = nums[0];
        
        for( int i = 2; i <= nums.length; i++ ){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }
    
   
    public int rob(int[] nums) {
        
        if (nums==null || nums.length == 0) return 0;  
        if( nums.length == 1) return nums[0];
        
        int len = nums.length;
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];

        dp1[1] = 0;
        dp2[1] = nums[0];
        
        for( int i = 2; i <= nums.length; i++ ){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i-1]);
        }
        for( int i = 2; i <= nums.length-1; i++ ){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i-1]);
        }
        
        return Math.max(dp1[len], dp2[len-1]);
    }
    
    
    
    public static void main(String[] args) {
        int[] test =  {  2 ,3, 2, 4, 6, 8 };
        System.out.println(findMaximumValue( test ));
    }
    
    
}
    

