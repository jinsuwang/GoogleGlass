/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class ConvertSortedArraytoBinarySearchTree {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if( nums == null || nums.length == 0) return null;
        if( nums.length == 1) return new TreeNode(nums[0]);
        return constructTree( nums, 0 , nums.length );
    }

    private static TreeNode constructTree(int[] nums, int start, int end) {
        if( start >=  end ) return null;
        int mid = start + ( end - start )/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = constructTree( nums, start, mid  );
        node.right = constructTree( nums, mid + 1, end );
        return node;
    }
    
    public static void main(String[] args) {
        InorderTraversal iot = new InorderTraversal();
        int[] testArr = { 1,2,3,4,5,6,7 };
        TreeNode root = sortedArrayToBST( testArr );
        ArrayList<Integer> list = iot.inOrderTraversal(root);
        System.out.println(list.toString());
    }
}
