/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Sam
 */
public class ReconstructItinerary {
    
    
    private static int total;
    // DFS
    public static List<String> findItinerary(String[][] tickets) {
        
        Map<String, List<String>> map = GenerateGraph( tickets ); 
        List<String> curr = new ArrayList<String>();
//        Set<String> v = new HashSet<String>();
        total = tickets.length;
        curr.add("JFK");
        dfs( map, curr, "JFK"); 
        return curr;
    }
    
    // Stack( DFS )
        
    public static List<String> findItinerary2( String[][] tickets ){
        Map<String, List<String>> graph = GenerateGraph( tickets ); 
        Stack<String> stack = new Stack<String>();
        List<String> sol = new ArrayList<String>();
        stack.push("JFK");
        
        while( !stack.isEmpty() ){
            while( graph.containsKey(stack.peek()) && !graph.get( stack.peek()).isEmpty() ){
                stack.push( graph.get(stack.peek()).remove(0) );
            }
            sol.add(0, stack.pop());
        }
        return sol;
    }
    
    // backTracing
    public static List<String> findItinerary3 (String[][] tickets) {
        Map<String, List<String>> graph = GenerateGraph( tickets ); 
        List<String> sol = new ArrayList<String>();
        backtracing(sol, "JFK", graph);
        return sol;
    }

    private static void backtracing(List<String> sol, String curr, Map<String, List<String>> graph) {
        while( graph.containsKey(curr) && !graph.get(curr).isEmpty()){
            String des = graph.get(curr).remove(0);
            backtracing( sol, des, graph );
        }
        sol.add(0, curr );
    }
    
    
    
    
    private static Map<String, List<String>> GenerateGraph(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<String,List<String>>();
        for( String[] e : tickets ){
            if( !map.containsKey(e[0]) ){
                map.put( e[0], new ArrayList<String>() );
            }
            List<String> tmp = map.get( e[0] );
            tmp.add( e[1] );
            map.put(e[0], tmp );
        }
        for( List<String> e : map.values() ){
            Collections.sort(e);
        }
        return map;
    }    

    private static void dfs(Map<String, List<String>> map, List<String> curr, String start) {
        
        System.out.println( curr.toString() );
        
        if( curr.size() == total+1 ){
            System.out.println("find result: "+curr.toString());
        }
        
        List<String> des = map.get( start );
        if( des != null ){
            for( String to : des ){
                if( !curr.contains(to)){
                    curr.add(to);
                    dfs( map, curr, to );
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        
        String[][] itinerary = {
            {"MUC", "LHR"}, 
            {"JFK", "MUC"}, 
            {"SFO", "SJC"}, 
            {"LHR", "SFO"}
        };
        
        String[][] itinerary2 = {
            {"JFK","SFO"},
            {"JFK","ATL"},
            {"SFO","ATL"},
            {"ATL","JFK"},
            {"ATL","SFO"}
        };
        
        List<String> sol = findItinerary2(itinerary2);
        System.out.println(sol.toString());
    }

}
