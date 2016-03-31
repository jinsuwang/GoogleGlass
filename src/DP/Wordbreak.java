/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Set;

/**
 *
 * @author Sam
 */
public class Wordbreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] cache = new boolean[ s.length() + 1 ];
        cache[0] = true;
        int maxLength = getMaxLength(wordDict);
        for( int i = 1; i <= s.length(); i++ ){
            for( int j = 1; j <= maxLength && j <= i; j++ ){
                if( !cache[i-j] ) continue;
                String word = s.substring(i-j, i);
                if (wordDict.contains(word)) {
                    cache[i] = true;
                    break;
                }
            }
        }
        return cache[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        
       
    }
}
