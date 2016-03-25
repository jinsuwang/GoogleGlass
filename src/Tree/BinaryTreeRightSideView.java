/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class BinaryTreeRightSideView {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if( root == null ) return ret;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            int size = queue.size();
            for( int i = 0; i < size; i++ ){
                TreeNode n = queue.poll();
                if( i == 0 ) ret.add( n.val );
                if( n.right != null) queue.offer(n.right);
                if( n.left != null ) queue.offer(n.left);
            }            
        }
        return ret;
    }
}
