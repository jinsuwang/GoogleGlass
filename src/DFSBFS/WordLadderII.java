/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;
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
    
    /*
        1. Using BFS to find map<String, List<String>> and distance<String, Integer>,
           List<String> is the words, have one character difference.
           distance is the map record the distance between begin word and key word.
       
        2. using DFS for backtraching from endWord to beginWord.
    */
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> ladders = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String,List<String>>(); // memory.
        Map<String, Integer> distance = new HashMap<String, Integer>();
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        bfs( map, distance, beginWord, endWord, wordList );
        List<String> path = new ArrayList<String>();
        
        printMap( map );
        printDistance( distance );
                
        dfs( ladders, path, endWord, beginWord, distance, map );
        return ladders;
    }

    private static void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord, String endWord, Set<String> wordList) {
        // preparation.
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        distance.put(beginWord, 0); // remerber distance.
        for( String s : wordList ){
            map.put( s, new ArrayList<String>());
        } // path ? 
        
        while( !queue.isEmpty() ){
            String curr = queue.poll(); 
            
            List<String> nextStrings = getNextString(curr, wordList);
            for(String next : nextStrings ){
                // add distance equal 1 to curr map.
                map.get(next).add(curr);
                
                if( !distance.containsKey(next) ){
                    distance.put( next,distance.get(curr)+1 );
                    queue.offer(next);
                }
            }
        }
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
    
    private static void dfs(List<List<String>> ladders, List<String> path, String curr, String beginWord, Map<String, Integer> distance, Map<String, List<String>> map) {
        path.add(curr);
        if( curr.equals(beginWord)){
            List<String> part = new ArrayList<String>(path);
            Collections.reverse(part);
            ladders.add(part);
        }else{
            for( String next : map.get(curr)){
                // back tracing
                if( distance.containsKey(next) &&  distance.get(curr) == distance.get(next) + 1 )
                    dfs( ladders, path, next, beginWord, distance, map );
            }
        }
        path.remove(path.size()-1);
    }
    

    private static void printMap(Map<String, List<String>> map) {
        for( Entry e : map.entrySet() ){
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }
    
    private static void printDistance(Map<String, Integer> distance) {
        for( Entry e : distance.entrySet() ){
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }
    
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        
        Set<String> wordSet = new HashSet<String>();
        String[] wordList = { "hot","dot","dog","lot","log" };
        for( String s : wordList ) wordSet.add(s);
        
        List<List<String>> ret = findLadders( beginWord, endWord, wordSet);
        for( List<String> e : ret ){
            System.out.println(e.toString());
        }
    }


}
