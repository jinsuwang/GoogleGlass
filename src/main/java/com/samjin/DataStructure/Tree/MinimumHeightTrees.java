/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Sam
 */
public class MinimumHeightTrees {
    
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> graph = generateGraph(edges);  
        
        List<Integer> curr = new ArrayList<Integer>();
        List<Integer> sol = new ArrayList<Integer>();
        sol.add( Integer.MIN_VALUE );
//        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<n; i++ ){
            curr.add(i);
            dfs( sol, curr, graph );
        }
        
        
        
        return sol;   
    }
    
    private void dfs(List<Integer> sol, List<Integer> curr, Map<Integer, List<Integer>> graph) {

        
    }

    private Map<Integer, List<Integer>> generateGraph(int[][] edges) {
        
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        
        for( int[] edge : edges ){
            if( !graph.containsKey(edge[0]) ){
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(edge[1]);
                graph.put(edge[0], tmp);
            }else{
                List<Integer> tmp = graph.get(edge[0]);
                tmp.add( edge[1] );
                graph.put(edge[0], tmp);
            }
        }
        return graph;
    }
}
