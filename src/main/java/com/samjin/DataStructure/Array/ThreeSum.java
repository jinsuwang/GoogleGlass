  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Sam
 */
public class ThreeSum {
    
    
    public static  List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
                return sol;
        }
        Arrays.sort(nums);
        
        for( int i = 0; i < nums.length-2; i++ ){
            
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue; // to skip duplicate numbers; e.g [0,0,0,0]
            }
            
            int left = i+1;
            int right = nums.length - 1;
            while( left < right ){
                
                int total = nums[i] + nums[left] + nums[right];
                
                if( total == 0 ){
                    
                    List<Integer> curr = new ArrayList<Integer>();

                    curr.add(nums[i]);
                    curr.add(nums[left]);
                    curr.add(nums[right]);
                    sol.add(curr);
                    left++;
                    right--;
                    
                    while( left < right && nums[left] == nums[left-1] ){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) { // to skip duplicates
                        right--;
                    }
                }
                
                else if( total < 0 ){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return sol;
    }
    
    public static void main(String[] args) {
        int[] test = { 1,2,-2,-1 };
        List<List<Integer>> sol = threeSum( test );
        for( List<Integer> e : sol ){
            System.out.println(e);
        }
    }
}
