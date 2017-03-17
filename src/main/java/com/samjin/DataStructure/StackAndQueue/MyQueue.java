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
public class MyQueue {
    
    Stack<Integer> tmp = new Stack<Integer>();
    Stack<Integer> value = new Stack<Integer>();
    
    public void push(int x){
        if( value.isEmpty()){
            value.push(x);
        }else{
            while(!value.isEmpty()){
                tmp.push(value.pop());
            }
            value.push(x);
            while(!tmp.isEmpty()){
                value.push(tmp.pop());
            }
        }
    }
    
    public void pop(){
        value.pop();
    }
    
    public int peek(){
        return value.peek();
    }
    
    public boolean empty(){
        return value.isEmpty();
    }   
}
