/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure;

/**
 *
 * @author Sam
 */
public class ShortestWordDistance {
    
    public static int shortestDistance(String[] words, String word1, String word2) {
        int m = -1, n = -1;
        int ret = Integer.MAX_VALUE;
        for( int i = 0; i < words.length; i++){
            if( words[i].equals(word1) )  m = i;
            if( words[i].equals(word2) )  n = i;
            if( m != -1 && n != -1) 
                ret = Math.min(  Math.abs(m-n), ret );
        }
        return ret;
    }
    
    public static int shortestDistance3(String[] words, String word1, String word2) {
        int m = -1, n = -1;
        int ret = Integer.MAX_VALUE;
        for( int i = 0; i < words.length; i++){
            if( words[i].equals(word1) ){ 
                m = i;
                if( m != -1 && n != -1){
                    ret = m==n ? ret : Math.min(  Math.abs(m-n), ret );
                }
            }
            if( words[i].equals(word2) ){
                n = i;
                if( m != -1 && n != -1) 
                    ret = m==n ? ret : Math.min(  Math.abs(m-n), ret );
            }
        }
        return ret;
    }
    
    
    public static void main(String[] args) {
        String[] test = {"practice", "makes", "perfect", "coding", "makes"};
        String[] test2 = {"a", "b"};
//        System.out.println( shortestDistance(test, "practice", "coding" ) );
//        System.out.println( shortestDistance(test, "makes", "coding" ) );
        System.out.println( shortestDistance3(test, "makes", "makes" ) );

    }
}
