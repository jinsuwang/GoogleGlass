package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sam
 */
public class MyStack {
    /**
     * @param args the command line arguments
     */
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    
    
    public void push(int x){
        q1.offer(x);
    }
    
    public void pop(){
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        q1.poll();
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
    }
    
    public int top(){
        while(q1.size() > 1){
            q2.offer(q1.poll());
        }
        int top = q1.peek();
        q2.offer(q1.poll());
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
        return top;
    }
    
    public static void main(String[] args) {
        System.out.println("hello World");
    }
}
