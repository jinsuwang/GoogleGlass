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
public class BackpackII {
    public int backPack(int capacity, int[] goods, int[] value ) {
        // write your code here
        int[][] values = new int[goods.length+1][ capacity+1 ];
        for(int i = 0; i <= goods.length ; i++ ){
            for( int j = 0; j <= capacity; j++ ){
                if( j == 0 || i == 0){
                    values[i][j] = 0;
                }else if( goods[i-1] > j ){
                    values[i][j] = values[i-1][j]; 
                }else{
                    // take it or not take it.
                    values[i][j] = Math.max(values[i-1][j], values[i-1][j-goods[i-1]] + value[i] ); 
                    
                }
            }
        }
        return values[goods.length][capacity];
    }    
}
