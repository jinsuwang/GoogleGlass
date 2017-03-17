/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class PalindromePermutation {
    
    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for( char e : s.toCharArray()){
            if( !map.containsKey(e) ){
                map.put(e, 1);
            }else{
                map.remove(e);
            }
        }
        return map.size() == 1 || map.size() == 0;
    }
    public static void main(String[] args) {
        String s1 = "code";
        String s2 = "aab";
        System.out.println(canPermutePalindrome(s1));
        System.out.println(canPermutePalindrome(s2));
    }
}
