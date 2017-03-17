/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

/**
 *
 * @author Sam
 */
public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if( root == null ) return true;
        return helper( root.left, root.right );
    }

    private static boolean helper(TreeNode left, TreeNode right) {
        
        if( left == null && right == null) return true;
        if( left == null || right == null) return false;
        if( left.val != right.val ) return false;
        return helper(left.left, right.right ) && helper(left.right, right.left);
    }
    
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree2();
        System.out.println(isSymmetric(root));
    }
}
