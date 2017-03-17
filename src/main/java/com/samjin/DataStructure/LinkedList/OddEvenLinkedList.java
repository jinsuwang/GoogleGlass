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
public class OddEvenLinkedList {
    
    public static ListNode oddEvenList(ListNode head) {
        
        ListNode odd = new ListNode(0);
        ListNode oddStart = odd;
        ListNode even = new ListNode(0);
        ListNode evenStart = even;

        int curr = 1;
        while( head != null ){
            if( curr % 2 == 1 ){
                odd.next = head;
                odd = odd.next;
            }else{
                even.next = head;
                even = even.next;
            }
            head = head.next;
            curr++;
        }
        //cut
        even.next = null;
        odd.next = evenStart.next;          
        return oddStart.next;
    }
    
    
    public static ListNode oddEvenList2(ListNode head) {
        if( head == null ) return head;
        ListNode p = head, q =head;
        while (q != null) {
            q = q.next;
            if( q == null || q.next == null ) break;
            ListNode next_p = p.next, next_q = q.next;
            q.next = next_q.next;
            p.next = next_q;
            next_q.next = next_p;
            p = p.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        
        ListNode l1 = Helper.getTestListNode();
        Helper.printList( oddEvenList2( l1 ));
//        oddEvenList( l1 );
        
    }
    
    
}
