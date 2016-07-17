/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

/**
 *
 * @author Sam
 */
public class RotateImage {
    
    
    // for square.
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 
            || matrix[0].length == 0) {
            return;       
        }
    
        int n = matrix.length;
        
        int top = 0, down = n-1, left=0, right = n-1;
        
        while( n >= 2 ){
            for( int i = 0; i < n - 1; i++ ){
                int tmp = matrix[top][left+i];
                matrix[top][left+i] = matrix[down-i][left];
                matrix[down-i][left] = matrix[down][right-i];
                matrix[down][right-i] = matrix[top+i][right];
                matrix[top+i][right] = tmp;
            }
            top++;
            left++;
            right--;
            down--;
            n -= 2;
        }
    }
    
    public static void rotateInplace(int[][] matrix){
        int rows = matrix.length;
        for( int i = 0; i < rows/2; i++ ){
            for( int j = 0; j < (rows+1)/2; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[rows-1-j][i]; // ld => lu
                matrix[rows-1-j][i] = matrix[rows-1-i][rows-1-j];
                matrix[rows-1-i][rows-1-j] = matrix[j][rows-1-i];
                matrix[j][rows-1-i] = temp;
            }
        }
    }

}
