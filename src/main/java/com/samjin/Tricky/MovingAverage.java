/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Tricky;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Sam
 */
    
    
public class MovingAverage {

    /** Initialize your data structure here. */
    
    private static int size;
    private static Queue<Integer> queue;
    private static double sum = 0;
    
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<Integer>();
    }
    
    public static double next(int val) {
        if( queue.size() >= size ){
            sum -= queue.peek();
            queue.poll();

        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
    
    public static void main(String[] args) {
        
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));

    }
}
    
