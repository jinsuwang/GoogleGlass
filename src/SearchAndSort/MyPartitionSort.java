/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Sam
 */
public class MyPartitionSort {

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
    
    public static void quickSort( int[] arr ){  
        if( arr == null || arr.length == 0 ) return;
        quickSortHelper( arr, 0, arr.length -1 );
    } 
    
    private static void quickSortHelper( int[] arr, int left, int right){
        int pos = partition( arr, left, right );
        if( left < pos - 1 ) quickSortHelper( arr, left, pos-1 );
        if( right > pos ) quickSortHelper( arr, pos+1, right );
    }
    
    private static int partition(int[] nums, int l, int r) {
        if( l == r ){
            return l;
        }   
        int left = l, right = r;
        int curr = nums[left];
        while(left < right ){
            while( left < right && nums[right] >= curr) right--;
            nums[left] = nums[right];            
            while( left < right && nums[left] <= curr ) left++;
            nums[right] = nums[left];
        }
        nums[left] = curr;
        return left;   
    }
    
    public static void main(String[] args) {
        int[] test = { 1,3,5,2,3,6,3,11,4};
        quickSort(test);
        System.out.println(Arrays.toString(test));
        Arrays.sort(test); 
    }
    
    
    
//    private static void partition2( int[] arr, int left, int right){
//        
//        int i = left;
//        int j = right;
//        
//        
//        int partitionIndex = left + (right-left)/2 ;
//        int pivot = arr[partitionIndex];
////        System.out.println(Arrays.toString(arr) + " " + left + " " + right + " "+ pivot);
//
//        while( i < j ){
//            while ( arr[i] < pivot ) i++; // find element greater than pivot.
//            while ( arr[j] > pivot ) j--; // find element smaller than pivot.
//            if( i <= j ){ // make sure i,j is still valid.
//                swap(arr, i, j);
//                i++;
//                j--;
//            }
//        }
//        if( left < j ) partition( arr, left ,j ); // partition left part.
//        if( i < right ) partition( arr, i, right);
//        
//    }
//    

}
