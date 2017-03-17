/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DP;

/**
 *
 * @author Sam
 */
public class Backpack {
    public static int backPack2(int m, int[] A) {
        boolean f[][] = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = false;
            }
        }
        f[0][0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]]) {
                    f[i + 1][j] = true;
                }
            } // for j
        } // for i
        
  
                
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.print(f[i][j] + "\t");
            }
            System.out.println();
        }
        
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i]) {
                return i;
            }
        }
        
        
        return 0;
    }
    
    
    
    public static int backpack( int capacity, int[] goods ){
        boolean[][] canStore = new boolean[goods.length+1][capacity+1];
        
        canStore[0][0] = true; // no capcity, new goods, init state is true;
        
        for( int i = 0; i < goods.length; i++ ){
            for( int j = 0; j <= capacity; j++ ){
                // I can keep the same load if new good comming in.
                canStore[i+1][j] = canStore[i][j];
                // load is greater than current goods and I have collect previous goods
                if( j >= goods[i] && canStore[i][j-goods[i]] ){
                    canStore[i+1][j] = true;
                }
            }   
        }
        
        for (int i = capacity; i > 0; i--) {
            if (canStore[goods.length][i]) {
                return i;
            }
        }
        return 0;
        
    }
    
    
    public static int backpack2( int capacity, int[] goods ){
        int[][] cache = new int[goods.length][ capacity ];
        for(int i = 0; i < goods.length ; i++ ){
            for( int j = 0; j < capacity; j++ ){
                if( j == 0 ){
                    cache[i][j] = 0;
                }else if( i == 0 ){
                    cache[i][j] = j >= goods[i] ? goods[i] : 0; 
                }else{
//                    cache[i][j] = Math.max( cache[i-1][j] , cache[i-1][]     )
            
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int x = backpack( 11, new int[]{2,3,5,7} );   
        System.out.println( x );
    }
}
