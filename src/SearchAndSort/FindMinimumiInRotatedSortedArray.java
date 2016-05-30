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
public class FindMinimumiInRotatedSortedArray {
    
    public static int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while( left < right ){
            
            int mid = left + ( right - left ) / 2;
            
            if( nums[mid] >= nums[left] && nums[right] >= nums[mid] ){ // no roatation 
                return nums[left];
            }
            
            if( left + 1 == right ){
                return nums[right];
            }
            
            if( nums[mid] > nums[left]){ // left is sorted
                left = mid; 
            }else{
                right = mid;
            }
        }     
        return nums[left];      
    }
    
    
    // follow up: allow duplication
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while( left < right ){
            
            int mid = left + ( right - left ) / 2;
            
//            if( nums[mid] >= nums[left] && nums[right] >= nums[mid] ){ // no roatation 
//                return nums[left];
//            }
            
            if( left + 1 == right ){
                return Math.min(nums[left], nums[right]) ;
            }
            
            if( nums[right] > nums[mid]){ // left is sorted
                right = mid; 
            }else if( nums[left] < nums[mid] ){
                left = mid;
            }else{
                left++;
            }
        }     
        return nums[left];
    }
    
    
    public static void main(String[] args) {
        // { 1,2,3,4,5,6,7}
        // { 6,7,1,2,3,4,5};
        System.out.println( findMin2( new int[]{ 1,3,3 } ) );
    }
}
