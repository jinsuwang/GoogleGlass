/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import Tree.TestTree;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class SerilizeAndDeserilizeTree {
    
    
    // Recursive
    public static String serialize(TreeNode root) {
        
        StringBuffer sb = new StringBuffer();
        buildString(root, sb );
        return sb.toString().substring(0, sb.length()-1);
    }
    
    private static void buildString(TreeNode root, StringBuffer sb) {
        
        if( root == null ){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        buildString( root.left, sb );
        buildString( root.right, sb );
    }    

    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        String[] strs = data.split(",");
        queue.addAll( Arrays.asList(strs) );
        return buildTree( queue );
    }
    
    private static TreeNode buildTree(Queue<String> queue) {
        String curr = queue.poll();
        if( curr.equals("#") ) return null;
        
        TreeNode node = new TreeNode(curr);
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }

    
    // Iterative
    public static String BFSserialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuffer sb = new StringBuffer();
        queue.add(root);
        
        while( !queue.isEmpty() ){
            TreeNode n = queue.poll();
            if( n == null ){
                sb.append("#").append(",");
            }else{
                queue.add(n.left);
                queue.add(n.right);
                sb.append(n.val).append(",");
            }
        }
        return  sb.toString().substring(0, sb.length()-1);
    }
    
    
    public static TreeNode BFSderialize( String str ){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode dummy = new TreeNode("#");
        
        queue.add(dummy);
        str = "#," + str;
        String[] nodes = str.split(",");
        
        int i = 0;
        
        while( !queue.isEmpty() && i < nodes.length  ){
            TreeNode curr = queue.poll(); 
            
            if( curr != null ){
                
                TreeNode left = null, right = null;
                              
                if( i < nodes.length && !nodes[i].equals("#") ){
                    left = new TreeNode( nodes[i] );
                    curr.left = left;
                }
                i++;
                if( i < nodes.length && !nodes[i].equals("#")){
                    right = new TreeNode( nodes[i] );
                    curr.right = right;
                }
                i++;
                queue.add(left);
                queue.add(right);
                
            }
        }
        return dummy.right;
    }

    
    
    public static void main(String[] args) {
        
        TreeNode n4 = new TreeNode("4");
        TreeNode n2 = new TreeNode("2");
        TreeNode n1 = new TreeNode("1");
        TreeNode n3 = new TreeNode("3");
       
        TreeNode n6 = new TreeNode("6");
        
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;
        n4.right = n6;

        String s = BFSserialize(n4);
        System.out.println(s);
        TreeNode root = BFSderialize(s);
        System.out.println(BFSserialize(root));
    }
}
