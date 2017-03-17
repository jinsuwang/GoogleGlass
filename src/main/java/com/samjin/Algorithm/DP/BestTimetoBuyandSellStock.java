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
public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for( int i = 0; i < prices.length; i++ ){
            min = Math.min(prices[i], min);
            maxProfit = Math.max( maxProfit, prices[i] - min );
        } 
        return maxProfit;
    }
    
    public static void main(String[] args) {
        int[] test = new int[]{ 1,2 };
        System.out.println( maxProfit( test ) );
    }
}
