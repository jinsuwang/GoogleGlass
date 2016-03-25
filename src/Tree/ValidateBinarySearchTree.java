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
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        TreeNode pre = null;
        while( !stack.isEmpty() || curr != null ){
            if( curr != null ){
                stack.push( curr );
                curr = curr.left;
            }else{
               curr = stack.pop();
               if( pre != null && curr.val <= pre.val ) return false;
               pre = curr;
               curr = curr.right;
            }
        }
        return true;
    }   
}
