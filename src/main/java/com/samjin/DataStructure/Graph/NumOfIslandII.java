/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sam
 */
public class NumOfIslandII {
    
    
    static int[][] dirs = { {0,1},{1,0},{-1,0},{0,-1} };
    
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        
        List<Integer> sol = new ArrayList<Integer>();
        
        if( m <= 0 || n <= 0 ) return sol;
        int[] roots = new int[m*n];
        int count = 0;
        
        Arrays.fill( roots, -1);
        
        for( int[] p :  positions ){
            
            int root = n * p[0] + p[1];
            roots[root] = root;
            count++;
            
//            System.out.println(Arrays.toString(roots));
            
            for(int[] dir : dirs ){
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                
                int nb = n * x + y;
                
                // out of boundary,  
                if( x < 0 || x >= m || y < 0 || y >= n  || roots[nb] == -1 ) continue;
                
                int rootNb = findIsland( roots, nb );
                if( root != rootNb ){ // if neighbor is another island, union two islands
                    roots[root] = rootNb;
                    root = rootNb;
                    count--;
                }
            }
            sol.add(count);
        }
        return sol;
    }

    private static int findIsland(int[] roots, int id ) {
        while( id != roots[id] ){
            roots[id] = roots[roots[id]]; // ptah compression
            id = roots[id];
        }
        return id;
    }
    
    public static void main(String[] args) {
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        List<Integer> sol = numIslands2( 3, 3, positions );
        System.out.println(sol.toString());
    }
}
