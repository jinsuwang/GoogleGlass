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
public class CopyListWithRandomPointer {
    
    private class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode( int x ){ 
            this.label = x;
        }
    }
    /*  HashMap */
    public RandomListNode copyRandomList(RandomListNode head) {
        if( head == null ) return null;
        
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;
        // let's go!
        while( head != null ){
            if( map.containsKey(head) ){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode( head.label );
                map.put(head, newNode);
            }
            pre.next = newNode;
            
            if( head.random != null ){
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            // move to next node.
            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }
    
    
    
    
    public RandomListNode copyRandomList2(RandomListNode head) {
        if( head == null ) return null;
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
       
    private void copyNext( RandomListNode head ){
        while( head != null ){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random; // copy random
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    
    private void copyRandom(RandomListNode head){
        while( head != null ){
            if( head.next.random != null ){
               head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    
    private RandomListNode splitList(RandomListNode head){
        RandomListNode newHead = head.next;
        while( head != null ){
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if( temp.next != null ) temp.next = temp.next.next;
        }
        return newHead;
    }
}
