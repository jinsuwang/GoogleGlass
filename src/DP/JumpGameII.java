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
public class JumpGameII {
    
    public static int jump(int[] nums) {
        if( nums == null || nums.length == 0 ) return -1; 
        int steps = 0, prev = 0, curr = 0; 
        for( int i = 0; i < nums.length; i++ ){
            if( i > prev ){
                steps++;
                prev = curr;
            } 
            curr = Math.max(prev, nums[i]+i);
        }
        return steps;
    }
    public static void main(String[] args) {
        int[] test = { 2, 1 };
        System.out.println(jump(test));
    }
    
}
