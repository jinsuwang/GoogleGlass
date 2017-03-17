/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.SearchAndSort;

/**
 *
 * @author Sam
 */
public class myBinarySearch {
    
    public static int binarySearch1( int[] arr, int val ){
        int left = 0;
        int right = arr.length - 1 ;
        while( left + 1 < right ){
            int mid = left + ( right - left ) / 2;
            if( arr[mid] == val ) right = mid;
            else if( arr[mid] < val ){
                left = mid;
            }else{
                right = mid;
            }
        }    
        if( arr[left] == val ) return left; // always return left most 
        if( arr[right] == val ) return right;
        return -1;
    }
    
    public static int binarySearch2( int[] arr, int val ){
        int left = 0;
        int right = arr.length - 1 ;
        while( left + 1 < right ){
            int mid = left + ( right - left ) / 2;
            if( arr[mid] == val ) left = mid;
            else if( arr[mid] < val ){
                left = mid;
            }else{
                right = mid;
            }
        }    
        if( arr[right] == val ) return right;
        if( arr[left] == val ) return left; // always return right most 

        return -1;
    }
    
    
    // Template 3
    public static int binarySearch3( int[] arr, int val){
        int left = 0;
        int right = arr.length - 1;
        while( left <= right ){
            int mid = left + ( right - left ) / 2;
            if( arr[mid] == val ) return mid;
            else if( arr[mid] < val ){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        int[] test = { 1,1,1,2,3 };
        int ret = binarySearch3(test, 3);
        System.out.println(ret);
    }
}
