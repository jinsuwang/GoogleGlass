/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class TwoSum {
    
    public int[] twoSum( int[] arr, int target ){
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(Integer e : arr ){
            
            if( set.contains(target - e)) return new int[]{ e, target-e };
            if( !set.contains(e) ){
                set.add(e);
            }
            
        }   
        return null;
    }
}
