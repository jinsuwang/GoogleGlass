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
public class ClosestBinarySearchTreeValue {
    
    private static double diff = Double.MAX_VALUE;
    private static int ret = Integer.MAX_VALUE;

    public static int closestValue(TreeNode root, double target) {
        if( target == root.val ) return root.val;
        double tmp = Math.abs(target - root.val);
        // check diff at first
        if( tmp < diff ){
            ret = root.val;
            diff = tmp;
        }
        if ( root.val > target ){
            if( root.left == null ) return ret;
            else return closestValue(root.left, target);
        }else{
            if( root.right == null ) return ret;
            else return closestValue(root.right, target);
        }
    }  
    public static void main(String[] args) {
        TreeNode root = new TreeNode( 0 );
        double target = 2147483648.0;
        System.out.println(closestValue(root, target ));
    }
}
