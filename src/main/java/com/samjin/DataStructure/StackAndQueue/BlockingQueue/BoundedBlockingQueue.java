/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.StackAndQueue.BlockingQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Sam
 */
public class BoundedBlockingQueue<E> {
    
    
    private Lock lock = new ReentrantLock();
    private Lock pushLock = new ReentrantLock();
    private int capacity;
    private Queue<E> queue;
    private Condition notFull = this.lock.newCondition();
    private Condition notEmpty = this.lock.newCondition();
     
    public void init( int capacity ) throws Exception{
        this.lock.lock();
        try{
            if( this.queue == null ){
                this.queue = new LinkedList<>();
                this.capacity = capacity;
            }else{
                throw new Exception();
            }
        }finally{
            this.lock.unlock();;
        }
    }
    
    
    public void push( E obj ) throws Exception{
        this.pushLock.lock();
        this.lock.lock();
        try{
            
            while( this.capacity == this.queue.size() ){
                this.notFull.wait();
            }
            this.queue.add(obj);
            this.notEmpty.notifyAll() ;
        }finally{
            this.lock.unlock();
            this.pushLock.lock();
        }
    }
    
    
    public E pop() throws InterruptedException{
        
        this.lock.lock();
        try{
            while( this.capacity == 0 ){
                this.notEmpty.wait();
            }
            E result = this.queue.poll();
            notFull.notifyAll();
            return result;
        }finally{
            this.lock.unlock();
        }
    }
    
    
    
}
