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
public class CopyListWithLoop {
    public static ListNode copyList(ListNode head) {
        if( head == null ) return null;
        int  count  = 0;
        ListNode intersect = getIntersect( head );
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while( head != null && count < 2 ){
            ListNode node = new ListNode(head.val);
            curr.next = node;
            head = head.next;
            curr = curr.next;
            if( head == intersect ) count++;
        }
        return dummy.next;
    }
    
    
    private static ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while( fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
            if( slow == fast ){
                fast = head;
                while( fast != slow ){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n4;
        
        ListNode newHead = copyList(n1);
        ListNode intersect = getIntersect(newHead);
        while( newHead != null ){
            System.out.println(newHead.val);
            newHead = newHead.next;
        } 
//        System.out.println(intersect.val);

    }
}
