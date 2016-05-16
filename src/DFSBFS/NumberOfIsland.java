/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class NumberOfIsland {
    
    private int m,n;
    public int numIslands(char[][] grid) { 
        int m = grid.length;  if( m == 0 ) return 0;
        int n = grid[0].length; if( n == 0 ) return 0;
        int ret = 0;
        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                if( grid[i][j] != '1' ) continue;
                ret++;
                dfs(grid, i ,j);
            }
        }
        return ret;
    } 

    private void dfs(char[][] grid, int i, int j) {
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ) return;
        if( grid[i][j] == '1' ){
            grid[i][j] = '2';
            dfs( grid, i+1,j);
            dfs( grid, i,j+1);
            dfs( grid, i-1,j);
            dfs( grid, i,j-1);
        }
    }
    
    
    public static int numIslands2(int[][] grid) { 
        int m = grid.length;  if( m == 0 ) return 0;
        int n = grid[0].length; if( n == 0 ) return 0;
        int ret = 0;
        int max = Integer.MIN_VALUE;
        
        Stack<Integer> stack = new Stack<>();
        
        int[] dirX = { 1, -1,  0, 0 };
        int[] dirY = { 0,  0, -1, 1 };

        for( int i = 0; i < m; i++ ){
            for( int j = 0; j < n; j++ ){
                if( grid[i][j] <= 0 ) continue;
                ret++;
                int curr = grid[i][j];
                grid[i][j] = -1;
                stack.push( i * n + j);
                while( !stack.isEmpty() ){
                    int tmp = stack.pop();
                    int x = tmp / n;
                    int y = tmp % n;
//                    System.out.println("x " + x + " y "+ y );
                    for( int k = 0; k < dirX.length; k++ ){
                        int newX = x+dirX[k]; int newY = y+dirY[k]; 
                        if( newX >= 0 && newX < m && newY >= 0 && newY < n 
                                && grid[newX][newY] > 0  ){
                            curr += grid[newX][newY];
                            grid[newX][newY] = -1;
                            stack.push( newX * n + newY );
                        }
                    }
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    } 
    
    public static void main(String[] args) {
        int[][] world = {
            { 1, 2, 11 },
            { 5, 0,  0 },
            { 0, 0, 13 }
        };
        System.out.println( numIslands2( world ));
    }
    
}
