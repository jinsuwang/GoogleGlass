/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Sam
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        Set<Integer> set = new HashSet<Integer>();
        for( int e : nums ){
            if( set.contains(e)) return true;
            set.add(e);
        }
        return false;
    }
    
    // Follow up
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < nums.length; i++ ){
            if( map.containsKey(nums[i])){
                if(  Math.abs(i-map.get(nums[i])) <= k ) return true;
            } 
            map.put( nums[i], i );
        }
        return false;
    }
     
    //Follow up 2.  | nums[i] - nums[j] | < t. | i - j | < k.
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( nums == null || nums.length <= 1 || t < 0 ) return false;
        
        TreeSet<Integer> set = new TreeSet<Integer>();   
        
        for( int i = 0; i < nums.length; i++ ){
            Integer floor = set.floor( nums[i] + t);
            Integer ceiling = set.ceiling( nums[i] - t );
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if( i >= k ){
                set.remove(nums[i-k]);
            }
        } 
        return false;
    }
    
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();

        set.add(1);
        set.add(4);
        set.add(5);
        
        System.out.println(set.floor(0));
        

    }
}
