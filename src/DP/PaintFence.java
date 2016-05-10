/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Sam
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if( n <= 0 ) return 0;
        if( n == 1 && k == 1) return 1;
        if( k < 2 ) return 0;
        
        if( n % 2 == 0 ) return k*(n/2) + (k-1)*(n/2);
        else return k*(n/2+1) + (k-1)*(n/2);
    }
}
