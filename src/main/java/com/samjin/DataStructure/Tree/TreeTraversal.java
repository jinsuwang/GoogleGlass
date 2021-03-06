package com.samjin.DataStructure.Tree;

import java.util.* ;
import java.util.Map.Entry;
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
    
    /*  
        Inorder traversal 
    */
    
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
    
    public static List<Integer> inorderTraversalIter( TreeNode root ){
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while( !stack.isEmpty() || root != null ){
            if( root != null ){
                stack.push(root);
                root = root.left;
            }else{
                TreeNode curr = stack.pop();
                ret.add( curr.val );
                root = curr.right;
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
    
    public static List<Integer> preOrdertraversalIter( TreeNode root ){
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while( !stack.isEmpty() || root != null ){
            if( root != null ){
                ret.add( root.val );
                stack.push(root);
                root = root.left;
            }else{
                TreeNode curr = stack.pop();
                root = curr.right;
            }
        }
        return ret;
    }
    /*
        POST Order Traversal 
    */
    
    public static List<Integer> postOrderTraversalRecur( TreeNode root ){
        List<Integer> ret = new ArrayList<Integer>();
        postHelper( root, ret );
        return ret;
    }
    
    private static void postHelper(TreeNode root, List<Integer> ret) {
        if( root == null ) return;
        postHelper( root.left, ret );
        postHelper( root.right, ret );
        ret.add( root.val );
    }
    
    
    public static List<Integer> postOrderTraversalIter( TreeNode root ){
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Boolean> tag = new Stack<Boolean>();
        
        while( !stack.isEmpty() ){
            if( root != null ){
                stack.push(root);
                tag.push( false );
                root = root.left;
            }else{
                boolean visit = tag.pop();
                if(visit){
                    ret.add(stack.pop().val);
                }else{
                    tag.push(true);
                    root = stack.peek().right;
                }
            }
        }
        return ret;
    }
    

    
//    public static ArrayList<String> levelOrderTraversal( ScoreTreeNode root ){
//        ArrayList<String> ret = new ArrayList<>();
//        Queue<ScoreTreeNode> queue = new LinkedList<ScoreTreeNode>();
//        queue.offer(root);
//        while( !queue.isEmpty() ){
//            ScoreTreeNode node = queue.poll();
//            if( node == null ) ret.add("");
//            else{
//                ret.add(node.val+":"+node.count);
//                // leaf node
//                if( node.left == null && node.right == null ) continue;
//                queue.offer(node.left);
//                queue.offer(node.right);
//            }            
//        }
//        return ret;
//    }
    
    
      public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(level);
        }

        return result;
    }
      
      
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        vdfs( root, map, 0 );
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        for( Integer e : map.keySet() ){
            sol.add( map.get(e) );
        }
        return sol;
    }
    
    private static void vdfs(TreeNode root, Map<Integer, List<Integer>> map, int offset) {
        if( root == null ) return;
        if( !map.containsKey(offset) ){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(root.val);
            map.put(offset, tmp);
        }else{
            List<Integer> tmp = map.get(offset);
            tmp.add(root.val);
            map.put(offset, tmp);
        }
        vdfs( root.left, map, offset-1);
        vdfs( root.right, map, offset+1);

    }
    
    public static void main(String[] args) {
//        TreeNode root = TestTree.getTestTree();
////        List<Integer> list = postOrderTreaversalIter( root );
////        System.out.println( list.toString() );
//
//        List<List<Integer>> sol = verticalOrder(root);
//        for( List<Integer> e : sol ){
//            System.out.println(e.toString());
//        }
          
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        
        Entry<Integer, String> e = map.ceilingEntry(1);
        System.out.println( e.getKey() );

    }
}
