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
public class LastMan {
    
    public static int findLastMan(ListNode head , int k){
        // find last man
        ListNode curr = head;
        ListNode prev = null;
        while( curr.next != null ) curr = curr.next;
        curr.next = head;
       
        while( head.next != head ){    
            int i = 1;
            while( i < k ){
                prev = head;
                head = head.next;
                i++;
            }
            prev.next = head.next;
            head = prev.next;
        }
        
        
        return head.val;
    }
    
    private static void printList( ListNode head ){
        ListNode curr = head;
        do{
            System.out.print( curr.val + "\t" );
            curr = curr.next;
        }while( curr != head );
        System.out.println("");         
    }
    
    public static void main(String[] args) {
        ListNode head = Helper.getTestListNode();
        System.out.println(  findLastMan( head,3 ));
    }
}
