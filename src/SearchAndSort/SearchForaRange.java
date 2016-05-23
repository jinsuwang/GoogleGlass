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
public class SearchForaRange {
    
    public static int[] searchRange(int[] nums, int target) {
        
        if( nums == null || nums.length < 1 || 
                target < nums[0] || target > nums[nums.length-1] )
            return new int[]{ -1,-1 };
        
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[2];
        
        while( nums[left] < nums[right] ){   
            int mid = left + ( right - left ) / 2;
            
            if( target > nums[mid] ){
                left = mid+1;
            }else if( target < nums[mid] ){
                right = mid-1;
            }else{ 
                if( nums[left] == nums[mid] ){
                    right--;
                }else{
                    left++;
                }
            }
        }    
                
        if(nums[left] == nums[right] && nums[left]== target) {
            res[0] = left;
            res[1] = right;        
        }

        return res;
    }
    
    public static void main(String[] args) {
        
        int[] test = { 5, 7, 7, 8, 8, 10 };
        int[] sol = searchRange( test, 8 );
        System.out.println(Arrays.toString(sol));
        
    }
}
