/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class MissingNumber {
    
    public static int missingNumber(int[] nums) {
     
        int n = nums.length, i = 0;
        while (i<n) {
            while (nums[i]!=i && nums[i]<n) {
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
            ++i;
        }
        for (i=0; i<n; ++i)
            if (nums[i]!=i) return i;
        return n;
    }
    
    public static void main(String[] args) {
        int[] test = { 1 ,3, 0, 2 };
        System.out.println(missingNumber(test));
    }
}
