/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class WiggleSort {
    
    
    public static void wiggleSort(int[] nums) {
        
        
        if( nums == null || nums.length < 2 ) return;
        
        
        for( int i = 0; i < nums.length -1; i++ ){
            
            if( i%2 == 0 && nums[i] > nums[i+1] ){
                swap( nums, i, i+1 );
            }
            if( i%2 == 1 && nums[i] < nums[i+1]){
                swap( nums, i, i+1 );
            }
//            System.out.println(Arrays.toString(nums));
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] test = new int[]{ 3,5,2,1,6,4 };
        wiggleSort( test );
        System.out.println(Arrays.toString(test));
    }
    
}
