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
public class countPrime {
    
    public int countPrimes(int n) {
        if( n <= 1 ) return 0; 
        boolean[] notPrime = new boolean[n+1];
        notPrime[0] = notPrime[1] = true;
        for( int i = 2; i * i < n; i++ ){
            if( !notPrime[i] ){
                int c = i * i;
                while( c < n ){
                    notPrime[c] = true;
                    c += i;
                }
            }
        } 
        int ret = 0;
        for( int j = 0; j < n; j++ ) if( !notPrime[j] ) ret++;
        return ret;
    }
}
