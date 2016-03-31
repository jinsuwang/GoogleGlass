/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

/**
 *
 * @author Sam
 */
public class KthLargestElementInAnArray {
    
    public int kthLargestElement( int k, int[] nums ){
        if( nums == null || nums.length == 0 ) return 0;
        if( k <= 0 ) return 0;
        return helper(nums, 0, nums.length-1, nums.length-k+1);
        
    }

    private int helper(int[] nums, int l, int r, int k){
        if( l == r ) return nums[l];
        int position = partition( nums, l, r);
        if( position + 1 == k ){
            return nums[position];
        }else if( position + 1 < k ){ // not enough, search right.
            return helper(nums, position+1, r , k); 
        }else{
            return helper(nums, l , position-1, k);
        }
    }

    private int partition(int[] nums, int l, int r) {
        if( l == r ){
            return l;
        }   
        int left = l, right = r;
        int curr = nums[left];
        while(left < right ){
            // find first element smaller curr from right
            while( left < right && nums[right] >= curr) right--;
            nums[left] = nums[right];
            while( left < right && nums[left] <= curr ) left++;
            nums[right] = nums[left];
        }
        nums[left] = curr;
        return left;
        
    }
}
