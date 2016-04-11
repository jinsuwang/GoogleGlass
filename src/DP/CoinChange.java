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
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        cache[0] = 0;
        for( int i = 1; i <= amount; i++ ) cache[i] = Integer.MAX_VALUE;
        for( int i = 0; i <= amount; i++ ){
            for( int j = 0; j < coins.length; j++ ){
                if( i + coins[j] <= amount ){
                    cache[ i + coins[j] ] =  Math.min( cache[i + coins[j]], cache[i] + 1  ); 
                }
            }
        } 
        return cache[ amount ] == Integer.MAX_VALUE ? -1 : cache[amount];
    }
}
