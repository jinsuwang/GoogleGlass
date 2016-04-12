package TwoPointer;

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

    public enum Color {
        RED(0),
        GREEN(1),
        BLUE(2);
        private int value;
        Color(int x){
            this.value = x;
        }
    }
    
    public static void sortColors( Color[] colors ){
        if( colors == null || colors.length <= 1 ) return;
        int indexRed = 0;
        int indexBlue = colors.length - 1 ;
        int curr = 0; 
        while( curr <= indexBlue ){
            if( colors[curr] == Color.RED ){
                swap( colors, curr++, indexRed++ );
            }else if( colors[curr] == Color.BLUE ){
                swap( colors, curr, indexBlue-- );
            }else{
                curr++;
            }
        }
    }
    
    private static void swap(Color[] colors, int i, int j) {
        Color tmp = colors[i];
        colors[i] = colors[j];
        colors[j] = tmp;
    }
   
    
        
    public static void main(String[] args) {
        Color[] colors = new Color[]{ Color.GREEN, Color.RED, Color.BLUE, Color.BLUE, Color.GREEN};
        for( int i = 0; i < colors.length; i++ ){
            System.out.print( colors[i].value + "\t");
        }
        System.out.println("\n");
        sortColors( colors );
        for( int i = 0; i < colors.length; i++ ){
            System.out.print( colors[i].value + "\t");
        }
        
    }
  
            
            
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
}
