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
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if( headA == null || headB == null ){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        ListNode tailA = null;
        ListNode tailB = null;
        while( true ){
            if( pA == null ) pA = headB;
            if( pB == null ) pB = headA;
            if( pA.next == null ) tailA = pA;
            if( pB.next == null ) tailB = pB;
            if ( tailA != null && tailB != null && tailA != tailB ) return null;
            if( pA == pB ) return pA;
            pA = pA.next;
            pB = pB.next;
        }
    }
}
