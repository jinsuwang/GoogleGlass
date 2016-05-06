/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class MissingRanges {
    
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> sol = new ArrayList<String>(); 

        int left = lower-1;
        int right;
        
        int[] tmp = new int[nums.length+2];
        System.arraycopy(nums, 0, tmp, 1, nums.length);
        tmp[0] = lower-1; tmp[tmp.length-1]= upper+1;
        
        for( int i = 0; i < tmp.length; i++ ){
            right = tmp[i];            
            if( left + 2 == right ){
                sol.add(Integer.toString(left+1));
            }else if( left + 2 < right){
                sol.add( (left+1) + "->"+ (right-1) );
            }       
            left = tmp[i];
        }
        return sol;
    }
    
    public static void main(String[] args) {
        int[] test = { 0, 1, 3, 50, 75 };
        List<String> sol =  findMissingRanges( test , 0, 99);
        System.out.println( sol.toString() );
    }
    
}
