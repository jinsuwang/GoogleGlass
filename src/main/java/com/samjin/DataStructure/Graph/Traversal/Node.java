/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Graph.Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Node {
    
    
    public String name;
    
    public List<Edge> edges;
    
    public boolean visited; 
    
    Node( String name ){
        this.name = name;
        edges = new ArrayList<Edge>();
    }
    
    public void addEdge(Edge e){
        this.edges.add(e);
    }
    
    public String getName(){
        return name;
    }
    
}
