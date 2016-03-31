/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;
import Tree.TreeNode;
import Amazon.*;
import java.util.Stack;

/**
 *
 * @author Sam
 */
public class BinaryTreeMiminumSum {
    public static int sumNumbers(TreeNode root) {
        if( root == null ) return 0;
        if( root.left == null && root.right == null ) return root.val;
        int minSum = Integer.MAX_VALUE;
        Stack<TreeNode> pathNode = new Stack<TreeNode>();
        Stack<Integer> pathSum = new Stack<Integer>();
        pathNode.push(root);
        pathSum.push(root.val);
        while( !pathNode.isEmpty() ){
            TreeNode currNode = pathNode.pop();
            int currSum = pathSum.pop();
            if( currNode.left == null && currNode.right == null){
                System.out.println("find leaf: " + currSum );
                minSum = Math.min(minSum, currSum);
            }
            if( currNode.right != null ){
                pathNode.push(currNode.right);
                pathSum.push(currSum + currNode.right.val);
            }
            if( currNode.left != null ){
                pathNode.push(currNode.left);
                pathSum.push(currSum + currNode.left.val);
            }
        }
        return minSum;
    }
    
    private static void sumNumbersDFS(TreeNode root, int curr, int ret) {
        // touch the leaf
        // TODO
    }
    public static void main(String[] args) {
        TreeNode testTree = TestTree.getTestTree();
        int sum = sumNumbers(testTree);
        System.out.println( "Sum is: "+sum );
    }
}
