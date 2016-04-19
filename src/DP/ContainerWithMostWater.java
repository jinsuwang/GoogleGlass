/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author Sam
 */
public class ContainerWithMostWater {
    public static int maxArea2(int[] height) {
        
        int max = 0;
        int maxIndex = -1;
        int sum = 0;
       
        for( int i = 0; i < height.length; i++ ){
           if( height[i] > max ){
               max = height[i];
               maxIndex = i;
           }
        }
        
        int left = maxIndex-1;
        int leftLimit = max;
        int rightLimit = max;
        int right = maxIndex+1;
                
        while( left >= 0 ){
            if( height[left] <= leftLimit ){
                sum += height[left];
            }else{
                sum += leftLimit;
            }
            leftLimit = height[left--]; 
        }
        
        while( right < height.length ){
            if( height[right] <= rightLimit ){
                sum += height[right];
            }else{
                sum += rightLimit;
            }
            rightLimit = height[right++]; 
        }
        return sum;          
    }
    
    public static int maxArea(int[] height) {   
        if( height == null || height.length < 2 ) return 0;
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while( left < right ){
            max = Math.max( max, (right-left) * Math.min( height[left], height[right]));
            if( height[left] <  height[right] ){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    
    public static void main(String[] args) {
        int[] test = { 1,2,3,4,5 };
        System.out.println(maxArea(test));
        
    }
}
