/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Graph.UnionFind;

/**
 *
 * @author Sam
 */
public class QuickUnionUF {
    
    private int[] nodes;
    
    QuickUnionUF(int n){
        nodes = new int[n];
        for( int i=0;i<n;i++) nodes[i]=i;
    }
    
    private int root(int x){
        while( x != nodes[x] ) x = nodes[x];
        return x;
    }
    
    public boolean connected( int p, int q){
        return root(p) == root(q);
    }
    
    public void union( int p, int q){
        int i = root(p);
        int j = root(q);
        nodes[i] = j;
    }
}
