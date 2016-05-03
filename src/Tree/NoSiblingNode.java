/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Sam
 */
public class NoSiblingNode {
    
    
    public static List<Float> findNoSibling(FloatTreeNode root){
        
        List<Float> sol = new ArrayList<Float>();
        Stack<FloatTreeNode> stack = new Stack<FloatTreeNode>();
//        FloatTreeNode prev = null;
        sol.add(root.val);
        
        while( root != null || !stack.isEmpty() ){
            if( root != null ){
                stack.push(root);
                if( root.left == null && root.right != null ) sol.add(root.right.val);
                if( root.left != null && root.right == null ) sol.add(root.left.val);
                root = root.left;
            }else{
                root = stack.pop();
                root = root.right;
            }
        }
        return sol;
    }
    public static void main(String[] args) {
//        TreeNode testTree = TestTree.getTestTree();
        FloatTreeNode n7 = new FloatTreeNode(7);
        FloatTreeNode n6 = new FloatTreeNode(6);
        FloatTreeNode n8 = new FloatTreeNode(8);
        FloatTreeNode n5 = new FloatTreeNode(5);
        FloatTreeNode n75 = new FloatTreeNode(7.5F);
        FloatTreeNode n85 = new FloatTreeNode(8.5F);
        
        n7.left = n6;
        n6.left = n5;
        n7.right = n8;
        n8.left = n75;
        n75.right = n85;

        List<Float> sol = findNoSibling(n7);
        System.out.println(sol.toString());
    }
    
}
