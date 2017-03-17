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
public class longestCommonSubString {
    
    public static String longestCommonSubstring(String A, String B) {
    
        if( A == null || B == null ) return "";
        int lenA = A.length();
        int lenB = B.length();
        
        int[][] cache = new int[lenA + 1][lenB + 1 ];
        
        int m = -1;
        int n = -1;
        int maxLen = 0;
        
        for( int i=0; i <= lenA; i++ ){
            for( int j=0; j <= lenB; j++ ){
                if( i == 0 || j == 0  ){
                    cache[i][j] = 0;
                }else{
                    if( A.charAt( i-1 ) == B.charAt( j-1 )){
                        cache[i][j] = cache[i-1][j-1] + 1;
                        if( cache[i][j] > maxLen ){
                            m = i; n = j;
                            maxLen = cache[i][j];
                        }
                    }else{
                        cache[i][j] = 0;
                    }
                }
            }
        }
        return B.substring( n-maxLen, n);
    }
    public static void main(String[] args) {
        String A = "ABCD";
        String B = "BCDE";
        String ret = longestCommonSubstring( A, B );
        System.out.println( ret );
    }
}
