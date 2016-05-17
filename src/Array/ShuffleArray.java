/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Sam
 */
public class ShuffleArray {
    
    public static void shuffle(int[] arr ){
        for(int i = arr.length -1 ; i >= 0; i-- ){
            Random ran = new Random();
            int index = ran.nextInt( i+1 );
            // swap
            int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
       
    } 
    public static void main(String[] args) {
        int[] test = { 1,2,3,4,5,6 };
        shuffle( test );
        System.out.println(Arrays.toString(test));
    }
}
