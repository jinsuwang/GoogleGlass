/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Math;

/**
 *
 * @author Sam
 */
public class Sqrt {
    public static int mySqrt(int x) {
        if( x <= 1 ) return x;     
        int start = 1;
        int end = x;
        while( start <= end ) {// start could be equal end
            int mid = start + ( end - start ) / 2;
            if( mid == x / mid ) return mid;
            else{
                if( mid < x / mid ){
                    start = mid + 1 ;
                }else{
                    end = mid - 1;
                }
            }
        } 
        return end;
    }
    
    public static void main(String[] args) {
        int test = 17;
        System.out.println( mySqrt(test) );
        
    }
}
