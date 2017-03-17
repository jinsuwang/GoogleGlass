/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

/**
 *
 * @author Sam
 */
public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    
    private int[] preorder;
    private int[] inorder;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if( preorder == null || inorder ==null || preorder.length != inorder.length ){
            return null;
        }
        
        this.preorder = preorder;
        this.inorder = inorder;
        
        return recursiveBuild( 0, inorder.length-1, 0 ); 
    }

    private TreeNode recursiveBuild(int left, int right, int rootPos){
        
        if( left > right ) return null;
        
        // build new TreeNode
        int tmp = preorder[rootPos];
        TreeNode root = new TreeNode( tmp );
        // find position in inorder array.
        int pos = findPosition( tmp );
         
        // pos - 1 is next smaller one
        root.left = recursiveBuild( left, pos-1, rootPos+1 );
        root.right = recursiveBuild( pos+1, right, rootPos+1+(pos-left));
        return root;
    }
    
    private int findPosition( int key ){
        for( int i = 0; i <= this.inorder.length; i++ ){
            if( this.inorder[i] == key ) return i;
        }
        return -1;
    }
}
