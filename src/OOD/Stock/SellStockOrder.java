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
public class SellStockOrder implements Order{

    private StockTrade trader;
    
    SellStockOrder( StockTrade st){ 
        this.trader = st;
    }
    
    public void execute() {
        this.trader.sell();
    }
    
}
