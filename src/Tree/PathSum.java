/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author Sam
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        
        if( root == null ) return false;
        if( root.left == null && root.right == null &&
                root.val == sum ){
            return true;
        } 
        return hasPathSum( root.left, sum - root.val) ||  hasPathSum( root.right, sum - root.val);
        
    }
}
