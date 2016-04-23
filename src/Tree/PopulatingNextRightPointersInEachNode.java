/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author Sam
 */
public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        
        if( root == null ) return;
        if( root.left != null ){
            root.left.next = root.right;
        } 
        if( root.right != null ){
            root.right.next = root.next != null ? root.next.left : null;
        }
        connect( root.left );
        connect( root.right);
    }
    
    
    /* Follow Up */
    public void connect2(TreeLinkNode root) {
        
        if( root == null ) return;
        // find next node.
        TreeLinkNode tmp = root.next;
        while( tmp != null ){
            if( tmp.left != null ){
                tmp = tmp.left;
                break;
            }
            
            if( tmp.right != null ){
                tmp = tmp.right;
                break;
            }
            // move to next one.
            tmp = tmp.next;
        }
        
        if( root.right != null ){
            root.right.next = tmp;
        }
        if( root.left != null ){
            root.left.next = root.right == null ? tmp : root.right;
        }
        connect( root.right );
        connect( root.left );
    }
}
