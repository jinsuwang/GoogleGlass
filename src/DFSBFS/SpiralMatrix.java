/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        move( matrix, ret, 0, 0, visited );
        return ret;
    }

    private static void move(int[][] matrix, List<Integer> ret, int i, int j, Set<Integer> visited) {
        if( i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length ) return;
        int index = i * matrix[0].length + j;
        if( visited.contains(index)) return;
        visited.add(index);
        ret.add(matrix[i][j]);
//        System.out.println(i+" "+j+" "+index+" "+matrix[i][j]);
        move(matrix, ret, i, j+1, visited); // right
        move(matrix, ret, i+1, j, visited); // down;
        move(matrix, ret, i, j-1, visited); // left
        move(matrix, ret, i-1, j, visited); // up;                       
    }
    
    
    public static List<Integer> spiralOrder2(int[][] matrix) { 
        List<Integer> ret = new ArrayList<Integer>();
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return ret;
        int left = 0, right = matrix[0].length-1,top = 0, bottom = matrix.length-1 ;
        while( left <= right && top <= bottom ){
            for( int j = left; j <= right; j++) {
                ret.add( matrix[top][j] );
                System.out.println("add " + matrix[top][j] );
            }
            for( int i = top+1; i <= bottom; i++){
                ret.add( matrix[i][right]);
                System.out.println("add " +  matrix[i][right] );

            }
            for( int j = right-1; j >= left; j-- ){
                if ( top < bottom )
                    ret.add( matrix[bottom][j] );
                    System.out.println("add " + matrix[bottom][j] );

            } 
            for( int i = bottom -1 ; i >= top+1; i-- ) {
                if( left < right )
                    ret.add( matrix[i][left] );
                    System.out.println("add " +  matrix[i][left] );

            }
            left++; right--; top++; bottom--;
        }
        return ret;
    }

    
    
    
    public static void main(String[] args) {
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ret = spiralOrder2(test); 
        System.out.println(ret.toString());
    }
}
