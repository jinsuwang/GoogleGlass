/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class ProductOfArrayExceptItself {
    
    public static int[] productExceptSelf(int[] nums) {
        // init ret array.
        int[] ret = new int[nums.length];
        ret[0] = 1; 
        int tmp = 1;
        for ( int i = 1; i < nums.length; i++ ) {
            tmp *= nums[i-1];
            ret[i] = tmp;
        }
        tmp = 1;
        
        System.out.println(Arrays.toString(ret));
        
        for ( int j = nums.length-2; j>=0; j--){
            tmp *= nums[j+1];
            ret[j] *= tmp;
        } 
        
        System.out.println(Arrays.toString(ret));
   
        return ret;
    }
    
    public static void main(String[] args) {
        Arrays.toString( productExceptSelf( new int[]{ 1,2,3,4 } ));
    }
    
}
