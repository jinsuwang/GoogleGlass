package com.samjin.DataStructure.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if( node == null ) return null;
        List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
        // init
        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        
        int start = 0;
        while( start < nodes.size()){
            UndirectedGraphNode head = nodes.get(start++);
            for( int i=0 ; i < head.neighbors.size(); i++ ){
                UndirectedGraphNode neighbor = head.neighbors.get(i);
                // get 
                if( !map.containsKey(neighbor) ){
                    nodes.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        
        for( int i = 0; i < nodes.size(); i++ ){
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            List<UndirectedGraphNode> oldNodeNeibors = nodes.get(i).neighbors;
            for( int j = 0; j < oldNodeNeibors.size(); j++ ){
                newNode.neighbors.add(  map.get(oldNodeNeibors.get(j)) );
            } 
        }
        return map.get(node);
    }
}
