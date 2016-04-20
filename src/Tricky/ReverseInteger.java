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
public class ReverseInteger {
    public static int reverse(int x) {
        int ret = 0; 
        if( x > Integer.MAX_VALUE ) return ret;
        while( x != 0){
            int curr = ret*10 + x%10;
            if( curr / 10 != ret ){
                return 0;
            }
            x /= 10;
            ret = curr;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        int x = 123;
        int ret = reverse( x );
        System.out.println(ret);
    }
}
