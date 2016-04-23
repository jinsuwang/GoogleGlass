/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Subset {
    
    public static List<List<Integer>> subsets(int[] nums) {    
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs( sol, nums, curr, 0);   
        return sol; 
    }

    private static void dfs(List<List<Integer>> sol, int[] nums, List<Integer> curr, int index) {
        sol.add( new ArrayList( curr ));
        for( int i = index; i < nums.length; i++ ){
            if ( i != index && nums[i] == nums[i - 1]) {
                continue;
            }  
            curr.add( nums[i]);
            dfs( sol, nums, curr, i+1 );
            curr.remove(curr.size()-1 );
        }
    }
    
    
    /* Follow Up: With Duplication */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs( sol, nums, curr, 0);   
        return sol; 
    } 
    
    public static void main(String[] args) {
        int[] test = { 1,2,2 };
        List<List<Integer>> sol = subsets(test);
        for( List<Integer> x : sol ){
            System.out.println(x.toString());
        }
    }
}
