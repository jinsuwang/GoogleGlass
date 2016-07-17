/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class KthLargestElementInAnArray {
    
    
    public static int findKthLargest( int[] nums, int k ){
        
        if(nums == null || k <= 0 || k > nums.length && nums == null ){
            return 0;
        }
        return findKth( nums, 0, nums.length-1,  nums.length-k+1 );
    }

    private static int findKth(int[] nums, int left , int right, int k) {
        
        int i = partition( nums, left, right );
                
        if( i + 1 == k ){
            return nums[i];
        }else if( i + 1 < k ){ // search right.
            return findKth( nums, i + 1, right, k);
        }else{
            return findKth( nums, left, i - 1 , k );
        }
    }

    private static int partition(int[] nums, int l, int r) {
        
        
        if( l == r ) return l;
        int left = l, right = r;
        int curr = nums[left];
            
        while( left < right ){       
            while( left < right && nums[right] >= curr ) right--;
            nums[left] = nums[right];

            while( left < right && nums[left] <= curr ) left++;
            nums[right] = nums[left];

        }
        nums[left] = curr;

        return left;
    }
    
    public static void main(String[] args) {
        int[] test = { 3,2,6,5,1 };
        System.out.println(findKthLargest( test, 2 ));
    }
}
