/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.SearchAndSort;

import LinkedList.ListNode;

/**
 *
 * @author Sam
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if( lists == null || lists.length == 0) return null;
        return mergeKListHelper(lists, 0, lists.length -1 );
    }

    public ListNode mergeKListHelper(ListNode[] lists, int start, int end) {
        if(start < end){
            int mid = start +( end - start )/2;
            return mergeTwoSortedList( mergeKListHelper( lists, start, mid ),
                    mergeKListHelper(lists, mid+1, end ) ) ;
        }
        return lists[start];
    }
    
    public ListNode mergeTwoSortedList( ListNode n1, ListNode n2 ){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while( n1 != null && n2 != null ){
            if( n1.val < n2.val ){
                curr.next = n1;
                n1 = n1.next;
            }else{
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        if( n1 == null) curr.next = n2;
        else curr.next = n1;
        return dummy.next;
    }   
    
    public static void main(String[] args) {
//        int[] test = {1,2,3,4};
//        Set<Integer> set = new HashSet<Integer>();

        
        
    }
    
}
