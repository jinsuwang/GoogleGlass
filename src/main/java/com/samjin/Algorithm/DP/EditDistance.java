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
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if( word1 == null || word2 == null ) return 0;
        if( word1.length() == 0 ) return word2.length();
        if( word2.length() == 0 ) return word1.length();
        int rows = word1.length();
        int cols = word2.length();
        int[][] cache = new int[rows+1][cols+1];
        for( int i = 0; i <= rows; i++ ){
            for( int j = 0; j <= cols; j++ ){
                if( i == 0 ){
                    cache[i][j] = j;
                }else if( j == 0 ){
                    cache[i][j] = i;
                }else{
                    int insert = cache[i][j-1] + 1;
                    int delete = cache[i-1][j] + 1;
                    int replace = cache[i-1][j-1];
                    if ( word1.charAt(i-1) != word2.charAt(j-1)){
                        replace ++;
                    }
                    cache[i][j] = Math.min(replace, Math.min( insert, delete ));
                }
            }
        }
        printCache( cache );
        return cache[rows][cols];
    }

    private static void printCache(int[][] cache) {
        for(int[] e : cache ){
            System.out.println(Arrays.toString(e));
        }
    }
    public static void main(String[] args) {
        minDistance("a", "b");
    }
    
}
