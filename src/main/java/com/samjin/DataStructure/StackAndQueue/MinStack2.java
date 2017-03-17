/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.StackAndQueue;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class MinStack2 {
    
    
    private int minValue;
    private Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
        if( stack.isEmpty() ){
            stack.push( 0 );
            minValue = x;
        }else{
            stack.push( x - minValue );
            minValue = x < minValue ? x : minValue;
        }
    }

    public void pop() {
        int x = stack.pop();
        if( x < 0 ){
            minValue = minValue - x; 
        }
    }

    public int top() {
        int x = stack.peek();
        if( x > 0 )  return x + minValue;
        else return minValue;
    }

    public int getMin() {
        return minValue;
    }
    
    public static void main(String[] args) {
        MinStack stack =new MinStack();
        
        stack.push(5);
        System.out.println(stack.getMin());
        stack.push(3);
        System.out.println(stack.getMin());
        System.out.println(stack.top());

    }
    
}
