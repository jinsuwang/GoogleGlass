/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class BinaryTreePaths {
    
    public static List<String> binaryTreePaths(TreeNode root) {
        
        List<String> sol = new ArrayList<String>();
        if( root == null ) return sol;
        List<Integer> path = new ArrayList<Integer>();
        dfs( sol, path, root );
        return sol;
    }

    private static void dfs(List<String> sol, List<Integer> path, TreeNode root) {
        if( root == null ) return ;
        if( root.left == null && root.right == null ){
            path.add( root.val );
            sol.add( convertToSol(path) );
            path.remove( path.size()-1 );
            return;
        }else{
            path.add( root.val );
            dfs( sol, path, root.left );
            dfs( sol, path, root.right );
            path.remove( path.size()-1 );
        }
    }

    private static String convertToSol(List<Integer> path) {
        StringBuilder s = new StringBuilder();
        for( int i = 0; i < path.size(); i++ ){
            s.append(path.get(i));
            if( i !=  path.size()-1 ) s.append("->");
        }
        return s.toString();
    }
    
    public static void main(String[] args) {
        TreeNode tree = TestTree.getTestTree();
        List<String> sol = binaryTreePaths(tree);
        System.out.println(sol.toString());
    }
}
