/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] cache = new int[ triangle.size() ];
        for( int i = triangle.size()-1; i >= 0; i-- ){
            int size = triangle.get(i).size();
            for( int j = 0; j < size; j++ ){
                if( i == triangle.size()-1 ){
                    cache[j] = triangle.get(i).get(j);
                }else{
                    cache[j] = Math.min( cache[j], cache[j+1]) + triangle.get(i).get(j);
                }
                
            }
        }
        return cache[0];
    }
    
    public static void main(String[] args) {
        
        List<Integer> level1 = new ArrayList<Integer>();
        level1.add(1);
        
        List<Integer> level2 = new ArrayList<Integer>();
        level2.add(2); level2.add(3);
        
        List<Integer> level3 = new ArrayList<Integer>();
        level3.add(4); level3.add(5); level3.add(6);

        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(level1);
        test.add(level2);
        test.add(level3);
        
        System.out.println(minimumTotal(test));
 
    }
}
