/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WordBreakII {
    public static List<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<List<String>> sol = new ArrayList<List<String>>();
        List<String> curr = new ArrayList<String>();
        dfs2(s,dict,sol, curr, 0);
        return formatResult(sol);
    }

    
    private static void dfs2(String s, Set<String> dict, List<List<String>> sol,
            List<String> curr, int index) {
        
        if( index == s.length() ){
                sol.add( new ArrayList<String>(curr));
        }else{
            for( int i = index+1; i<= s.length();i++){
                String newString = s.substring(index, i);
                if( !dict.contains(newString)) continue;
                curr.add(newString);
                dfs2( s,dict, sol, curr, i );
                curr.remove( curr.size()-1 );
            }
        }
    }
    
    private static List<String> formatResult(List<List<String>> sol) {
        List<String> ret = new ArrayList<String>();
        for( List<String> ls : sol ){
            StringBuffer sb = new StringBuffer();
            for( int i = 0; i < ls.size(); i++){
                sb.append( ls.get(i));
                if(i != ls.size()-1){
                    sb.append(' ');
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }
    
    
    
    
    
    

    
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> set = new HashSet<String>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        
        List<String> ret = wordBreak(s, set);
        System.out.println(ret);
    }
}
