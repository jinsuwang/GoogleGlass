/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeAndPalindrome;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class CountPrimes {
    
    public static int countPrimes(int n) {
       boolean[] notPrime = new boolean[n+2];
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
       System.out.println(Arrays.toString(notPrime));
       for( int j = 0; j < n; j++ ) if( !notPrime[j] ) ret++;
       return ret;
    }
    
    public static void main(String[] args) {
        countPrimes(100);
    }
    
}
