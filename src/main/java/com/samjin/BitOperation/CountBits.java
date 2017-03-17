/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.BitOperation;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class CountBits {
    
    public static int[] countBits(int num) {
        
        int[] ret = new int[num+1];
        ret[0] = 0;
        for( int i = 1; i <= num; i++ ){
            ret[i] = ret[i >> 1] + (i & 1);
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] ret = countBits(5);
        System.out.println(Arrays.toString(ret));
    }
}
