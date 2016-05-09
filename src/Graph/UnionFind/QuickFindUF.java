/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.UnionFind;

/**
 * 
 * @author Sam
 */

public class QuickFindUF {
    
    /* Disjointed Set problem  */
    
    // quick find ( O(1) to find if to node is in same set )
    
    int[] nodes;
    
    QuickFindUF( int n ){
        nodes = new int[n];
        for( int i=0; i < n; i++ ){
            nodes[i] = i;
        }
    }
    
    public boolean connected( int p , int q){
        return nodes[p] == nodes[q];
    }
    
    public void union( int p, int q ){
        int pid = nodes[p];
        int qid = nodes[q];
        
        for( int i=0; i < nodes.length; i++ ){
            if( nodes[i] == pid) nodes[i] = qid;
        }
        
    }
    
    
    
}
