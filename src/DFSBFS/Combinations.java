/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Combinations {
    
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        dfs( sol, new ArrayList<Integer>(), n, k, 1);
        return sol;
    }

    private static void dfs(List<List<Integer>> sol, ArrayList<Integer> curr, int n, int k, int index) {
        if( k == 0 ){
            sol.add( new ArrayList<Integer>( curr) );
            return;
        }
        for( int i = index; i <= n; i++ ){
            curr.add(i);
            dfs( sol, curr, n, k-1, i+1 );
            curr.remove(curr.size()-1);
        }
    }
    
    public static void main(String[] args) {
        List<List<Integer>> sol = combine( 4,2 );
        for( List<Integer> e : sol ){
            System.out.println(e);
        }
    }
}
