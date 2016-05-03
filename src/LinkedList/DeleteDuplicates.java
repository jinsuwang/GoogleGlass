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
    
    
    
}
