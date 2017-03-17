/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

/**
 *
 * @author Sam
 */
public class TrappingRainWater {
    
    public static int trap(int[] A) {
        if (A == null) {
            return 0;
        }
        int max = 0;
        
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        
        // count the highest bar from the left to the current.
        for (int i = 0; i < len; i++) {
            left[i] = i == 0 ? A[i]: Math.max(left[i - 1], A[i]);
        }
        
        // count the highest bar from right to current.
        for (int i = len - 1; i >= 0; i--) {
            right[i] = i == len - 1 ? A[i]: Math.max(right[i + 1], A[i]);
        }
       
        // count the largest water which can contain.
        for (int i = 0; i < len; i++) {
            int height = Math.min(right[i], left[i]);
            if (height > A[i]) {
                max += height - A[i];
            }
        }
        
        return max;  
    }
    
    public static void main(String[] args) {
        int[] test = { 0,1,0,2,1,0,1,3,2,1,2,1 }; 
        trap(test);
    }
}
