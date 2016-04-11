/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Sam
 */
public class SerializeAndDeserializeBinaryTree {
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString( root, sb );
        return sb.toString();
    }
    
    
    /*  pre-order traversal.
     */
    private static void buildString(TreeNode node, StringBuilder sb) {
        if( node == null ){
            sb.append("#").append(',');
            return;
        }else {
            sb.append(node.val).append(',');
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(",")));        
//        System.out.println(queue.toString());
        TreeNode root = buildTree(queue);
        return root;
    }
    
    private static TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if( val.equals("#") ) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
    public static void main(String[] args) {
        TreeNode root = TestTree.getTestTree();
        String serialized_tree = serialize(root);
        System.out.println(serialized_tree);
        
        TreeNode newRoot = deserialize( serialized_tree ); 
        
        // print tree.
        TreeTraversal tt = new TreeTraversal();
        List<Integer> list = tt.inOrderTraversal(newRoot);
        System.out.println(list.toString());
        
    }    
}
