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
public class FindtheDuplicateNumber {
    
    public static int findDuplicate(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while( left <= right){
            int mid = left + (right - left) / 2;
            int count = 0;
            for(int e : nums){
                if( e <= mid ) count++;
            }
            // duplication in first part;
            if( count > mid ){
                right = mid-1 ;
            }else{
                left = mid+1;
            } 
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[] test = { 1,2,3,3,3,4,5 };
        System.out.println( findDuplicate(test) );
    }
}
