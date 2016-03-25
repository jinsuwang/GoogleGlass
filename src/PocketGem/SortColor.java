package PocketGem;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class SortColor {
    
    public static void sortColors(int[] nums) {
        if( nums == null || nums.length < 2) return;
        int index_0 = 0;
        int index_2 = nums.length-1;
        int i=0;
        while( i <= index_2 ){
            System.out.println(Arrays.toString(nums));
            if( nums[i] == 2){ 
                swap(nums, i, index_2);
                index_2--;
            }else if( nums[i] == 0 ){
                swap(nums, i, index_0);
                index_0++;
                i++;
            }else{
                i++;
            }
        }
    }
    private static void swap(int[] nums, int index_0, int index_2) {
        int tmp = nums[index_2];
        nums[index_2] = nums[index_0];
        nums[index_0] = tmp;
    }
    
    /*
       N, bucket sort.
    */
    // Solution 2: inplace, O(n) 
    public void sortKColors(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {    
                    // 1. There is a number in the bucket, 
                    // Store the number in the bucket in position i;
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else if (colors[num - 1] <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    colors[num - 1]--;
                    // delete the A[i];
                    colors[i] = 0;
                }
            }
        }
        
        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];
            
            // Empty number.
            if (cnt == 0) {
                continue;
            }
                                
            while (cnt > 0) {
                colors[index--] = i + 1;
                cnt--;
            }
        }
    }
    

    
    
    
    
    public static void main(String[] args) {
        int[] test = { 1,2,3,4,5,6,2,0 };
        int[] test2 = { 0,0 };

//        sortColors( test );
        int a = 5;
        while( a >= 0 )
            System.out.println(test[a--]);
    }
}
