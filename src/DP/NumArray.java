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
public class NumArray {
    
    int[] tmp ;
    
    public NumArray(int[] nums) {
        //        if( nums == null || nums.length == 0 )

        if( nums != null && nums.length != 0 ){
            tmp = new int[nums.length];
            tmp[0] = nums[0];
            for( int i=1; i<nums.length; i++ ){
                tmp[i] = tmp[i-1] + nums[i];
            }
//            System.out.println( Arrays.toString(tmp)) ;
        }   
    }

    public int sumRange(int i, int j) {
        if( tmp == null || j < i ) return 0;
        return i == 0 ? tmp[j] : tmp[j] - tmp[i-1];
    }
    
    public static void main(String[] args) {
        int[] test = { -2, 0, 3, -5, 2, -1};
        NumArray n = new NumArray( test ); 
        System.out.println( n.sumRange(0, 2) );
        System.out.println( n.sumRange(2, 5) );
        System.out.println( n.sumRange(0, 5) );

    }
}
