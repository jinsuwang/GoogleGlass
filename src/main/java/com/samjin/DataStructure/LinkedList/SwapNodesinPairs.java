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
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while( curr.next != null && curr.next.next != null ){
            ListNode n1 = curr.next;
            ListNode n2 = curr.next.next;
            
            curr.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            
            curr = n1;

        }
        return dummy.next;
    } 
    
    public static void main(String[] args) {
        ListNode l1 = Helper.getTestListNode();
        Helper.printList(l1);
        ListNode sol = swapPairs(l1);
        Helper.printList(sol);   
    }
}
