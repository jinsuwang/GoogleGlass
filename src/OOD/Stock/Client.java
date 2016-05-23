/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOD.Stock;

/**
 *
 * @author Sam
 */
public class Client {
    
    public static void main(String[] args) {
        
        StockTrade stock = new StockTrade();
        
        BuyStockOrder bsc = new BuyStockOrder (stock);
        SellStockOrder ssc = new SellStockOrder (stock);
        Agent agent = new Agent();
        
        agent.placeOrder(bsc); // Buy Shares
        agent.placeOrder(ssc); // Sell Shares
        
        
        
    }
    
}
