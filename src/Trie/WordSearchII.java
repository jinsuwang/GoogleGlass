/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class WordSearchII {
    
    private class TrieNode{
        String s;
        boolean isString;
        Map<Character, TrieNode> subtree;
        public TrieNode(){
            isString = false;
            subtree = new HashMap<Character,TrieNode>();
            s = "";
        }
    }
    
    private class TrieTree{
        TrieNode root;
        public TrieTree( TrieNode root){
            this.root = root;
        }
    }
}
