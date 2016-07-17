/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company;

import LinkedList.ListNode;

/**
 *
 * @author Sam
 */
public class InsertIntoCycleLinkedList {
    public static ListNode insert(ListNode node,int val){
        
        if( node == null ) return new ListNode(val);
        ListNode curr = node;
        ListNode prev = null;
        do{
            prev = curr;
            curr = curr.next;
            // case1:  prev.val <= val <= curr.val; sol: insert between
            if ( val >= prev.val && val <= curr.val ) break;
            // case2: val is the min of list or val is the max if list; sol: insert before smallest val
            if ( prev.val > curr.val && ( val > prev.val || val < curr.val )) break;
        }while( curr != node );
        ListNode newNode = new ListNode(val);
        newNode.next = curr;
        prev.next = newNode;
        return newNode;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2; l2.next = l4; l4.next = l5; l5.next = l6; l6.next = l1;
        printList(l1);
        ListNode newList = insert(l1, 3);
        printList(newList);
        
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
}
