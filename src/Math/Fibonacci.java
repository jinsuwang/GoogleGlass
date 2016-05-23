/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class Fibonacci {
    
    public static int[] findFibonacci( int n ){
        int[] sol = new int[n+1];
        sol[0] = 0;
        sol[1] = 1;
        for( int i=2; i <= n; i++ ){
            sol[i] = sol[i-1] + sol[i-2];
        }
        return sol;
    }
    
    
    public static int Fibonacci( int n )
    
    
    public static void main(String[] args) {
        int[] sol = findFibonacci(5);
        System.out.println(Arrays.toString(sol));
    }
}
