/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class MyHashMap<K,V> {
    
    private static class LinkedListNode<K,V>{
        public LinkedListNode<K,V> next;
        public LinkedListNode<K,V> prev;
        public K key;
        public V value;
        public LinkedListNode(K k, V v){
            key = k;
            value = v;
        }
    }
    private ArrayList<LinkedListNode<K,V>> arr;
    
    public MyHashMap( int capacity ){
        arr = new ArrayList<LinkedListNode<K,V>>();
        // initualization
        for( int i = 0; i < capacity; i++ ){
            arr.add(null);
        }
    }
    
    public void put( K key, V value){
        LinkedListNode<K,V> node = getNodeForKey(key);
        if ( node != null ){
            node.value = value;
            return;
        }
        // not in hashtable
        node = new LinkedListNode<K,V>(key,value);
        int index = getIndexForKey(key);
        if( arr.get(index) != null ){
            node.next = node;
            node.next.prev = node;
        }
        arr.set(index, node);
    }
    
    public void remove( K key ){
        LinkedListNode<K,V> node = getNodeForKey(key);
        // not at beginning.
        if( node.prev != null ){
            node.prev.next = node.next;
        }else{ // head
            int index = getIndexForKey( key );
            arr.set(index, node.next);
        }
        // handle next;
        if( node.next != null ){
            node.next.prev = node.prev;
        }
    }
    
    
    public V get( K key){
        LinkedListNode<K,V> node = getNodeForKey(key);
        return node == null ? null : node.value;
    }
    private LinkedListNode<K,V> getNodeForKey(K key){
        int index = getIndexForKey(key);
        LinkedListNode<K,V> current = arr.get(index);
        while( current != null ){
            if ( current.key == key){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    private int getIndexForKey(K key){
        return Math.abs(key.hashCode() % arr.size());
    }
}
