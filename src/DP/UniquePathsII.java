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
public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
       
        int[][] dp = new int[row+1][col+1];
        for( int i = 1; i <= row; i++ ){
            for( int j = 1; j <= col; j++ ){
                if(  obstacleGrid[i-1][j-1] == 1 ){
                    System.out.println("Oops!");
                    dp[i][j] = 0;
                }else{
                    if( i == 1 && j == 1 ){
                        dp[i][j] = 1;
                    }else if( i == 1 && dp[i][j-1] != 0 ){
                        dp[i][j] = 1;
                    }else if( j == 1 && dp[i-1][j] != 0 ){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
        }
        for( int i=0; i<dp.length;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[row][col];
    }
    
    public static void main(String[] args) {
        int[][] test = {
            {0,0,0},
            {1,1,0},
            {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles( test ));
    }
}
