/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class GraphValidTree {
    
    // BFS solution
    public static boolean validTree(int n, int[][] edges) {
        // no loop indirect graph, edge is always 1 less than node
        if(edges.length != n-1){
            return false;
        }
        
        List<Set<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(i,new HashSet<Integer>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }// done with building graph

        for( Set<Integer> e : graph ){
            System.out.println(e);
        } 
        
        
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        // rules for updating the visited set
        // each time we offer a vertex to the queue, add the vertex to the visited set
        q.offer(0);
        visited.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int next : graph.get(curr)){
                if(visited.contains(next))  return false;
                q.offer(next);
                visited.add(next);
                // visited next from curr, next->curr and next<-curr are the same
                // when one path found
                // we have to delete curr in the neighbor list of next
                graph.get(next).remove((Integer)curr);
            }
        }

        // checks if there is an isolated island
        return visited.size()==n;
    }
    
    
    // union find solution
    public static boolean validTree2(int n, int[][] edges) {
        if( n != edges.length+1 ) return false;
        
        int[] uf = new int[n];
        
        for( int i = 0; i < n; i++ ) uf[i] = i;
        
        for( int[] edge : edges ){
            union( edge[0], edge[1], uf );
        }
        
        System.out.println( Arrays.toString(uf) );
        for( int i=0; i<n-1;i++){
            if(  uf[i] != uf[i+1] ) return false;
        }
        return true;
    }

    
    private static void union(int p, int q, int[] uf) {
        int pid = uf[p];
        int qid = uf[q];
        
        for( int i=0; i < uf.length; i++ ){
            if( uf[i] == pid ) uf[i] = qid;
        }
    }
    
    
    public static void main(String[] args) {
        int[][] edges = { {0,1},{0,2},{0,3},{1,4} };
        int[][] edges2 = { {0,1},{1,2},{2,3},{1,3},{1,4} };

        System.out.println(validTree2(5, edges2 ));
    }
}
