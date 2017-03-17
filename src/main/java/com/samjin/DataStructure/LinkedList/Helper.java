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
public class Helper {
       
    public static ListNode getTestListNode(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2; 
        l2.next = l3; 
        l3.next =l4; 
        l4.next =l5; 
        l5.next =l6; 
        l6.next= l7;
        return l1;
    }
    
    public static void printList( ListNode node ){
        while( node != null ){
            System.out.print(node.val );
            node = node.next;
        }
        System.out.println("");
    }
}
