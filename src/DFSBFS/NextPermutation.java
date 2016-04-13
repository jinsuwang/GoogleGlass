/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class NextPermutation {
    
    public static void nextPermutation(int[] nums) {
        
        int dIndex = -1;
        
        for( int i = nums.length-1; i >= 1; i-- ){
            if(  nums[i-1] < nums[i] ){
                dIndex = i-1;
                break;
            }
        }
        
        
        if( dIndex != -1 ){
            for( int i = nums.length-1; i > dIndex; i--){
                if( nums[i] >  nums[dIndex] ){
                    swap( nums, dIndex, i);
                    break;
                }
            }
        }
        

        int left = dIndex+1;
        int right = nums.length - 1;
        while( left < right ){
            swap(nums, left , right);
            left++;
            right--;
        }
                
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] test = { 1,3,2 };
        nextPermutation( test );
        System.out.println( Arrays.toString(test) );
    }
}
