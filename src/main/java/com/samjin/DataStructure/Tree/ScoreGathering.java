/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Tree;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */

class ScoreTreeNode{
    public int count;
    public int val;
    public ScoreTreeNode left;
    public ScoreTreeNode right;
    ScoreTreeNode( int val ){
        this.val = val;
        this.count = 1;
    } 
} 
        
           
public class ScoreGathering {
    public static ScoreTreeNode constructTree(ArrayList<Integer> stream){
        ScoreTreeNode root = null;
        for( int i = 0; i < stream.size(); i++ ){
            if( root == null ){
                root = new ScoreTreeNode(stream.get(i));
                root.count = 1;
            }else{
                ScoreTreeNode curr = root;
                ScoreTreeNode parent;
                while( true ){
                    parent = curr;
                    if( stream.get(i) == curr.val ){
                        curr.count++;
                        break;
                    }else if( stream.get(i) < curr.val ){
                        curr = curr.left;
                        if( curr == null ){
                            parent.left = new ScoreTreeNode(stream.get(i));
                            break;
                        }
                    }else{
                        curr = curr.right;
                        if( curr == null ){
                            parent.right = new ScoreTreeNode(stream.get(i));
                            break;
                        }
                    }
                }
            }
        }
       return root;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4); list.add(2); list.add(5);
        list.add(5); list.add(6); list.add(1); list.add(4);
        // List to Tree
        ScoreTreeNode root = constructTree( list );
        // preOrderTraversal;
        TreeTraversal tt = new TreeTraversal();
        ArrayList<String> ret = tt.levelOrderTraversal(root);
        
        // to String
        StringBuilder sb = new StringBuilder();
        for( String s : ret){
           sb.append(s).append(',');
        }
        sb.deleteCharAt(sb.length()-1); //delete last comma
        String newString = sb.toString();
        System.out.println(newString);
    }
}
