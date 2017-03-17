/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.BitOperation;

/**
 *
 * @author Sam
 */
public class SingleNumber {
    
    public int singleNumber(int[] nums) {
        for( int i=1; i<nums.length; i++){
            nums[0] ^= nums[i];
        } 
        return nums[0];
    }
    
    public static void main(String[] args) {
        
        int[] a = {1,2,3};
    }
    
}
