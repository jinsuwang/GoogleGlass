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
public class Permutation {
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        dfs( sol, used, curr,  nums );
        return sol;
    }

    private static void dfs(List<List<Integer>> sol, boolean[] used, List<Integer> curr, int[] nums) {
        if( curr.size() == nums.length  ){
            sol.add(new ArrayList<Integer>( curr ));
            return;
        }
        for( int i = 0; i < nums.length; i++ ){
            if( used[i] == true ) continue;
            used[i] = true;
            curr.add( nums[i] );
            dfs(sol, used, curr, nums);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }    
    
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> sol = permute(a);
        for( List<Integer> e : sol ){
            System.out.println(e.toString());
        }
    }
}
