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
public class BinaryTreeLongestConsecutiveSequence {
    
    private static  int max = 1;
    public  static int longestConsecutive(TreeNode root) {
        if( root == null ) return 0;
        dfs( root.left, root.val, 1 );
        dfs( root.right, root.val, 1 );
        return max;
    }

    private static void dfs( TreeNode root, int pre, int count ) {
        if( root == null ) return;
        count = root.val == pre+1 ? count+1 : 1; 
        max = Math.max(count, max);
        dfs( root.left, root.val, count );
        dfs( root.right, root.val, count );
    }
    
    public static void main(String[] args) {
        TreeNode n1 =  new TreeNode(1);
        TreeNode n2 =  new TreeNode(2);
        TreeNode n22 = new TreeNode(2);

        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        
//        n1.right = n3;
//        n3.left  = n2;
//        n3.right = n4;
//        n4.right = n5;

        n2.right = n3;
        n3.left = n22;
        n22.left = n1;
        
        System.out.println( longestConsecutive( n2 ));
    }
}
