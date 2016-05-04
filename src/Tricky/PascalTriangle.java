/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        for( int i=0; i <numRows; i++ ){
            
            List<Integer> tmp = new ArrayList<Integer>();
            
            for( int j = 0; j <= i; j++ ){
                if( j == 0 || i == j ) tmp.add(1);
                else{
                    int sum = sol.get(i-1).get(j-1) + sol.get(i-1).get(j);
                    tmp.add(sum);
                }
            }
            sol.add(tmp);
        }
        return sol;
    }
}
