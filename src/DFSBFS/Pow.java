/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

/**
 *
 * @author Sam
 */
public class Pow {
    
    public static double myPow2(double x, int n) {
        if ( n < 0 ) return 1.0/myPow2( x, -n );
        if( n == 0 ) return 1;
        if( n == 1 ) return x;
        if( n % 2 == 0 ) return myPow2(x, n/2) * myPow2( x, n/2 );
        return myPow2(x, n/2) * myPow2( x, n/2 )* x;
    }
    
    public static double myPow( double x, int n ){
        
        if (n < 0) {
            double ret = x * myPow(x, -(n + 1));
            return 1.0/ret;
        }        
        
        if( n == 0 ) return 1;
        if( n == 1 ) return x;
        
        double part = myPow( x, n/2);

        if( n % 2 == 0)  return part * part;
        else             return part * part * x;
    }
    
    public static void main(String[] args) {
        System.out.println(myPow(3,-2));
    }
}
