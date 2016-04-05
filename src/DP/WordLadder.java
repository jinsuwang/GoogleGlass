/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sam
 * 
 * 
 */
public class WordLadder {
    
    /*
        1. getNextWords() helper function to find next possible words. 
        2. Using level index to record the level of DFS.
        3. visited Set to remember Word have been explored.
    */
    
    public static int ladderLength( String begin, String end, Set<String> wordSet ){
        if( wordSet == null ) return 0;
        
        // add words to set 
        wordSet.add(begin); 
        wordSet.add(end);
        
        Set<String> visited = new HashSet<String>(); // memory.
        Queue<String> queue = new LinkedList<String>(); 
        int length = 1;
        while( !queue.isEmpty() ){
            length++;
            int size = queue.size(); // don't use queue.size() in the expression, it is dynamic.
            
            for( int i = 0; i < size; i++ ){
                String curr = queue.poll();
                for( String nextWord : getNextWord(curr, wordSet)){
                    if( visited.contains(curr) ) continue;
                    if( nextWord.equals(end) ) return length;
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    
    private static List<String> getNextWord(String word, Set<String> wordSet){
        List<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (wordSet.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    private static String replace( String a, int i, char c){
        char[] tmp = a.toCharArray();
        tmp[i] = c;
        return tmp.toString();
    }
    
    
    
}
