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
public class ConstructBinaryTreefromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if( preorder == null || inorder ==null || preorder.length != inorder.length ){
            return null;
        }
        int len = inorder.length;
        return recursiveBuild( inorder, 0 , len-1, preorder, 0, len-1 ); 
    }

    private TreeNode recursiveBuild(int[] inorder, int instart, int inend, 
            int[] preorder, int prestart, int preend) {
        
        if( instart > inend ) return null;
        
        int tmp = preorder[prestart];
        TreeNode root = new TreeNode( tmp );
        int pos = findPosition(inorder, instart, inend, tmp );
         
        // pos - 1 is next smaller one
        root.left = recursiveBuild( inorder, instart, pos-1, preorder, prestart+1, prestart+pos-instart);
   
        root.right = recursiveBuild( inorder, pos+1, inend, preorder,
                pos - inend + preend+1, preend );
        
        return root;
    }
    
    private int findPosition( int[] arr, int start, int end, int key ){
        for( int i = 0; i <= end; i++ ){
            if( arr[i] == key ) return i;
        }
        return -1;
    }
}
