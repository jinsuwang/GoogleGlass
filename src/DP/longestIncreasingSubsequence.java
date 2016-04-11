/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class longestIncreasingSubsequence {
    
    public static int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        if( nums == null || nums.length == 0) return 0;

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            cache[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    cache[i] = Math.max(cache[i], cache[j]+1);  
                    max = Math.max(max, cache[i]);  
                }
            }
        }
//        System.out.println( Arrays.toString(cache) );
        return max;
    }
        
        
    public static void main(String[] args) {
//        int[] test = {5,4,3,2,1,6};
//        System.out.println(lengthOfLIS( test ));

        int i = 1;
        i = i << 2;
        System.out.println(i);
        
        
    }
}
