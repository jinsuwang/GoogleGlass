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
public class MinimumPathSum {
    
    public static int minPathSum(int[][] grid) {
            
        int[] sum = grid[0];
        
        for( int j = 1; j < grid[0].length; j++ ) sum[j]=sum[j-1]+grid[0][j];
        
        System.out.println(Arrays.toString(sum));

        for( int i = 1; i < grid.length; i++ ){
            // must move take first position
            sum[0] += grid[i][0];
           
            for( int j = 1; j < grid[0].length; j++ ){
                sum[j] = Math.min(sum[j-1], sum[j]) + grid[i][j];
            }
        }
        return sum[sum.length-1];
    }
    public static void main(String[] args) {
        int[][] test= {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        
        System.out.println(minPathSum( test ));
    }
}
