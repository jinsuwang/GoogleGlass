/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class ThreeSumClosest {
    
    public static int threeSumClosest(int[] nums, int target) {
        int closet = Integer.MAX_VALUE;
        int ret = 0;
        if( nums.length < 3 ) return 0;
        Arrays.sort( nums );

        int curr = 1;
        while( curr < nums.length - 1 ){
            int left = 0;
            int right = nums.length - 1;
            while( left < curr && right > curr ){
                int sum = nums[left] + nums[right] + nums[curr];
                if( Math.abs(sum-target) < closet ){
                    ret = sum;
                    closet = Math.abs(sum-target);
                }
                closet = Math.min( Math.abs(sum-target) , closet );
                if( sum >= target){
                    right--;
                }else{
                    left++;
                }
            }
            curr++;
        }
        return ret;
    }
    
    public static void main(String[] args) {
//        int[] test = {-1, 2, 1, -4};
//        int target = 1;
//        System.out.println( threeSumClosest(test,target) );


        byte a = -129;
        System.out.println(a);

    }
}
