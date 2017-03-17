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
public class PerfectSquares {
    public static int numSquares(int n) {
                
        int[] dp = new int[n+1];
        dp[1] = 1;
        
        for( int i = 2; i <= n; i++ ){
            if( isPerfectSquare(n)){
                dp[n] = 1;
            }else{
                int tmp = Integer.MAX_VALUE;
                for( int j = 1; j*j <= i; j++ ){
                    tmp = Math.min(tmp, dp[i - j*j]);
                } 
                dp[i] = tmp+1;
            }
        }
        
        return dp[n];
    }
    
    
    // fancy
    public static int numSquares2(int n) {
        while( n % 4 == 0 ) n /= 4;
        if (n % 8 == 7) return 4;

        for( int i = 0; i * i <= n; i++ ){
            int b = (int)Math.sqrt( n - i*i );
            if( i*i + b*b == n ){
                if( i == 0 && b == 0) return 0;
                else if( i == 0 || b == 0) return 1;
                else return 2;
            }
        }
        return 3;
    }

    
    

    private static boolean isPerfectSquare(int n) {
        for( int i = 1; i*i <= n; i++){
            if( i * i == n) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println( numSquares2(13) );
    }
}
