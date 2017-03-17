/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Company.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for( int i = 0; i < nums.length; i++ ){
            if( map.containsKey( nums[i]) ){
                return new int[]{ map.get(nums[i]), i };
            }else{
                map.put( target-nums[i], i );
            }
        }
        return new int[]{0,0};
    }
    
    public static void main(String[] args) {
        int[] test = { 2, 7, 11, 15 };
        System.out.println( Arrays.toString( twoSum(test,9) ));
    }
}
