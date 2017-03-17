/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Heap;

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
                // Min Heap
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
    
    public static List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> h = new HashMap();
        for (int i : nums)
            if (h.containsKey(i))
                h.put(i, h.get(i) + 1);
            else
                h.put(i, 1);

        List<Integer>[] fc = new ArrayList[n + 1];
        for (int i : h.keySet()) {
            int f = h.get(i);       //System.out.println(f + " times of " + i);
            if (fc[f] == null) fc[f] = new ArrayList();
//            for( int w=0; w < f;w++)
            fc[f].add(i);
            System.out.println(fc[f].toString());
        }

        List<Integer> ans = new ArrayList();
        for (int i = n, j = 0; k > 0; k--) {
            for (; fc[i] == null || j == fc[i].size(); j = 0, i--);
            ans.add(fc[i].get(j++));
        }
//        int i = n;
//        while( k > 0 && i >= 0 ){
//       
//            if( fc[i] != null ){
//                for( int e : fc[i] ){
//                    ans.add(e);
//                }
//                k--;
//            }
//            i--;
//            
//        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] test = { 1,1,1,1,1,1,1,1,1,2,2,2,3,3,3,3,3,3,3 };
        List<Integer> ret = topKFrequent(test, 2);
        System.out.println(ret.toString());
    }
}
