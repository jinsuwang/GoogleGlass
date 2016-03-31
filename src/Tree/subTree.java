/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Tree.TreeNode;

/**
 *
 * @author Sam
 */
public class subTree {
    
    public static int check1(TreeNode t1, TreeNode t2) {
        if (t2 == null) return 1;
        return subTree(t1, t2) ? 1 : -1; 
    }

    private static boolean subTree(TreeNode t1, TreeNode t2) {
        if ( t1 == null ) return false;
        else if( t1.val == t2.val && isSameTree(t1,t2) ) return true;
        return subTree(t1.left, t2) || subTree( t1.right, t2 );
    }

    private static boolean isSameTree(TreeNode t1, TreeNode t2) {
        if( t1 == null && t2 == null) return true;
        else if( t1 == null || t2 == null ) return false;
        else if( t1.val != t2.val ) return false;
        return isSameTree( t1.left, t2.left ) && isSameTree( t1.right, t2.right );
    }
}
