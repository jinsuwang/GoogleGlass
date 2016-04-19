package Tree;
import Tree.TreeNode;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class TestTree {
    public static TreeNode getTestTree(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        return n4;
    } 
    
    public static TreeNode getTestTree2(){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n6;
        n6.left = n5;
        n6.right = n7;
        return n4;
    }
}
