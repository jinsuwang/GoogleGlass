/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author Sam
 */
public class KthLargestElementInAnArray {
    
    public static int findKthLargest(  int[] nums, int k ){
        if( nums == null || nums.length == 0 ) return 0;
        if( k <= 0 ) return 0;
        return helper(nums, 0, nums.length-1, nums.length-k+1);
        
    }
    
    private static int helper(int[] nums, int l, int r, int k){
        if( l == r ) return nums[l];
        int position = partition2( nums, l, r);
        System.out.println(Arrays.toString(nums));
        if( position + 1 == k ){
            return nums[position];
        }else if( position + 1 < k ){ // not enough, search right.
            return helper(nums, position+1, r , k); 
        }else{
            return helper(nums, l , position-1, k);
        }
    }
        
    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
    
    
    private static int partition2(int[] arr, int left, int right) {
        int i = left;
        int j = right;
//        Random ran = new Random();
        // example, 5-10.
//        int pivotIndex = ran.nextInt(j-i+1)+i;
        int pivotIndex = left + ( right - left)/2;        
        int pivotValue = arr[pivotIndex];
        
        while( i <= j ){
            while( arr[i] < pivotValue ) i++;
            while( arr[j] > pivotValue ) j--;
            if( i <= j ) swap( arr, i++, j-- );
        }
        return i;
    }
    

    private static int partition(int[] nums, int l, int r) {
        if( l == r ){
            return l;
        }   
        int left = l, right = r;
        int curr = nums[left];
        while(left < right ){
            // find first element smaller curr from right
            while( left < right && nums[right] >= curr) right--;
            nums[left] = nums[right];
//            System.out.println("left " + left + " right " + right );
            
            while( left < right && nums[left] <= curr ) left++;
            //System.out.println("left " + left + " right " + right );
            nums[right] = nums[left];
        }
        nums[left] = curr;
        return left;   
    }
    
    public static void main(String[] args) {
        int[] test = { 3,2,6,5,1 };
//        int[] test = { 3,1,2,4 };
        System.out.println( findKthLargest( test,  2));
    }
}
