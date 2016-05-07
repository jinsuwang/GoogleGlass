/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class SlidingWindowMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        if ( nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int[] sol = new int[len-k+1];
        
        for(int i=0;i<sol.length;i++){
            sol[i] = findMax( nums, i, k );
        }
        return sol;
    }

    private static int findMax(int[] nums, int i, int k) {
        int max = Integer.MIN_VALUE;
        for( int j = 0; j < k; j++ ){
            max = Math.max( nums[i+j],max );
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] test = {1,3,-1,-3,5,3,6,7};
        int[] sol = maxSlidingWindow(test, 3);
        System.out.println(Arrays.toString(sol));
        
    }
    
}
