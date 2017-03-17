/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

/**
 *
 * @author Sam
 */
public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        
        if( board == null || board.length == 0 || board[0].length == 0 ||
                word == null || word.length() == 0 ) return false;
                int rows = board.length;
        int cols = board[0].length;
        
        for( int i = 0; i < rows; i++ ){
            for( int j = 0; j < cols; j++ ){
                boolean ret = dfs(board, i, j, word, 0);
                if( ret ) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int level) {
        if( level == word.length() ){
            return true;
        }
        if (i < 0 || i>= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(level)){
            return false;
	}
        
        char tmp = board[i][j];
        board[i][j] = '#';
        
        boolean rst = dfs(board, i-1, j, word, level+1) 
            || dfs(board, i, j-1, word, level+1) 
                || dfs(board, i+1, j, word, level+1) 
                    || dfs(board, i, j+1, word, level+1);
        
        board[i][j] = tmp;

        return rst;
    }
    public static void main(String[] args) {
        
        char[][] arr = {
            {'A', 'B','C','E'}, 
            {'S', 'F','C','S'},     
            {'A', 'D','E','E' }
        };
        
        String testString = "ABCB";
        System.out.println(exist(arr, testString));
    }
}
