



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class FloodFill {
    
                        //left, right, down, up
    static int[] dirX = {  0,   0,   1,  -1  };
    static int[] dirY = {  -1,  1,   0,   0  };
    
    public static void canFloodFill( int[][] grid ){
        int space = 0;
        for( int i = 0; i < grid.length; i++ ){
            for( int j = 0; j < grid.length; j++ ){
                if( grid[i][j] == 0 ) space++;
            }
        }
        Set<Integer> visited = new HashSet<Integer>();
        dfs( grid, visited, 0, 0);
    }
    
    private static void dfs(int[][] grid, Set<Integer> visited, int x, int y) {
        
        if( x < 0 || y < 0 || x >= grid.length || y >= grid[0].length 
//                || visited.contains( x*grid[0].length + y) ) return;
                || grid[x][y] == 2 || grid[x][y] == 1) {
            System.out.println("x: " + x + " y: "+ y);
            return;
        }
        
        for( int d = 0; d < dirX.length; d++ ){
//            visited.add( x*grid[0].length + y );

//            System.out.println( x + "  " + y );
//            System.out.println( (x+dirX[d]) + " " + (y+dirY[d])  );
//            if(  grid[x][y] == 2 ) continue;            
            grid[x][y] = 2;            
            System.out.println("Before dfs");
            dfs( grid, visited, x+dirX[d], y+dirY[d] );
            
            for(int[] e : grid ){
                System.out.println(Arrays.toString(e));
            }
            System.out.println("Back Tracing!");
            System.out.println();

        }
    }
    
        
    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0,0},
            {0,0,1,0},
            {0,1,0,0},
            {0,0,1,0}
        };
        canFloodFill( grid );    
    }    
}
