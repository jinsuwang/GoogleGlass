/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *
 * @author Sam
 */
public class SlidingWindowMaximum {
    
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        if ( nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int[] sol = new int[len-k+1];
        
        for(int i=0;i<sol.length;i++){
            sol[i] = findMax( nums, i, k );
        }
        return sol;
    }

    private static int findMax(int[] nums, int i, int k) {
        int max = Integer.MIN_VALUE;
        for( int j = 0; j < k; j++ ){
            max = Math.max( nums[i+j],max );
        }
        return max;
    }
    
    // O(nlog(n)) solution using heap
    public static int[] maxSlidingWindow2( int[] nums, int k ){
        if( nums == null || nums.length == 0 ) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] sol = new int[ nums.length-k+1]; 
        for( int i=0; i<nums.length; i++ ){
            // remove left move
            if( i >= k ) pq.remove( nums[i-k] );
            pq.offer(nums[i]);
            if( i+1 >= k ) sol[i+1-k] = pq.peek();
        }
        return sol;
    }
    
    //O(n) solution with two way queue
    public static int[] maxSlidingWindow3( int[] nums, int k ){
        if(nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> deque = new LinkedList<Integer>();
        int[] sol = new int[nums.length + 1 - k];
        
        for(int i = 0; i < nums.length; i++){
            
            if(!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            
            while( !deque.isEmpty() && nums[ deque.peekLast() ] < nums[i] ) deque.removeLast();
            
            deque.offerLast(i);
            
            if( i+1 >= k ) sol[i+1-k] = nums[deque.peek()];
        }

        return sol;
    }

    public static void main(String[] args) {
        int[] test = {1,3,-1,-3,5,3,6,7};
        int[] sol = maxSlidingWindow3(test, 3);
        System.out.println(Arrays.toString(sol));
        
    }
    
}
