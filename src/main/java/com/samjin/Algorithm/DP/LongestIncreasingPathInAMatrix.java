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
public class LongestIncreasingPathInAMatrix {
    
    // don't need recalculate.
    private static int[][] dp;
    
    public static int longestIncreasingPath(int[][] matrix) {
        if( matrix == null || matrix.length == 0) return 0;
        
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        dp = new int[rows][cols];
        
        for( int i=0; i<rows; i++){
            for( int j=0; j< cols; j++){
                max = Math.max( max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int i, int j) {  
//        System.out.println( "accessing i: "+i+" j: "+j);
        if( dp[i][j] > 0 ){
//            System.out.println("we have i: " +i + " j:" + j);
            return dp[i][j];
        }
        int longest = 0;
        
        
        if( i>0 && matrix[i][j] < matrix[i-1][j])
            longest = Math.max( longest, dfs( matrix,i-1,j));
        if( j>0 && matrix[i][j] < matrix[i][j-1])
            longest = Math.max( longest, dfs( matrix,i,j-1));
        if( i < matrix.length-1 && matrix[i][j] < matrix[i+1][j] )
            longest = Math.max( longest, dfs( matrix,i+1,j));
        if( j < matrix[0].length-1 && matrix[i][j] < matrix[i][j+1])
            longest = Math.max( longest, dfs( matrix,i,j+1));
//        System.out.println( "i: "+i+" j: "+j+" longest: "+longest);    
        dp[i][j] = longest+1;
        return dp[i][j];
    }
    
    public static void main(String[] args) {
        int[][] test = new int[][]{
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        
        System.out.println(longestIncreasingPath(test));
    }
}
