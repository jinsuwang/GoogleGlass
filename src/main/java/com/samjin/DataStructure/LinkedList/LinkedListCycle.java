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
public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head) {
        if( head == null ) return false;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if( fast == slow ) return true;
        }
        
        return false;
    }
    
}
