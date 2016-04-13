/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class NQueens {
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if( n <= 0 ) return ret;
        search( n, new ArrayList<Integer>(), ret );
        return ret;
    }

    private static void search(int n,  List<Integer> cols, List<List<String>> ret) {
        if( cols.size() == n ){
            ret.add( genrateResult(cols) );
            return;
        }
        for( int col= 0; col < n; col++ ){
            if( !isValid(cols, col)) continue;
            cols.add(col);
            search( n, cols, ret );
            cols.remove( cols.size() -1 );
        }
    }

    private static boolean isValid(List<Integer> cols, int col) {
        int row = cols.size();
        for( int i = 0; i < row; i++ ){
            if( cols.get(i) == col ){
                return false;
            }
            if( row-i == Math.abs( col - cols.get(i) ))
                return false;
        }
        return true;
    }

    private static List<String> genrateResult(List<Integer> cols) {
        List<String> ret = new ArrayList<String>();
        int size = cols.size();
        for( Integer e : cols ){
            StringBuilder sb = new StringBuilder();

            for( int i =0; i < size; i++ ){
                if( i == e ) sb.append("Q");
                else sb.append(".");
            }
            ret.add( sb.toString() );
        }
        return ret;
    }
    
    public static void main(String[] args) {
//        List<Integer> test = new ArrayList<>();
//        test.add(1); test.add(3); test.add(0); test.add(2);            
        List<List<String>> ret = solveNQueens( 4 );
        for ( List<String> e : ret )
            System.out.println(e.toString());
    }
}
