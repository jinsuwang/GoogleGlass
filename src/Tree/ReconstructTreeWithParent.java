/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class ReconstructTreeWithParent {


    
    private static class Node{
        char val;
        Node left;
        Node right;
        Node parent;
        
        Node(char c){
            this.val = c;
        }
    }
    
    public static Node reconstructTree( Node[] leaf ){
        
        Node root = null; 
        // build graph
        Map<Node,List<Node>> graph = new HashMap<Node,List<Node>>();
        for( Node e : leaf ){
            if( e.parent == null ){ // root;
                root = e;
            }else{
                if( graph.containsKey(e.parent)) {
                    graph.get(e.parent).add(e);
                }else{
                    List<Node> tmp = new ArrayList<Node>();
                    tmp.add(e);
                    graph.put( e.parent, tmp );
                }
            }
        }
        
        buildTree( root, graph );
        return root;
    }
    
    private static void buildTree(Node root, Map<Node, List<Node>> graph) {
        if( graph.containsKey(root) ){
            for( Node e : graph.get(root) ){
                if( root.left == null ){
                    root.left = e;
                }else{
                    root.right = e;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        
        b.parent = a;
        c.parent = a;
        
        Node[] test = new Node[]{ a,b,c };
        Node root = reconstructTree(test);
        
        traversal( root );
        
    }
    
    private static void traversal(Node root) {
        if( root == null ) return;
//        System.out.println("Root: " + root.val + "left: " + root.left + " right: " +);
        traversal( root.left );
        traversal( root.right );
    }
}
