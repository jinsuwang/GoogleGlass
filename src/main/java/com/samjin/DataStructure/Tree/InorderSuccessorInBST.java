/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

import Tree.TestTree;
import Tree.TreeNode;

/**
 *
 * @author Sam
 */
public class InorderSuccessorInBST {
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while( root != null && root.val != p.val ){
            // move to left one to find smaller;
            if(root.val > p.val ){ 
                successor = root;
                root = root.left;
            }else{
                // move to right to find bigger
                root = root.right;
            }
        }
        // not find p
        if ( root == null ) return null;
        // root is leaf node.
        if ( root.right == null ) return successor;
        // root is not leaf node, find next one;
        root = root.right;
        while( root.left != null ){
            root = root.left;
        }
        return root;
    }
    
    public static TreeNode nextNode(TreeNode node){
            if (node.right != null) {
                TreeNode curr = node.right;
                while (curr.left != null) {
                    curr = curr.left;
                }
                return curr;
            }else {
                TreeNode curr = node;
                // make sure you are not right node.
                while (curr.parent != null && curr == curr.parent.right) {
                    curr = curr.parent;
                }
                return curr.parent;
            } 
    }
    
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        TreeNode node = root.left;
        TreeNode ret = inorderSuccessor( root , node );
        System.out.println(ret.val);
    }
}
