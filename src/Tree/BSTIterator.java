/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    private TreeNode curr;
    
    
    public BSTIterator(TreeNode root) {
        curr = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return ( curr != null || !stack.isEmpty() );
    }

    /** @return the next smallest number */
    public int next() {
        while( curr != null ){
            stack.push( curr );
            curr = curr.left;
        }
        curr = stack.pop(); // find left most. 
        int ret = curr.val;
        curr = curr.right;
        return ret;
    }
    public static void main(String[] args) {   
        TreeNode tt = TestTree.getTestTree();
        BSTIterator it = new BSTIterator(tt);
        while( it.hasNext() ){
            System.out.println(it.next());
        }
    }
}
