/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Tricky;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class LongestConsecutive {
    
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<Integer>();
        for( int i = 0; i < nums.length; i++ ){
            set.add(nums[i]);
        }
        
        int longest = 0;
        
        for( int i = 0; i < nums.length; i++ ){
            int down = nums[i] - 1;
            while( set.contains(down)){
                set.remove(i);
                down--;
            }
            int up = nums[i] + 1;
            while( set.contains(up) ){
                set.remove(up);
                up++;
            }
            longest = Math.max( longest, up - down - 1);
        }
        return longest;
    }
}
