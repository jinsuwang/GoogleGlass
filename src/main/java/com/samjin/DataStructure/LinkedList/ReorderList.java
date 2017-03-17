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
public class ReorderList {
    
    public static void reorderList(ListNode head) {
        if( head == null ) return;
        ListNode mid = findMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode reversed = reverse(next);
//        Helper.printList(head);
//        Helper.printList(reversed);   
        merge( head, reversed );
    }

    private static ListNode findMid(ListNode head) {
        if( head == null ) return head;
        ListNode fast = head;
        ListNode slow = head;
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    
    private static ListNode reverse(ListNode node) {
        if( node == null ) return node; 
        
        ListNode newHead = null;
        
        while( node != null ){
            ListNode tmp = node.next;
            node.next = newHead;
            newHead = node;
            node = tmp;
         
        }
        return newHead;
    }

    private static void merge(ListNode head1, ListNode head2) {
       int index = 0;
        ListNode dummy = new ListNode(0);
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                dummy.next = head1;
                head1 = head1.next;
            } else {
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index ++;
        }
        if (head1 != null) {
            dummy.next = head1;
        } else {
            dummy.next = head2;
        }
    }
    
    
        
    public static void main(String[] args) {
        ListNode test = Helper.getTestListNode();
//        ListNode mid = findMid(test);
//        System.out.println( mid.val );
//        ListNode reversed = reverse(test);
//        Helper.printList(reversed);
        reorderList(test);
//        Helper.printList(test);
    }
}
