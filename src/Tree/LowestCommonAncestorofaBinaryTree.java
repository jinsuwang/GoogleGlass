/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;
import Tree.TreeNode;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class LowestCommonAncestorofaBinaryTree {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null ) return null;
        if( root == p || root == q ) return root;
        
        TreeNode left = lowestCommonAncestor( root.left , p, q);
        TreeNode right = lowestCommonAncestor( root.right, p, q);
        
        if( left != null && right != null ){
            return root;
        }else if ( left != null ){
            return left;
        }else if( right != null ){
            return right;
        }else{
            return null;
        }
    }
    
    public static TreeNode lowestCommonAncestorSet(TreeNode root, Set<TreeNode> set ) {
        if( root == null ) return null;
        if( set.contains(root) ) return root;
        
        TreeNode left = lowestCommonAncestorSet( root.left , set);
        TreeNode right = lowestCommonAncestorSet( root.right, set);
        
        if( left != null && right != null ){
            return root;
        }else if ( left != null ){
            return left;
        }else if( right != null ){
            return right;
        }else{
            return null;
        }
    }
    
    public static void main(String[] args) {
        TreeNode tt = TestTree.getTestTree();
        TreeNode n2 = tt.left;
        TreeNode n1 = n2.left;
        TreeNode n6 = tt.right;
        Set<TreeNode> set = new HashSet<TreeNode>();
        set.add(n2); set.add(n1); set.add(n6);
        TreeNode lca = lowestCommonAncestorSet(tt, set);
        System.out.println(lca.val);
    }
    
    
    
    
    
    /*
        Have Parent!
    int getHeight(Node p){
        int height = 0;
        while(p!=null){
            height++;
            p = p.parent;
        }
        return height;
    }
    
    void swap(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
    }
    
    Node getLCA(Node p, Node q){
        int h1 = getHeight(p);
        int h2 = getHeight(q);
        
        //q is always deeper than p
        if(h1 > h2){
            swap(h1, h2);
            swap(p, q);
        }
        
        int diff = h2 - h1;
        
        for( int i = 0; i < diff; i++)
            q = q.parent;
        
        while(p!=null && q!=null){
            //common node
            if(p == q)
                return p;
            p = p.parent;
            q = q.parent;
        }
        
        return NULL; //p and q are not in the same tree

        */
    
}
