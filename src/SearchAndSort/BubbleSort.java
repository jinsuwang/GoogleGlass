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
public class BubbleSort {
    
    public static void myBubbleSort( int[] arr ){
        int j;
        boolean swapped = true;       
        while( swapped ){
            swapped = false;
            for( int i = 0; i < arr.length-1; i++ ){
                if( arr[i] > arr[i+1] ){//  need swap
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp; 
                    swapped = true;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }
    public static void main(String[] args) {
        int[] a = { 5, 4, 3, 2, 1 };
        myBubbleSort( a );
        System.out.println(Arrays.toString(a));
    }
}
