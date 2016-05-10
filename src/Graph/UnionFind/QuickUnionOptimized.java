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
public class QuickUnionOptimized {
    
    int[] uf;
    int[] size;
    
    QuickUnionOptimized( int n ){
        uf = new int[n];
        for( int i = 0; i < n; i++ ){
            uf[i] = i;
            size[i] = 1;
        }
    }  
    
    private int root(int x){
        while( uf[x] != x ){
            uf[x] = uf[uf[x]];
            x = uf[x];
        }
        return x;
    }
    
    
    // compression tree
    public void union( int p, int q ){
        int i = root(p);
        int j = root(q);
        
        if( size[i] < size[j] ){  uf[i] = j; size[j] += size[i]; }
        else                   {  uf[j] = i; size[i] += size[j]; } 
    }
    
    
    
}
