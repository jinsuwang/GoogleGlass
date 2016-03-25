package Tree;

import Amazon.*;
import java.util.* ;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam
 */
public class TreeTraversal {
    public static ArrayList<Integer> inOrderTraversal( TreeNode root ){
        ArrayList<Integer> ret = new ArrayList<>();
        inOrderTraversalRecur(root, ret);
        return ret;
    }
    
    private static void inOrderTraversalRecur(TreeNode root, ArrayList<Integer> ret) {
        if( root == null ) return;
        inOrderTraversalRecur( root.left, ret);
        ret.add(root.val);
        inOrderTraversalRecur( root.right, ret );
    }
    
    
    
    public static ArrayList<String> levelOrderTraversal( ScoreTreeNode root ){
        ArrayList<String> ret = new ArrayList<>();
        Queue<ScoreTreeNode> queue = new LinkedList<ScoreTreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            ScoreTreeNode node = queue.poll();
            if( node == null ) ret.add("");
            else{
                ret.add(node.val+":"+node.count);
                // leaf node
                if( node.left == null && node.right == null ) continue;
                queue.offer(node.left);
                queue.offer(node.right);
            }            
        }
        return ret;
    }
    
    
    public static ArrayList<String> preOrderTraversal( ScoreTreeNode root ){
        ArrayList<String> ret = new ArrayList<>();
        preOrderTraversalRecur(root, ret);
        return ret;
    }
   
    private static void preOrderTraversalRecur(ScoreTreeNode root, ArrayList<String> ret) {
        if( root == null ) {
            ret.add("");
            return;
        }
        ret.add(root.val+":"+root.count);
        preOrderTraversalRecur( root.left, ret);
        preOrderTraversalRecur( root.right, ret );
    }
    
    
    
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        ArrayList<Integer> list = inOrderTraversal( root );
        System.out.println( list.toString() );
    }
}
