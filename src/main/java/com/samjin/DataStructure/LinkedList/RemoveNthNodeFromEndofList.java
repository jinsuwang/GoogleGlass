/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.LinkedList;

/**
 *
 * @author Sam
 */
public class RemoveNthNodeFromEndofList {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        
        if( head == null ) return null;
        
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while( n > 0 ){
            if( curr == null ) return null;
            curr = curr.next;
            n--;
        }
        
        while( curr != null ){
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
    
    public static void main(String[] args) {
       ListNode head = Helper.getTestListNode();
       ListNode ret = removeNthFromEnd( head , 2 );
       Helper.printList(ret);
       
    }
}
