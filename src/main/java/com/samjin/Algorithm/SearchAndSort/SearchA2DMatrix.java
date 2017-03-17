/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.SearchAndSort;

/**
 *
 * @author Sam
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if( matrix == null || matrix[0].length == 0 ) return false; 
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;
        
        while( left+1 < right ){
            int mid = left + ( right - left ) / 2; 
            int val = matrix[mid / cols][mid % cols]; 
            if( val == target ) right = mid;
            else if( val < target ){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(  matrix[left / cols][left % cols] == target ) return true;
        if(  matrix[right / cols][right % cols] == target ) return true;
        return false;
    }
    
}
