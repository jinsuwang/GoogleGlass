/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Sam
 */
public class LRUCacheNode {
    
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
