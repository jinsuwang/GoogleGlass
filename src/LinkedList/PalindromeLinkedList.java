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
public class PalindromeLinkedList {
    
    public boolean isPalindrome(ListNode head) {
        
        if( head == null ) return true;
        ListNode curr = head;
        int nodeCount = 0;
        while (curr != null) {
            nodeCount++;
            curr = curr.next;
        }
        
        curr = head;
        ListNode newHead = null;
        
        for( int i = 0; i < nodeCount/2; i++){
            
            ListNode tmp = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = tmp;
        }
        
        if (nodeCount % 2 == 1) {
            curr = curr.next;
        }
        
        for (int jj = 0; jj < nodeCount/2; jj++) {
            if (curr.val != newHead.val) {
                return false;
            } else {
                curr = curr.next;
                newHead = newHead.next;
            }
        }
        return true;
        
    }
}
