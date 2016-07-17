/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import LinkedList.ListNode;

/**
 *
 * @author Sam
 */
public class MergeKSortedList {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0 ) return null;
        return divide( lists, 0, lists.length-1 ); 
    }

    private ListNode divide(ListNode[] lists, int left, int right) {
        if( left < right ){
            int mid = left + ( right - left )/2;
            return merge( divide(lists, left, mid), divide(lists, mid+1, right));
        }
        return lists[left];
        
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while( l1 != null && l2 != null ){
            if( l1.val <= l2.val ){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if( l1 != null ){
            curr.next = l1;
        }else if( l2 != null ){
            curr.next = l2;
        }
        
        return dummy.next;
        
    }
}
