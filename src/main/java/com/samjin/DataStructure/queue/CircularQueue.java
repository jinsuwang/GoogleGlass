/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.queue;

/**
 *
 * @author Sam
 */
public class CircularQueue {

    public int size;
    private int head;
    private int tail;
    private int[] queue;
    
    public CircularQueue( int capacity ){
        this.size = 0;
        queue = new int[capacity];
        head = -1;
        tail = -1;
        
    }

    public boolean enqueue( int x ){
        if( size == queue.length ) return false;
        if( head == -1 && tail == -1 ){
            head = 0; tail = 0; 
        }else{
            tail = (tail + 1) % queue.length;
        }
        queue[tail] = x;
        size++;
        return true;
    }
    
    public int dequeue() throws EmptyQueueException{
        if( size == 0 ) throw new EmptyQueueException( "Queue is Empty" );
        int ret = queue[head];
        head = ( head + 1 ) % queue.length;
        size--;
        if(size == 0){
            head = -1;
            tail = -1;
        }
        return ret;
    }
    
    
    public static void main(String[] args) throws EmptyQueueException {
        CircularQueue cq = new CircularQueue(2);
        System.out.println(cq.enqueue(3));
        System.out.println(cq.enqueue(2));
        System.out.println(cq.enqueue(1));
        System.out.println(cq.size);
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        System.out.println(cq.enqueue(4));
        System.out.println(cq.enqueue(5));
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());
        System.out.println(cq.dequeue());    
   }
}
