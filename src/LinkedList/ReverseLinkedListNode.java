/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Sam
 */
public class ReverseLinkedListNode {
    public static ListNode reverseList(ListNode head) {
        
        if( head == null ){
            return head;
        }
        ListNode current = head;
        ListNode pre = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
//        return head;
    }
    
    public static void reversedPrint( ListNode head ){
        if( head == null ) return;
        reversedPrint( head.next );
        System.out.println( head.val );
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        
        ListNode n5 = reverseList(n1);
        Helper.printList(n5);
        

    }
}
