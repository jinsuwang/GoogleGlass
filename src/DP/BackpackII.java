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
public class BackpackII {
    public static int backPackII(int m, int[] A, int[] V ) {
        // write your code here
        int[][] dp = new int[A.length+1][m+1];
        for(int i = 0; i <= A.length ; i++ ){
            for( int j = 0; j <= m; j++ ){
                if( j == 0 || i == 0){
                    dp[i][j] = 0;
                }else if( A[i-1] > j ){
                    dp[i][j] = dp[i-1][j]; 
                }else{
                    // take it or not take it.
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-A[i-1]] + V[i-1] ); 
                }
            }
        }
        return dp[A.length][m];
    }    
    
    public static void main(String[] args) {
        int[] A = { 77, 22, 29, 50, 99 };
        int[] V = { 92, 22, 87, 46, 90 };
        int m = 100;
        
        System.out.println(backPackII( m, A, V ));
    }
}
