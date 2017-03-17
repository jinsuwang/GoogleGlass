/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Graph.Traversal;

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
public class Graph {
    
    List<Node> nodes;
    
    Graph(){
        nodes = new ArrayList<Node>();
    }
    
    public void addNodes( Node n){
        nodes.add(n);
    }
    
    
    public List<List<String>> getAllPathDFS( Node n1, Node n2 ){
        Set<Node> visited = new HashSet<Node>();
        List<Node> curr = new ArrayList<Node>();
        List<List<Node>> sol = new ArrayList<List<Node>>();
        List<List<String>> paths = new ArrayList<List<String>>();
        dfs( sol, visited, curr, n1, n2 );
        
        for(List<Node> path : sol){
            List<String> str = new ArrayList<String>();
            for( int i = 0; i < path.size(); i++ ){
                str.add( path.get(i).name + " " );
            }
            paths.add(str);
        }
        return paths;
    }
    
    

    private void dfs( List<List<Node>> sol, Set<Node> visited, List<Node> curr, Node n1, Node n2) {
       
        if( n1 == n2 ){ // find des
            visited.add(n1);
            curr.add(n1);
            sol.add( new ArrayList<>( curr ));
            visited.remove(n1);
            curr.remove(n1);
            return;
        }
        
        for( Edge e : n1.edges ){
            if( ! visited.contains(e.to)){
                visited.add(n1);
                curr.add(n1);
                dfs(sol, visited, curr, e.to, n2 );
                visited.remove(n1);
                curr.remove(n1);
            }
        }
        
    }
    
    
    
    public boolean hasPath ( Node n1, Node n2 ){
        Queue<Node> queue = new LinkedList<Node>();
        Set<Node> visited = new HashSet<Node>();
        queue.offer(n1);
        visited.add(n1);
        while( !queue.isEmpty() ){
            Node curr = queue.poll();
            System.out.println("Visiting " + curr.name);
            if( curr == n2 ){
                System.out.println("Find It ");
                return true;
            }
            for( Edge e : curr.edges ){     
                if( !visited.contains(e.to) ){
                    visited.add(e.to);
                    queue.offer( e.to );
                }
            } 
        }
        return false;
    }
}
