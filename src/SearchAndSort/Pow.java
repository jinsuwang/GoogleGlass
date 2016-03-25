/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchAndSort;

/**
 *
 * @author Sam
 */
public class Pow {
    
    public static double myPow(double x, int n) {
        if ( n < 0 ) return 1.0/myPow( x, -n );
        if( n == 0 ) return 1;
        if( n == 1 ) return x;
        if( n % 2 == 0 ) return myPow(x, n/2) * myPow( x, n/2 );
        return myPow(x, n/2) * myPow( x, n/2 )* x;
    }
    
    public static void main(String[] args) {
        System.out.println(myPow(3,1));
    }
}
