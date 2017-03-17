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
public class CopyListWithRandomPointer {
    
    public RandomListNode copyRandomList(RandomListNode head) {
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode newNode = null;
        RandomListNode pre = newNode; // tracking new list
        
        while( head != null ){
            if( map.containsKey(head) ){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;
            
            // copy random
            if( head.random != null ){
                if( map.containsKey(head.random) ){
                    newNode.random = map.get(head.random);
                }else{
                    newNode.random = new RandomListNode( head.random.label );
                    map.put(head.random, newNode.random);
                }
            }
            pre = pre.next;
            head = head.next;
        }
        return dummy.next;
    }
    
    public RandomListNode copyRandomListInPlace(RandomListNode head) {
        if( head == null ) return null;
        copyNext(head);
        copyRandom(head);
        return split(head);
    }

    private void copyNext(RandomListNode head) {
        while( head != null ){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random; // link new node to head.
            newNode.next = head.next; // link to next node;
            head.next = newNode;
            head = head.next.next;
        }
    }

    private void copyRandom(RandomListNode head) {
        while( head != null ){
            head.next.random = head.random.next;
        }
        head = head.next.next;
    }

    private RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        while( head != null ){
            RandomListNode temp = head.next;
            head.next = temp.next; // delete on reference.
            head = head.next;
            
            if( temp.next != null ){ // delete new list.
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }
}

