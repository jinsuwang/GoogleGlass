/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Company.Amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Sam
 */
public class SlideingWindowMaximum {

    /* using heap. */
    public static int[] maxSlidingWindow(int[] nums, int k) {
    
         PriorityQueue<Integer> pq = new PriorityQueue<>(3,Collections.reverseOrder());
         int[] ret = new int[ nums.length - k + 1 ];
         
         for( int i = 0; i < nums.length; i++ ){
            if( i >= k ) pq.remove( nums[i-k]);
            pq.offer(nums[i]);
            if( i+1 >= k) ret[i+1-k] = pq.peek();
         }
         return ret;
    }    
    
    /* using two way queue. */
    public static int[] maxSlidingWindow2( int[] nums, int k ){
        Deque<Integer> queue = new LinkedList<>();
        if( nums == null || nums.length == 0 || k <= 0 ) return new int[0];

        int[] ret = new int[ nums.length - k + 1 ];

        for( int i = 0; i < nums.length; i++ ){
            
            int curr = nums[i];
            
            while( !queue.isEmpty() && curr > queue.peekLast() ){
                queue.pollLast();
            }
            queue.offer( curr );
            
            if( i >= k  && queue.peekFirst() == nums[i-k] ) queue.pollFirst();
            if( i+1 >= k ){
                ret[i+1-k] = queue.peekFirst();
            }
        }
        return ret;
    }

    
    public static void main(String[] args) {
        
        int[] test = new int[]{ 1,3,-1,-3,5,3,6,7 };
        
        System.out.println(Arrays.toString( maxSlidingWindow2(test,3) ));
        
    }
}
