/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Company.Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class LRU<K,V> {

    
    private class Node<K,V>{
        private Node prev;
        private Node next;
        private K key;
        private V value;
    
        Node(K k, V v){
            this.key = k;
            this.value = v;
            this.prev = null;
            this.next = null;
        }
    }    
    
    private int capacity;
    Node head;
    Node tail;
    Map<K,Node> map = new HashMap<K,Node>();
    
    LRU(int capacity){
        this.capacity = capacity;
        head = new Node("head","head");
        tail = new Node("tail","tail");
        tail.prev = head;
        head.next = tail;
    }
    
    
    public V get(K key) {
        if( !map.containsKey(key) ){
            return null;
        }
        
        // remove node 
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        
        moveToTail(curr);
        printList();

        return (V)curr.value;
    }
    
    public void set(K key, V value) {
        if( get(key) != null ){
            map.get(key).value = value;
            return;
        }
        
        // full
        if( map.size() == capacity ){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        
        Node tmp = new Node( key , value );
        map.put(key,tmp);
        moveToTail(tmp);
        
        printList();

    }
    
    private void printList() {
        Node curr = head;
        StringBuffer sb = new StringBuffer();
        while( curr != null ){
            sb.append(curr.value).append("->");
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }
    
    
    private void moveToTail( Node n ){
        Node tmp = tail.prev;
        tail.prev.next = n;
        n.next = tail;
        tail.prev = n;
        n.prev = tmp;
    }
    
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        
        lru.set("1", "a");
        lru.set("2", "b");
        lru.set("3", "c");
        lru.get("1");
        lru.get("3");
        lru.set("4", "d");

    }
}
