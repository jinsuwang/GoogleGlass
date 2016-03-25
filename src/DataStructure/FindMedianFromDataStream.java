/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Sam
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
        new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }
    );
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        if( maxHeap.size() == minHeap.size() ){
            if( minHeap.peek() != null && num > minHeap.peek() ){
                maxHeap.offer( minHeap.poll());
                minHeap.offer( num );
            }else{
                maxHeap.offer( num );
            }
        }else{
            if( num < maxHeap.peek() ){
                minHeap.offer( maxHeap.poll() );
                maxHeap.offer( num );
            }else{
                minHeap.offer( num );
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if( maxHeap.isEmpty() ){
            return -1;
        }
        if( maxHeap.size() == minHeap.size() ){
            return (double)( minHeap.peek() + maxHeap.peek() ) / 2; 
        }else{
            return maxHeap.peek();
        }
    }
}
