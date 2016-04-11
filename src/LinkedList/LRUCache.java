/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class LRUCache {

    private class LRUCacheNode {
    
        private LRUCacheNode prev;
        private LRUCacheNode next;
        private int key;
        private int value;
    
        public LRUCacheNode( int key, int value ){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<Integer, LRUCacheNode > map = new HashMap<Integer, LRUCacheNode>();
    private LRUCacheNode head;
    private LRUCacheNode tail;
    
    public LRUCache( int capacity ){
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get( int key ){
        if( !map.containsKey(key) ) return -1;
        
        LRUCacheNode curr = map.get(key);
        // delete node
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // move to tail
        move_to_tail( curr ); 
        return curr.value;
    }
    public void set( int key, int value ){
        if( get(key) != -1  ){ // find it and change strucure.
            map.get(key).value = value;
            return;
        }
        
        if( map.size() == capacity ){
            map.remove( head.next.key );
            head.next = head.next.next;
            head.next.prev = head;
        } 
        
        LRUCacheNode insert = new LRUCacheNode(key, value);
        map.put( key, insert );
        move_to_tail(insert);
    }
    
    
    private void move_to_tail(LRUCacheNode curr) {
        curr.prev = tail.prev;
        tail.prev = curr;
        curr.prev.next = curr;
        curr.next = tail;
    }
    
    
}
