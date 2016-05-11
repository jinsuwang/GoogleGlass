/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class DeleteDuplicates {
    
    public ListNode deleteDuplicates(ListNode head) {
    ListNode curr = head;
        while( curr != null && curr.next != null ){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
    
    // follow up : only distinct number left
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr.next != null && curr.next.next != null){
                if(curr.next.val == curr.next.next.val ){
                        int value = curr.next.val;
                        while(curr.next != null && value == curr.next.val ){
                                curr.next = curr.next.next;
                        }
                }else{
                        curr = curr.next;
                }
        }
        return dummy.next;
    }
    
    // unsorted list
    public static ListNode deleteDuplicate3( ListNode head ){
        Set<Integer> set = new HashSet<Integer>();
        ListNode prev = head;
        ListNode sol = head;
        
        while( head != null ){
            if( set.contains(head.val)){
                prev.next = head.next;   
            }else{
                prev = head;
                set.add(head.val);
            }
            head = head.next;
        }
        return sol;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(7);
        ListNode l7 = new ListNode(7);

        l1.next = l2; l2.next = l3; l3.next =l4; l4.next =l5; l5.next =l6; l6.next= l7;
 
        ListNode sol = deleteDuplicate3(l1);
        Helper.printList(sol);
    }
    
}
