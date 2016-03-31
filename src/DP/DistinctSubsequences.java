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
public class DistinctSubsequences {
    
    public int numDistinct(String s, String t) {
        if( s == null || t == null ) return 0;
        int lenS = s.length();
        int lenT = t.length();
        if( lenT > lenT ) return 0;
        int[][] cache = new int[lenS+1][lenT+1];
        for( int i = 0; i <= lenS; i++ ){
            for( int j = 0; j <= lenT; j++ ){
                if( i == 0 && j == 0 ){
                    cache[i][j] = 1; // empty string.
                }else if( i == 0 ){
                    cache[i][j] = 0; // S is empty string.
                }else if( j == 0 ){
                    cache[i][j] = 1; // T is empty string.
                }else{
                    if( s.charAt(i-1) == t.charAt(j-1 )){
                        cache[i][j] += cache[i-1][j-1];
                    }
                    cache[i][j] += cache[i-1][j]; // inherit from previous string.
                }
            }
        }
        return cache[lenS][lenT];
    }
}