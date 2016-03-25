/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;

/**
 *
 * @author Sam
 */
public class GreatestCommonDivisor {
    
   public static int getGCDRcur(int[] arr) {
       if( arr == null || arr.length == 0) return 0;
       if( arr.length < 2) return arr[0];
       int ret = arr[0];
       for( int i = 1; i < arr.length; i++ ){
           if( arr[i] > 0 && ret > 0) ret = helper( ret, arr[i] );
           else return 0;
       }
       return ret;
   } 
   public static int helper(int m, int n){
       System.out.println("m: " + m+ " n: "+n);
       if( m % n == 0 ) return n;
       else return helper( n, m%n );
   }
   
   
   public static int getGCDLoop( int[] arr ){
        if( arr == null || arr.length == 0) return 0;
        if( arr.length < 2) return arr[0];
        int ret = arr[0];
        for( int i = 1; i < arr.length; i++ ){
            int m = arr[i];
            // m is the divident, ret is divisor
            while( m % ret != 0 ){
                int tmp = ret;
                ret = m % ret;
                m = tmp;
            }
        }
        return ret;
    }
   
    public static void main(String[] args) {
        int[] testArr = {12,15};
        System.out.println( getGCDRcur(testArr) );
    }
}
