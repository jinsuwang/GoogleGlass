/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.StringOperation;

/**
 *
 * @author Sam
 */
public class StrStr {
    public int strStr(String haystack, String needle) {

        if( haystack == null || needle == null ) return -1;
        int hLen = haystack.length();
        int nLen = needle.length();
        if(needle.length() > haystack.length()) return -1;
        for( int i = 0; i <= hLen-nLen; i++){
            if( haystack.substring(i, i+nLen).equals(needle) ) return i;
        }
        return -1;
    }
    
    /*
        Not allow equal function
    */
    public static int strStr2( String haystack, String needle ){
        if( haystack == null || needle == null ) return -1;
        if( needle.length() == 0 ) return 0;
        int hLen = haystack.length();
        int nLen = needle.length();
        if(needle.length() > haystack.length()) return -1;
        for( int i = 0; i <= hLen-nLen; i++){
            int j = 0;
            while( j < nLen ){
                if( haystack.charAt(i+j) != needle.charAt(j) ) break;
                j++;
                if( j == nLen) return i;
            }
        }
        return -1;
    }
    
    
    /*
        KMP 
    */
    public static int strStr3( String haystack, String needle ){
        return 0;
    }
    
    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        System.out.println( strStr2( haystack, needle ) );
    }
}
    
