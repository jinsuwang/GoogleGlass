/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS;

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
}
