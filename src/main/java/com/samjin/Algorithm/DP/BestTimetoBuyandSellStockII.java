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
public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if( prices[i] > prices[i-1]) profit += prices[i]-prices[i-1];
        }
        return profit;
    }
}
