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
public class SummaryRanges {
    
    
    public static List<String> summaryRanges(int[] nums) {
               
        
        List<String> sol = new ArrayList<String>();
        if( nums == null ) return sol;
        
        for( int i = 0; i < nums.length; i++ ){
            int curr = i;
            while( i < nums.length-1 && nums[i]+1 == nums[i+1] ) i++;            
            if( curr == i ){
                sol.add( Integer.toString(nums[curr]) );
            }else{
                sol.add( nums[curr]+"->"+nums[i] );
            }
        }
        return sol;
    }
    public static void main(String[] args) {
        int[] test = {0,1,2,4,5,6,7};
        System.out.println( summaryRanges(test).toString() );
    }
}
