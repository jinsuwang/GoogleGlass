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
public class trailingZeros {
    
    
    public static int trailingZeroes(int n) {
        long x = 5;
        int ans = 0;
        while( n >= x ){
            ans += n/x;
            x *= 5;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println( trailingZeroes(2147483647) );
    }
    
}
