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
public class UniquePath {
    public static int uniquePaths(int m, int n) {
        
        if( m == 0 || n == 0 ) return 0; 
        
        int[][] dp = new int[m][n];
        
        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                if( i == 0){
                    dp[i][j] = 1;
                }else if( j == 0 ){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
        System.out.println( uniquePaths(3,6) );
    }
}
