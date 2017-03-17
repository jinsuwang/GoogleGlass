/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.queue;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class LRUCache<K, V> {

    private void printList() {
        StringBuffer sb = new StringBuffer();
        Node curr = head;
        while( curr != null  ){
            sb.append(curr.value);
            sb.append("->");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }

    private class Node<K,V> {
    
        private Node prev;
        private Node next;
        private K key;
        private V value;
    
        public Node( K k, V v ){
            this.key = k;
            this.value = v;
            this.prev = null;
            this.next = null;
        }
    }
    
    private int capacity;
    private Map<K, Node > map = new HashMap<K, Node>();
    private Node head = new Node("head","head");
    private Node tail = new Node("tail","tail");;
    
    public LRUCache( int capacity ){
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public V get( K key ){
        if( !map.containsKey(key) ) return null;
        
        Node curr = map.get(key);
        // delete node
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // move to tail
        move_to_tail( curr ); 
        printList();
        return (V)curr.value;
    }
    public void set( K key, V value ){
        if( get(key) != null  ){ // find it and change strucure.
            map.get(key).value = value;
            return;
        }
        
        if( map.size() == capacity ){
            map.remove( head.next.key );
            head.next = head.next.next;
            head.next.prev = head;
        } 
        
        Node insert = new Node(key, value);
        map.put( key, insert );
        move_to_tail(insert);
//        printList();
    }
    
   
    
    private void move_to_tail( Node curr) {
        curr.prev = tail.prev;
        tail.prev = curr;
        curr.prev.next = curr;
        curr.next = tail;
    }
    
    
    
    public static void main(String[] args) {
        LRUCache<String,String> cache = new LRUCache<String,String>(3);
        cache.set("key1","aaa");
        cache.set("key2","bbb");
        cache.set("key3","ccc");
        cache.set("key4","ddd");
        System.out.println(cache.get("key3"));
        System.out.println(cache.get("key2"));
        System.out.println(cache.get("key1"));
    }
}
