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
public class ClimbChair {
    
    
    // DP solution
    public static int climbStairs(int n) {
        
        if( n < 2 ) return 1;
        
        int[] dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for( int i = 3; i <= n; i++ ){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.out.println(Arrays.toString(dp));
        
        return dp[n];
        
    }
    
    private int steps = Integer.MAX_VALUE;
    
    public static int climbStairsDFS(int n){
        if( n < 2 ) return 1;
        return climbStairsDFS(n-1) + climbStairsDFS(n-2);
    }
    
    
    public static void main(String[] args) {
        int steps = climbStairsDFS( 3 );
        System.out.println(steps);
    }
}
