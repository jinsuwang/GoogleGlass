/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DesignPattern.example.Stock;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class Agent {
    
    public Queue<Order> orders = new LinkedList<Order>();
    
    Agent(){}
    
    void placeOrder( Order order ){
        orders.offer(order);   
        while( !orders.isEmpty() ) 
            orders.poll().execute();
    }
    
    
}
