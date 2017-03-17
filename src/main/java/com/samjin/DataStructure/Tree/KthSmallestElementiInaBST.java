/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class KthSmallestElementiInaBST {
    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while( curr != null || !stack.isEmpty() ){
            if( curr != null ){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                k--;
                if( k == 0) return curr.val;
                curr = curr.right;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        System.out.println(kthSmallest( root, 4));
    }
}
