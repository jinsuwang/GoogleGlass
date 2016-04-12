/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Tree.TreeNode;
import Tree.TreeTraversal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Sam
 */
public class TrinaryExpression {
    
    public static TreeNode convertTEtoTree(String expr){
        if( expr == null || expr.length() == 0 ) return null;
        TreeNode node = new TreeNode(expr.charAt(0));
        TreeNode root = node;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for( int i = 1; i < expr.length(); i += 2){
            if( expr.charAt(i) == '?' ){
                node.left = new TreeNode( expr.charAt(i+1) );
                stack.push(node);
                node = node.left;  
            }else if( expr.charAt(i) == ':') {
                node = stack.pop();
                while( node.right != null ){
                    node = stack.pop();
                }
                node.right = new TreeNode( expr.charAt(i+1) );
                stack.push(node);
                node = node.right;
            }       
        }
        return root;
    }
    
    public static void main(String[] args) {
        String test = "a?b?c:d:e";
        TreeNode node = convertTEtoTree(test);
        TreeTraversal tt = new TreeTraversal();
        ArrayList<Integer> ret =  tt.inOrderTraversal(node);
        System.out.println(ret);
    }
    

    String infixToPostfix( String expr ){
        StringBuilder res = new StringBuilder();
        Queue<Character> queue = new LinkedList<Character>();
        for( int i=0; i < expr.length(); i++ ){
            char c = expr.charAt(i);
            if( c == '?' || c == '('){
                // enqueue none char
                queue.add(c);
            }else if( c == ')'){
                
            }else if( Character.isAlphabetic(c) ){
            }
        }
        return res.toString();
    } 
}
