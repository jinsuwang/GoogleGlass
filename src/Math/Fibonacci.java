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
    
    
   //Iteration method
    static int fibIteration(int n) {
        int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    //Recursive method
    static int fibRecursion(int  n) {
        if ((n == 1) || (n == 0)) {
            return n;
        }
        return fibRecursion(n - 1) + fibRecursion(n - 2);
    }    
    
    public static void main(String[] args) {
        int[] sol = findFibonacci(5);
        System.out.println(Arrays.toString(sol));
    }
}
