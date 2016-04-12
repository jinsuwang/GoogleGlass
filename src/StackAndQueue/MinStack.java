/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueue;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class MinStack {
    
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();  
    public void push(int x) {
        stack.push(x);
        if ( minStack.isEmpty() || x <= minStack.peek() ){
            minStack.push(x); 
        }
    }

    public void pop() {
        int val = stack.pop();
        if( !minStack.isEmpty() && val == minStack.peek()) minStack.pop();        
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
