/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Amazon.TestTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class BinaryTreeZigZagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if( root == null ) return ret;
        Queue<TreeNode> curr = new LinkedList<>();
        Integer level = 0;
        curr.offer( root );
        while( !curr.isEmpty() ){
            Queue<TreeNode> next = new LinkedList<>();
            List<Integer> tmpList = new ArrayList<Integer>();
            for( TreeNode n : curr ){
                if(level % 2 == 0){
                    tmpList.add( n.val );
                }else{
                    tmpList.add(0, n.val);
                }
                if( n.left != null ) next.add( n.left );
                if( n.right != null ) next.add( n.right );
            }
            ret.add(tmpList);
            level++;
            curr = next;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        TreeNode n1 = TestTree.getTestTree();
        List<List<Integer>> ret = zigzagLevelOrder(n1);
        for( List<Integer> list : ret){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
