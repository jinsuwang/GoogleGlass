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
public class FindTheDuplicateNumber {
    public static int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for( int i = 1; i < nums.length; i++ ){
            if( nums[i] == nums[i-1] ){
                return nums[i];
            } 
        }
        return -1;
    }
    
    public static int findDuplicate( int[] nums ){
        int left = 0;
        int right = nums.length;
        
        while( left < right ){
            int mid = left + ( right - left )/2;
            int count = 0;
            for( int i=0; i < nums.length; i++){
                if( nums[i] < mid )
            }
        }
    }
    
    public static void main(String[] args) {
        int[] test = { 1,2,3,4,2 };
        System.out.println(findDuplicate(test));
    }
}
