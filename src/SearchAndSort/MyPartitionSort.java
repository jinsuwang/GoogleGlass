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
public class MyPartitionSort {

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
//        System.out.println("swap " + left + ":" + right );
//        System.out.println("after swap:  " + Arrays.toString(arr));

    }
    
    public static void quickSort( int[] arr ){
        
        if( arr == null || arr.length == 0 ) return;
        partition( arr, 0, arr.length -1 );
    
    } 
    
    private static void partition( int[] arr, int left, int right){
        
        int i = left;
        int j = right;
        
        
        int partitionIndex = left + (right-left)/2 ;
        int pivot = arr[partitionIndex];
//        System.out.println(Arrays.toString(arr) + " " + left + " " + right + " "+ pivot);

        while( i < j ){
            while ( arr[i] < pivot ) i++; // find element greater than pivot.
            while ( arr[j] > pivot ) j--; // find element smaller than pivot.
            if( i <= j ){ // make sure i,j is still valid.
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if( left < j ) partition( arr, left ,j ); // partition left part.
        if( i < right ) partition( arr, i, right);
        
    }
    
    public static void main(String[] args) {
        int[] test = { 1,3,5,2,3,6,3,11,4};
        quickSort(test);
        System.out.println(Arrays.toString(test));
    }
}
