/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class WordSearchII {
    
    private static class TrieNode{

        String s;
        Map<Character, TrieNode> subtree;
        boolean isWord;

        TrieNode(){
            s = "";
            subtree =  new HashMap<Character, TrieNode>();
            isWord = false;
        }
    }
    
    private static class Trie{
        TrieNode root;

        Trie(){
            this.root = new TrieNode();
        }
    
        public void insert( String s ){
            TrieNode now = root;
            for( int i = 0; i < s.length(); i++ ){
                if( !now.subtree.containsKey(s.charAt(i))){
                    now.subtree.put(s.charAt(i), new TrieNode() );
                }
                now = now.subtree.get(s.charAt(i));
            }
            now.s = s;
            now.isWord = true;
        }

        public boolean find( String s ){
            TrieNode now = root;
            for( int i = 0; i < s.length(); i++ ){
                if( !now.subtree.containsKey(s.charAt(i)) ){
                    return false;
                }
                now = now.subtree.get(s.charAt(i));
            }
            return now.isWord;
        }   
    }
    
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> sol = new ArrayList<String>();
        Trie trie = new Trie();
        
        for( String word : words ){
            trie.insert(word);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                search(board, i, j, trie.root, sol);
            }
        }
        return sol;
    
    }
    
    private static void search(char[][] board, int i, int j, TrieNode root, ArrayList<String> sol) {
        
        if( root.isWord && !sol.contains(root.s)){
            sol.add(root.s);
        }
        
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length ||  root == null ){
            return;
        }
        
        if( root.subtree.containsKey(board[i][j]) ){
            char curr = board[i][j];
            board[i][j] = '#';
            search( board, i+1, j, root.subtree.get(curr), sol );
            search( board, i, j+1, root.subtree.get(curr), sol );
            search( board, i-1, j, root.subtree.get(curr), sol );
            search( board, i, j-1, root.subtree.get(curr), sol );
            board[i][j] = curr;
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {
           {'o','a','a','n'},
           {'e','t','a','e'},
           {'i','h','k','r'},
           {'i','f','l','v'}
        };
        
        ArrayList<String> words = new ArrayList<String>( );
        words.add("oath");
        words.add("pea");
        words.add("eat");
        words.add("rain");
        
        
        ArrayList<String> sol = wordSearchII(board, words);
        System.out.println(sol.toString());
    }
}
