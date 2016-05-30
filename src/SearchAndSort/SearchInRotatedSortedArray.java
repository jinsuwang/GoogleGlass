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
public class SearchInRotatedSortedArray {
    
    public static int search(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while( left <= right ){
            int mid = left + ( right - left ) / 2;
            
            if( target == nums[mid] ) return mid;
            
            else if( nums[left] <= nums[mid] ){ // left is sorted.
                if( nums[mid] < target || target < nums[left] ){ // target in left part. 
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            
            else{  // right is sorted 
                if( target < nums[mid] || target > nums[right] ){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] test = { 3,4,5,1,2 };
        System.out.println( search(test, 1) );
    }
}
