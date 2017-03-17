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
public class PaintFence {
    public int numWays(int n, int k) {
        if( n == 0 || k == 0 ) return 0;
        int[] dp = new int[n+1];
        for( int i=1; i <= n; i++ ){
            if( i == 1 ){
                dp[i] = k;
            }else if( i == 2 ){
                dp[i] = k*k;
            }else{
                dp[i] = dp[i-1]*(k-1) + dp[i-2]*(k-1);
            }
        }
        return dp[n];
    }
}
