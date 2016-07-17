/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WorkBreak {


    public boolean wordBreak(String s, Set<String> wordDict) {
        
        int maxLen = getMaxLength( wordDict );
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for( int i = 1; i <= s.length(); i++ ){
            for( int j = 1; j <= maxLen && j <= i  ; j++ ){
                String part =  s.substring(i-j, i);
                if( wordDict.contains(part) && dp[i-j] ){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
    
    
    /* 
        Word Break II
    */
    public static List<List<String>> wordBreakDFS(String s, Set<String> dict) {
        List<List<String>> sol = new ArrayList<List<String>>();
        List<String> curr = new ArrayList<String>();
        dfs( sol, curr, s, dict, 0 );
        return sol;
    }
    
    private static void dfs(List<List<String>> sol, List<String> curr, String s, Set<String> dict, int index) {
        
        if( index == s.length() ){
            sol.add( new ArrayList<String>( curr ));
            return;
        }
        for( int i = index+1; i <= s.length(); i++ ){
            String part = s.substring(index, i);
            if( dict.contains(part) ){
                curr.add( part );
                dfs( sol, curr, s , dict, i );
                curr.remove( curr.size()-1 );
            }
        }
    }
    
    
    public static List<String> wordBreakWithMemory( String s, Set<String> dict ){
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        return wordBreakHelper( s, dict, map );
    }
    
    private static List<String> wordBreakHelper(String s, Set<String> dict, Map<String, List<String>> map) {
        
        if( map.containsKey(s) ){
            return map.get(s);
        }
        
        List<String> sol = new ArrayList<String>();
        
        for( int i = 1; i <= s.length(); i++ ){
            
            String part = s.substring( 0, i );
            
            if( dict.contains(part) ){
                
                if( i == s.length() ){
                    sol.add(part);
                }
                
                String rest = s.substring( i );
                
                List<String> tmp = wordBreakHelper( rest, dict, map );
                
                
                for( String e : tmp ){
                    e = part + " " + e;
                    sol.add(e);
                }                
//                System.out.println("part: " + part + " tmp: " + tmp + " sol: " + sol + " map: " + map);
            }
        }
//        System.out.println(sol);
        map.put(s, sol);
        return sol;
    }
    
    
    public static List<List<String>> wordBreakDFSMomoeryTemplate(String s, Set<String> dict) {
        
        if( s == null || s.length() == 0 || dict == null ){
            return null;
        }
        
        List<List<String>> ret = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        boolean canBreak[] = new boolean[s.length()+1];
        Arrays.fill(canBreak, true);
        dfs( s, dict, path, ret, 0, canBreak);
        return ret;
        
    }
    
    private static void dfs(String s, Set<String> dict, List<String> path, List<List<String>> ret, int index, boolean[] canBreak) {
        
        if(index == s.length()){
            ret.add(new ArrayList<String>(path));
            return;
        }
        
        if( !canBreak[index] ) return;
        
        for( int i = index; i < s.length(); i++ ){
            String left = s.substring(index, i+1);
            if( !dict.contains(left) || !canBreak[i+1] ) continue;
            
            path.add(left);            
            
            int beforeChange = ret.size();
            
            dfs(s, dict, path, ret, i+1, canBreak);
           
            if( ret.size() == beforeChange ) canBreak[i+1] = false;
            
            path.remove(path.size()-1);
            
        }
        
    }
    
    
    
    public static void main(String[] args) {
        
        String test = "catsanddog";
        Set<String> dict = new HashSet<String>();
        
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        List<String> sol = wordBreakWithMemory(test, dict);
        
        

        
        for( String e : sol ){
            System.out.println(e.toString());
        }        
    }
}
