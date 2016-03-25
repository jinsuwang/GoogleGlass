/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import Tree.TreeNode;
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
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while( !queue.isEmpty() ){
            TreeNode node = queue.poll();
            if( node == null ) sb.append("null,");
            else{
                sb.append(String.valueOf(node.val));
                queue.offer( node.left );
                queue.offer( node.right );
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if( data == null ) return null;
        List<String> list = Arrays.asList(data.split(","));
        return buildTree(list);
    }

    private TreeNode buildTree(List<String> list) {
        String curr = list.remove();
        if( curr == "null" ) return null;
        else{
            TreeNode node = new TreeNode(Integer.valueOf(curr));
            node.left = buildTree(list);
            node.right = buildTree(list);
        }
    }
    
}
