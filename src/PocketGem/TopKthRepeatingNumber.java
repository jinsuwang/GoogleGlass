/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PocketGem;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class TopKthRepeatingNumber {
    
    public static List<Integer> kth(int[] arr, int k){
        List<Integer> ret = new ArrayList<Integer>();
        if( arr == null || arr.length == 0 ) return ret;
        
        // counter hashmap
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for ( int e : arr ){
            if( map.containsKey(e)){
                map.put(e, map.get(e)+1);
            }else{
                map.put(e, 1);
            }
        }
        if( k > map.size() ) return ret;
        
        // init queue
        Queue<Entry<Integer, Integer>> pq = new PriorityQueue<Entry<Integer, Integer>>(k+1, 
                new Comparator<Entry<Integer, Integer>>(){
            public int compare( Entry<Integer,Integer> e1,  Entry<Integer,Integer> e2 ) {
                // Max Heap
                return e1.getValue() - e2.getValue();
            }
        });
        
        Iterator<Integer> it = map.keySet().iterator();
        while( it.hasNext() ){
            int key = it.next();
            int value = map.get(key);
            pq.offer( new SimpleEntry<Integer, Integer>(key, value) );
            if (pq.size() >= k + 1) {
		pq.poll();
            }
        }
        
        while( k > 0 ){
            Integer e = pq.poll().getKey();
            ret.add(0, e );
            k--;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        int[] test = { 1,1,1,1,1,1,2,2,2,2,3,3,3,3,3,3,3 };
        List<Integer> ret = kth(test, 2);
        System.out.println(ret.toString());
    }
}
