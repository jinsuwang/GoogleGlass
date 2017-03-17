/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Tricky;

/**
 *
 * @author Sam
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if ( nums == null || nums.length == 0 ) return -1;
        int candidateIndex = 0;
        int count = 1;
        for ( int i = 1; i < nums.length; i++ ){
            if( nums[i] == nums[candidateIndex] ){
                count++;
            }else{ // different !
                count--;
                if( count == 0){
                    candidateIndex = i;
                    count = 1;
                }
            }
        }
        return nums[candidateIndex];
    }
}
