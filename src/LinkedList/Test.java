/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.Hashtable;

/**
 *
 * @author Sam
 */
public class Test {
    
    
   public static ListNode compress( ListNode head, int n ){
       
       if( head == null ) return head;
       
       ListNode curr = head;
       ListNode prev = head;
       int count = 0;
       
       while( curr != null ){
           count++;
           prev.val += curr.val;
           if( count == n ){
               System.out.println(prev.val + "pre");

               System.out.println(curr.val + "cur");
               
             
               prev.next = curr.next;
               count = 0;
               prev = curr.next;
           }
           curr = curr.next;
       }
       return head;
          
   }
   
   

    public static void main(String[] args) {
        
//        ListNode head = Helper.getTestListNode();
//        ListNode head = new ListNode(1);
//        ListNode l2 = new ListNode(2);
//        head.next = l2;
//
//        Helper.printList(head);
//        ListNode newHead = compress2(head,100);
//        Helper.printList(newHead);
            Hashtable<String,String> hs = new Hashtable<String,String>();
            hs.get("xxx");

   
    }
}
