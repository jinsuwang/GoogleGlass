/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import LinkedList.ListNode;

/**
 *
 * @author Sam
 */
public class ReverseSecondHalfOfLinkedList {
    public static ListNode reorder(ListNode head){
        if( head == null || head.next == null || head.next.next == null ){
            return head;
        }
        // find mid
        ListNode fast = head.next;
        ListNode slow = head;
        while( fast.next != null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = slow.next;
        ListNode curr = prev.next;
        while( curr != null ){
            prev.next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
            curr = prev.next;
        }
        return head;
    }
    
        
    public static void printList(ListNode node){
        ListNode curr = node;
        while( curr != null  ){
            System.out.print(curr.val+" ");
            curr = curr.next;
            if( curr == node) break;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2; l2.next = l3; l3.next = l4; l4.next = l5;l5.next = l6; l6.next = l7;
        printList( l1 );
        reorder( l1 );
        printList( l1 );
    }
}
