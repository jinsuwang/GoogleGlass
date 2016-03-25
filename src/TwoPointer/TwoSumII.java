/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer;
import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class TwoSumII {
    
    public static int[] twoSum(int[] numbers, int target) {
        
        if( numbers == null || numbers.length < 2 ) return null;
        int start = 0;
        int end = numbers.length - 1;
        
        while( start < end ){
            int sum = numbers[start] + numbers[end];
            if( sum == target ) break;
            else if( sum > target ){ // too big!
                end--;
            }else{
                start++;
            }
        }
        return new int[]{ start+1, end+1 };
    }
    
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ret = twoSum( numbers, target );
        System.out.println(Arrays.toString(ret));
    }
}
