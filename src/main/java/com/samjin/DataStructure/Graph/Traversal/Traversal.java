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
public class Traversal {
    
    public static void main(String[] args) {
        
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        
        //ab
        Edge ab = new Edge(a,b,8);
        Edge ba = new Edge(b,a,8);
        a.addEdge(ab);
        b.addEdge(ba);
        
        //ac
        Edge ac = new Edge(a,c,4);
        Edge ca = new Edge(c,a,4);
        a.addEdge(ac);
        c.addEdge(ca);
        
        //ad
        Edge ad = new Edge(a,d,6);
        Edge da = new Edge(d,a,6);
        a.addEdge(ad);
        d.addEdge(da);
        
        //de
        Edge de = new Edge(d,e,6);
        Edge ed = new Edge(e,d,6);
        d.addEdge(de);
        e.addEdge(ed);
        
        //ce
        Edge ce = new Edge(c,e,7);
        Edge ec = new Edge(e,c,7);
        c.addEdge(ce);
        e.addEdge(ec);
        
        //be
        Edge be = new Edge(b,e,10);
        Edge eb = new Edge(e,b,10);
        b.addEdge(be);
        e.addEdge(eb);
        
        //bc
        Edge bc = new Edge(b,c,5);
        Edge cb = new Edge(c,b,5);
        b.addEdge(bc);
        c.addEdge(cb);
        
        //cd
        Edge cd = new Edge(c,d,3);
        Edge dc = new Edge(d,c,3);
        c.addEdge(cd);
        d.addEdge(dc);
        
        Graph graph = new Graph();
        graph.addNodes(a);
        graph.addNodes(b);
        graph.addNodes(c);
        graph.addNodes(d);
        graph.addNodes(e);
        
//        List<List<String>> paths =  graph.getAllPathDFS(a, e);
//        for( List<String> path : paths ){
//            System.out.println(path.toString());
//        }
        
//        System.out.println( graph.hasPath(b, e) );
        List<String> l = new ArrayList<String>();
        System.out.println(l.toString());
        l.remove("hello");
    }
    
}
