/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

import java.util.ArrayList;
import java.util.List;

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
    
    
    // follow up: print out all path.
    public static List<List<Character>> uniquePaths( char[][] grid ){
        
        List<List<Character>> sol = new ArrayList<List<Character>>();
        
        move( grid, sol, new ArrayList<Character>(), 0, 0 );
        
        return sol;
        
    }
    
    private static void move(char[][] grid, List<List<Character>> sol, ArrayList<Character> curr, int i, int j) {
        
        if( i == grid.length-1 && j == grid[0].length-1 ){
            curr.add( grid[i][j] ); 
            sol.add( new ArrayList<Character>(curr));
            curr.remove(curr.size()-1);
            return;
        }else if(  i >= grid.length || j >= grid[0].length ) return;                               
        else{
            curr.add( grid[i][j] );
            move( grid, sol, curr, i+1, j  );
            move( grid, sol, curr, i ,  j+1 );
            curr.remove(curr.size()-1);
        }  
    }
    
    
    
    public static void main(String[] args) {
//        System.out.println( uniquePaths(3,6) );
        char[][] test = {
            {'a','b','c'},
            {'d','e','f'},
            {'h','i','j'}
        };
        
        List<List<Character>> sol = uniquePaths(test);
        for( List<Character> e : sol ){
            System.out.println(e.toString());
        }
    }


}
