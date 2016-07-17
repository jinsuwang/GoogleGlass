/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class MinStack {
    
    
    private int min;
    private Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
        if( stack.isEmpty() ){
            stack.push(0);
            min = x;
        }else{
            stack.push( x - min );
            min = x < min ? x : min;
        }
    }
    
    public void pop(){
        
        int tmp = stack.pop();
        
        if( tmp < 0){
            min = min - tmp;
        }
    }
    
    public int top(){
        int tmp = stack.peek();
        return tmp + min;
    }
    
    public int getMin(){
        return min;
    }
    
    public static void main(String[] args) {
        
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println( minStack.getMin() );   //--> Returns -3.
        minStack.pop();
        System.out.println( minStack.top() );      //--> Returns 0.
        System.out.println( minStack.getMin() );   //--> Returns -2.        
        
        
    }
}
