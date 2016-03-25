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
public class MinimumPathSum {
    
    public int minPathSum(int[][] grid) {
            
        int[] sum = grid[0];
        
        for( int j = 1; j < grid[0].length; j++ ) sum[j]=sum[j-1]+grid[0][j];
        for( int i = 1; i < grid.length; i++ ){
            sum[0] += grid[i][0];
            for( int j = 1; j < grid[0].length; j++ ){
                sum[j] = Math.min(sum[j-1], sum[j]) + grid[i][j];
            }
        }
        return sum[sum.length-1];
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = a;
        a[0] = 5;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
