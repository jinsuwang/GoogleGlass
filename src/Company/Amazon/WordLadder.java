/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WordLadder {
    
    
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        int distance = 1;
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        
//        visited.add( beginWord );
        queue.offer( beginWord );
        visited.add( beginWord );
        
        while( !queue.isEmpty() ){
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                for( String next : getNextString( curr, visited, wordList ) ){
                    if(next.equals(endWord)){
                        return distance;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }            
        }
        
        return 0;
    }

    private static List<String> getNextString(String curr, Set<String> visited, Set<String> wordList) {
        
        List<String> ret = new ArrayList<String>();
        
        for( int i = 0; i < curr.length(); i++ ){
            for( char c = 'a'; c <= 'z'; c++ ){
                char[] cArr = curr.toCharArray();
                cArr[i] = c;
                String tmp = new String(cArr);
                if( !tmp.equals(curr) && !visited.contains(tmp) && wordList.contains(tmp)){
                    ret.add(tmp);
                }
            }
        }
//        System.out.println(ret.toString());
        return ret;
    }
    
    public static void main(String[] args) {
        
//        String test = "catsanddog";
//        
        Set<String> dict = new HashSet<String>();
//                
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
//        
        int res = ladderLength("hit", "cog" , dict);
        
        System.out.println(res);

        
        
    }
}
