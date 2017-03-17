/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sam
 */
public class CombinationSum {
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }  
        // Sort to avoid duplicate solutions.
        Arrays.sort(candidates);   
        dfs(candidates, target, new ArrayList<Integer>(), ret, 0);
        return ret;
    }
    
    public static void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> ret, int index) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            ret.add(new ArrayList(path));
            return;
        }
        
        // i 的起始值是跟排列的最主要区别。因为与顺序无关，所以我们必须只能是升序，也就是说下一个取值只能是i本身
        // 或是i的下一个。
        // 但是排列的话，可以再取前同的。1, 2 与2 1是不同的排列，但是同一个组合
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            path.add(num);
            
            // 注意，最后的参数是i，不是index!!
            dfs(candidates, target - num, path, ret, i);
            path.remove(path.size() - 1);
        }
    }
    
    
    // Follow Up: Unique
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return ret;
        }  
        // Sort to avoid duplicate solutions.
        Arrays.sort(candidates);   
        dfsUnique(candidates, target, new ArrayList<Integer>(), ret, 0);
        return ret;
    }
    
    public static void dfsUnique(int[] candidates, int target, List<Integer> path, List<List<Integer>> ret, int index) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            ret.add(new ArrayList(path));
            return;
        }
        
        // i 的起始值是跟排列的最主要区别。因为与顺序无关，所以我们必须只能是升序，也就是说下一个取值只能是i本身
        // 或是i的下一个。
        // 但是排列的话，可以再取前同的。1, 2 与2 1是不同的排列，但是同一个组合
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
//            System.out.println("prev: " + prev);
            if( num == prev ) continue;
            prev = num;
            path.add(num);
            
            // 注意，最后的参数是i，不是index!!
            dfsUnique(candidates, target - num, path, ret, i+1);
            path.remove(path.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        
        List<List<Integer>> sol = combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        
        for( List<Integer> e : sol ){
            System.out.println(e);
        }
    }
    
}
