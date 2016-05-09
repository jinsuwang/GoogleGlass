/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
    public static int countComponents(int n, int[][] edges) {
        
        Integer[] uf = new Integer[n];
        int count = 1;
        
        for( int i = 0; i < n; i++ ) uf[i] = i;
        
        for( int[] edge : edges ){
            union( edge[0], edge[1], uf );
        }
        System.out.println( Arrays.toString(uf) );
        
        Set<Integer> mySet = new HashSet<Integer>( Arrays.asList(uf) );
//        Set<Integer> sol = new HashSet( Arrays.asList(uf) );
//        System.out.println(sol.toString());
        return mySet.size();
    }

    
    private static void union(int p, int q, Integer[] uf) {
        int pid = uf[p];
        int qid = uf[q];
        
        for( int i=0; i < uf.length; i++ ){
            if( uf[i] == pid ) uf[i] = qid;
        }
    }
    
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 4}, {2, 3}};
        System.out.println( countComponents(5,edges));
    }
}
