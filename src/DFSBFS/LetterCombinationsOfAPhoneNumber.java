/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class LetterCombinationsOfAPhoneNumber {
    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return ret;
        }
        Map<Character, char[]> map = new HashMap<Character,char[]>();
        
        map.put( '0',  new char[]{ } );
        map.put( '1',  new char[]{ });
        map.put( '2', "abc".toCharArray());
        map.put( '3', "def".toCharArray());
        map.put( '4', "ghi".toCharArray());
        map.put( '5', "jkl".toCharArray());
        map.put( '6', "mno".toCharArray());
        map.put( '7', "pqrs".toCharArray());
        map.put( '8', "tuv".toCharArray());
        map.put( '9', "wxyz".toCharArray());   
        
        StringBuilder sb = new StringBuilder();
        dfs(digits, map, sb, ret);
        return ret;
    }
    
    private static void dfs(String digits, Map<Character, char[]> map, StringBuilder sb, List<String> ret) {
        if( sb.length() == digits.length() ){
            ret.add(sb.toString());
            return;
        }else{
            for( char c : map.get(digits.charAt(sb.length()))){
                sb.append(c);
                dfs(digits, map, sb, ret );
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    
    private static List<String> letterCombinationsBFS( String digits ){
        List<String> ret = new ArrayList<String>();
        if (digits == null || digits.equals("")) {
            return ret;
        }
        Map<Character, char[]> map = new HashMap<Character,char[]>();   
        map.put( '0',  new char[]{ } );
        map.put( '1',  new char[]{ });
        map.put( '2', "abc".toCharArray());
        map.put( '3', "def".toCharArray());
        map.put( '4', "ghi".toCharArray());
        map.put( '5', "jkl".toCharArray());
        map.put( '6', "mno".toCharArray());
        map.put( '7', "pqrs".toCharArray());
        map.put( '8', "tuv".toCharArray());
        map.put( '9', "wxyz".toCharArray());   
        
        // start BFS.
        List<String> queue = new LinkedList<String>();
        queue.add(""); // like root node.
        for( int i = 0; i < digits.length(); i++ ){
            char[] tmp = map.get( digits.charAt(i) );
            int currSize = queue.size();
            for( int j = 0; j < currSize; j++ ){
                String curr = queue.remove(0);
                System.out.println(curr);
                for( char c : tmp ){
                    queue.add( curr + c );
                }
            }
        }
        return queue;
    } 
    public static void main(String[] args) {     
        String test = "23";
        List<String> ret = letterCombinationsBFS(test);
        System.out.println(ret.toString());   
    }
}
