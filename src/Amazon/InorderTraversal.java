/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

import Tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class InorderTraversal {
    
    public static ArrayList<Integer> ret = new ArrayList<Integer>();
    public static void inorderTraversal(TreeNode root){        
        if( root == null ) return;
        inorderTraversal(root.left);
        ret.add(root.val);
        inorderTraversal(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        inorderTraversal(root);
        System.out.println(ret.toString());
    }
}
