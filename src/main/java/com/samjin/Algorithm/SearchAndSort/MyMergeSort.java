/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.SearchAndSort;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class MyMergeSort {
    
    
    public static void mergeSort( int[] arr ){
        int[] tmp = new int[arr.length];
        divide( arr, tmp, 0, arr.length-1);
    }

    private static void divide(int[] arr, int[] tmp, int left, int right) {
        if( left >= right ) return;
        int mid = left + (right - left)/2;
        divide( arr, tmp, left, mid );
        divide( arr, tmp, mid + 1 , right );
        merge( arr, tmp, left, mid, right );
    }

    private static void merge(int[] arr, int[] tmp, int left, int mid, int right ){
        int curr = left;
        int startLeft = left;
        int startRight = mid+1;
        int index = left;
        while( startLeft <= mid && startRight <= right ){
            if( arr[startLeft] < arr[startRight] ){
                tmp[index++] = arr[startLeft++];
            }else{
                tmp[index++] = arr[startRight++];
            }
        }
        while( startLeft <= mid ) tmp[index++] = arr[startLeft++];
        while( startRight <= right ) tmp[index++] = arr[startRight++];
        for( int i = left; i <= right; i++ ) arr[i] = tmp[i];
    }
    
    public static void main(String[] args) {
        int[] test = {4,3,2,1};
        mergeSort( test );
        System.out.println(Arrays.toString(test));
    }
}
