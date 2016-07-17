/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WordLadderII {
    
    public static List<List<String>> findLadders(String beginWord, String endWord,
            Set<String> wordList ){
        
        List<List<String>> ladders = new ArrayList<List<String>>();
   
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        wordList.add(endWord);
        wordList.add(beginWord);
        
        bfs( distance, beginWord, endWord, wordList );
        
        System.out.println(distance);
        
        List<String> path = new ArrayList<String>();
        
        dfs( endWord, beginWord, wordList, ladders, path, distance);
        return ladders;
     
    }
    
    
    private static void bfs( Map<String, Integer> distance, String beginWord, String endWord, Set<String> wordList) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        // remember distance to beginword
        distance.put(beginWord, 0);
        
        while( !queue.isEmpty() ){
            String curr = queue.poll();
            List<String> nextStrings = getNextString(curr, wordList);
            for( String next : nextStrings ){
                if( !distance.containsKey(next)){
                    distance.put(next, distance.get(curr)+1);
                    queue.offer(next);                    
                }
            }  
        }
    }
    

    private static void dfs(String start, String end, Set<String> wordList, List<List<String>> ladders, List<String> path, Map<String, Integer> distance) {
        
    
    }
    
    
    
    private static List<String> getNextString(String curr, Set<String> wordSet) {
        List<String>  nextStrings = new ArrayList<String>();
        
        for( int i = 0; i < curr.length(); i++){
            for( char j = 'a'; j <= 'z'; j++ ){
                char[] tmp = curr.toCharArray();
                if( j != tmp[i] ){
                    tmp[i] = j;
                    String tmpString = new String( tmp );
                    if( wordSet.contains(tmpString)){
                        nextStrings.add(tmpString);
                    }
                }
            }
        }
        return nextStrings;
    }
    
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");

        String beginWord = "hit";
        String endWord = "cog";
        
        
        
        List<List<String>> sol =  findLadders( beginWord, endWord, set );
    }
}
