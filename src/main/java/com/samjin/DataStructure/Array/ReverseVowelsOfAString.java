/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class ReverseVowelsOfAString {
    
    public static String reverseVowels(String s){
        
        if( s == null || s.length() < 2 ) return s;
        char[] cArray = s.toCharArray();
        Set<Character> set = new HashSet<Character>();
        for( char c : "aeiou".toCharArray()) set.add(c);
        
        int left = 0;
        int right = s.length()-1;
        
        while( left < right ){
            while( left < right && !set.contains( Character.toLowerCase( cArray[left] ) )){
                left++;
            }
            
            while( right > left && !set.contains( Character.toLowerCase( cArray[right] ) )){
                right--;
            }
            
            swap( cArray , left, right );
            
//            System.out.println(Arrays.toString(cArray) + cArray[left] + cArray[right]);
            left++;
            right--;
            
        }
        return new String(cArray);
       
    }

    private static void swap(char[] cArray, int left, int right) {
        char tmp = cArray[left];
        cArray[left] = cArray[right];
        cArray[right] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
