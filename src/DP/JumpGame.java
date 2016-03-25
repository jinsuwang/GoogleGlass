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
public class JumpGame {
    
    public static boolean canJump(int[] nums) {
//        if( nums == null || nums.length == 0 ) return false; 
//        boolean[] cache = new boolean[nums.length+1];
//        cache[0] = true;
//        for( int i = 0; i < nums.length; i++ ){
//            int j = 1;
//            while( j <= nums[i] && i + j <= nums.length ){
//                cache[ i+j ] = cache[i] | cache[i+j];
//                j++;
//                if( i + j == nums.length && cache[i+j]) return cache[i+j] ;
////                System.out.println( Arrays.toString(cache) );
//            }
//        }
//        return cache[nums.length];
        if (nums == null || nums.length == 0) {
            return false;
        }
        int farthest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= farthest && nums[i] + i >= farthest) {
                farthest = nums[i] + i;
            }
        }
        return farthest >= nums.length - 1;
    }
    public static void main(String[] args) {
        int[] test = { 3,2,1,0,4 };
        System.out.println(canJump( test ));
    }
    
}
