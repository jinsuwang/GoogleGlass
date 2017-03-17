/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.StackAndQueue.FixSizeQueue;

import java.util.Arrays;
//import static org.junit.Assert.*;


/**
 *
 * @author Sam
 */
public class FixedLengthQueue{
    
    private int[] queue;
    private int capacity;
    int tail;
    int head;
    int size;
    
        
    FixedLengthQueue( int capacity ){
        queue = new int[capacity];
        this.capacity = capacity;
        size = 0;
        head = 0;
        tail = -1;
    }
    
    public boolean enqueue( int x ) throws Exception{
        if( isFull() ){
            throw new Exception("QueueFullException");
        }else{
            tail++;
            if( tail == capacity ) tail = 0;
            queue[tail] = x;
            size++;
            System.out.println("sol is "+ Arrays.toString(queue) );

        }
        return true;
    }
    
    public int dequeue() throws Exception{ 
        int sol = 0;
        if( isEmpty() ) 
            throw new Exception("QueueEmptyException");
        else{
//            System.out.println(head);
            sol = queue[head];
            
            System.out.println("sol is "+ Arrays.toString(queue) );
            head++;
            if( head == capacity ){
                head = 0;
            }
            size--;
        }
        return sol;
    }
    
    public int peek() throws Exception{
        if( isEmpty() ) 
            throw new Exception("QueueEmptyException");
        System.out.println("sol is "+ Arrays.toString(queue) );
        return queue[head];
    }
    
    public int size(){
        return size;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    
    
    
    
    
    
    public static void main(String[] args) throws Exception {
        
        FixedLengthQueue queue = new FixedLengthQueue(3);
        System.out.println( queue.isEmpty() ); // true
        System.out.println( queue.enqueue(1)); // true
        System.out.println( !queue.isEmpty() );// true
        System.out.println( queue.enqueue(2)); // true
        System.out.println( queue.peek() );    // 1
        System.out.println( queue.enqueue(3)); // true
        System.out.println( queue.isFull() );  // true
        System.out.println( queue.dequeue() ); // 1
        System.out.println( queue.peek() );    // 2
        System.out.println( queue.size() );    // 2

//        System.out.println(queue.enqueue(4));


        
    }
    
}
