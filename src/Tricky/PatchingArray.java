/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

/**
 *
 * @author Sam
 */
public class PatchingArray {
    public static int minPatches(int[] nums, int n) {
   
        int miss = 1, added = 0, i = 0;    
        while( miss <= n ){
            if( i < nums.length && nums[i] <= miss ){
                miss += nums[i++];
            }else{
                miss += miss;
                added++;
            }
        }
        return added;
    }
    
    public static void main(String[] args) {
        System.out.println( minPatches( new int[]{1,3}, 6 ) );
    }
}
