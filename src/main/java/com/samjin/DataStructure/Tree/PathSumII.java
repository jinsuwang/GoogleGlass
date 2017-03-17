/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> curr = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs( curr, root, ret, sum  );
        return ret;
    }

    private static void dfs(List<Integer> curr, TreeNode root, List<List<Integer>> ret, int sum) {
        if( root == null) return;

        if (root.left == null && root.right == null) {
            if (sum == root.val){
                curr.add(root.val);
                ret.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size()-1);
            }
            return;
        }else{
//            System.out.println(sum +"  root val:" +root.val);
            curr.add( root.val );
            dfs( curr, root.left, ret, sum - root.val );
            dfs( curr, root.right, ret, sum - root.val );
            curr.remove(curr.size()-1);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        List<List<Integer>> ret = pathSum( root, 7 );
        System.out.println(ret.size());
        for( List<Integer> e : ret ){
            System.out.println(e.toString());
        }
    }
}
