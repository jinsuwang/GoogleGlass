/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> wordList = new ArrayList<String>();
        if( board == null || board.length == 0 || board[0].length == 0 ||
                words == null || words.length == 0 ) return null;
        int rows = board.length;
        int cols = board[0].length;
        
        
        StringBuffer sb = new StringBuffer();
        
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < cols; j++ ){
                boolean ret = dfs(board, i, j, words, sb, wordList);
            }
        }
        return wordList;
    }

    private boolean dfs(char[][] board, int i, int j, String[] words, StringBuffer sb, List<String> wordList) {
        if( sb.length() == words.length() ){
            
        }
    }
    
}
