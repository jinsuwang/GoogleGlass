/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import Tree.TestTree;
import Tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        
        if( root == null ) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        
        int level = 1;
        
        while( !queue.isEmpty() ){
            Deque<Integer> tmp = new LinkedList<Integer>();
            int size = queue.size();
            for( int i = 0 ; i < size; i++ ){
                TreeNode curr = queue.poll();
                if( level % 2 == 1 ){
                    tmp.offerLast( curr.val );
                }else{
                    tmp.offerFirst(curr.val);
                }
                if(  curr.left != null ) queue.offer(curr.left);
                if(  curr.right != null ) queue.offer(curr.right);
            }        
            sol.add((List<Integer>) tmp);
            level++;
        }
        return sol;
    }
    
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        List<List<Integer>> sol = zigzagLevelOrder(root);
        for( List<Integer> e : sol ){
            System.out.println(e.toString());
        }
    }
}
