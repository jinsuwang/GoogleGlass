/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class MaximalSquare {
    
    public static int maximalSquare(char[][] matrix) {

        int max = 0;

        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
                return max;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] dp = new int[row][col];
        
        for(int i = 0; i < row; i++ ){
            for( int j=0; j < col; j++ ){
                if( i == 0 ){ // first row,
                    dp[i][j] = matrix[i][j] - '0';
                }else if( j == 0 ){
                    dp[i][j] = matrix[i][j] - '0';
                }else{
                    if( matrix[i][j] == '0'){
                        dp[i][j] = 0;
                    }else{
                        int left = dp[i][j-1];
                        int top = dp[i-1][j];
                        if( left != top ){
                            dp[i][j] = Math.min( left, top ) + 1;
                        }else{
                            dp[i][j] = (matrix[i-top][j-left] == '1') ? left + 1 : left;
                        }
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        
        for( int[] e : dp ){
            System.out.println(Arrays.toString(e));
        }
        return max*max;
    }
    
    public static void main(String[] args) {
        char[][] test = {
            { '0', '1', '1' },
            { '1', '1', '1' },
            { '0', '1', '1'}
        };
        
        maximalSquare( test );
    }
    
}
