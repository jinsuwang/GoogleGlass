/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class MyBlockingQueue{
    
    private Queue<Object> queue = new LinkedList<Object>();
    
    public synchronized void enqueue( Object o ){
        queue.offer(o);
        notifyAll();
    }
    
    public synchronized Object dequeue(){
        Object msg = null;
        while( queue.isEmpty() ){
            try{
                wait();
            }catch( InterruptedException e){
                return msg;
            }
        }
        
        msg = queue.remove();
        return msg;
    }
}
