/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class SumRoottoLeafNumbers {
    
    public int sumNumbers(TreeNode root) {
         return sumNumbersDFS( root, 0 );
    }
    
    public int sumNumbersDFS( TreeNode root, int num){
        if( root == null ) return 0;
        if( root.left == null && root.right == null ){ // touch the leaf
            return num * 10 + root.val;
        }
        return sumNumbersDFS(root.right, num*10 + root.val) + sumNumbersDFS( root.left, num*10+root.val ) ;            
    }
    
    public int sumNumbersStack( TreeNode root ){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        return 0;
    } 
}
