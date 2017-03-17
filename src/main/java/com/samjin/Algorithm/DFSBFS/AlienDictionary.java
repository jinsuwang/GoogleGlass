/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class AlienDictionary {
    
    private static final int N = 26;
    
    public static String alienOrder(String[] words) {
        
        if( words == null || words.length == 0 ) return "";
        
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        
        buildGraph( words, adj, visited );
        
        printGraph(adj);
        
        StringBuilder sb = new StringBuilder();
        
        for( int i = 0; i < N; i++ ){
            if( visited[i] == 0 ){
                if( !dfs(adj, visited, sb, i)) return "";     
            }
        }
        return sb.reverse().toString();
    }
    
    
    
    private static boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;

        for( int j = 0; j < N; j++ ){
            if( adj[i][j] ){
                if( visited[j] == 1 ) {
//                    System.out.println("find cycle");
                    return false;
                } //  cycle.
                if( visited[j] == 0 ){
                    System.out.println( (char)('a'+i) + " visited: " + printVisited(visited)  );
                    boolean tmp = dfs(adj, visited, sb, j);
//                    System.out.println(tmp);
                    if(!tmp) return false;
                }
            }
        }
//        System.out.println("touch bottom line");
        visited[i] = 2;
        sb.append((char)(i+'a'));
        System.out.println("touch bottom  " + sb.toString() + " visited: " +  printVisited(visited) );

        return true;
    }
    
    
    
    private static boolean dfs2(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for( int j = 0; j < N; j++ ){
            if( adj[i][j] ){
                if( visited[j] == 1 ) return false;
                if( visited[j] == 0 ){
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;
        sb.append((char)(i+'a'));
        return true;
    }
    
    
    
    private static void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1); // -1 -> not existed.
        for( int i=0; i < words.length; i++ ){
            for( char c : words[i].toCharArray()) visited[c-'a'] = 0;
            if( i > 0 ){
                String w1 = words[i-1]; String w2 = words[i];
                int len = Math.min(w1.length(), w2.length() );
                for( int j = 0; j < len; j++ ){
                    char c1 = w1.charAt(j); char c2 = w2.charAt(j);
                    if( c1 != c2 ){
                        adj[c1-'a'][c2-'a'] = true;
                        break;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        String[] test = new String[]{   "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println( alienOrder(test) );
        
    }

    private static void printGraph(boolean[][] adj) {
//        for(boolean[] e : adj ){
//            System.out.println(Arrays.toString(e));
//        }
        for( int i = 0; i < adj.length; i++ ){
            for( int j = 0; j < adj[0].length; j++ ){
                if( adj[i][j] ) System.out.println( (char)('a'+i) + "->" + (char)('a'+j) ); 
            }
        }
    }

    private static String printVisited(int[] visited) {
        String sol = "";
        for( int i=0; i< visited.length;i++){
            if( visited[i] == 1 ){
                sol += (char)('a'+i); 
            }
        }
        return sol;
    }
}
