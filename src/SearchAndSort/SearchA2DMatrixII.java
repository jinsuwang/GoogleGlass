/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

/**
 *
 * @author Sam
 */
public class SearchA2DMatrixII {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = rows - 1;
        int j = 0;
        // left bottom to right top    
        while( i >= 0 && j < cols ){
            int val = matrix[i][j];
            if( val == target ) return true;
            else if( val > target ){
                i--;
            }else{
                j++;
            }
        }
        return false;
    }
}
