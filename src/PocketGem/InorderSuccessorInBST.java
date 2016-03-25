/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PocketGem;

import Tree.TreeNode;

/**
 *
 * @author Sam
 */
public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
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
}
