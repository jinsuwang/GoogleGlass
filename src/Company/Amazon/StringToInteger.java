/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;

/**
 *
 * @author Sam
 */
public class StringToInteger {
    
    public int myAtoi(String str) {
        
        long ret = 0;
        boolean positive = true;
        
        String s = str.trim();
        
        for( int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if( i == 0 ){
                if( c == '+') continue;
                if( c == '-' ){
                    positive = false;
                    continue;
                }
            }
       
            if( !( c > '0' && c < '9')) throw new IllegalArgumentException();
            
            int diff = positive ? c - '0' : '0' - c;
            
            ret = ret * 10 + diff;
            
            if (ret > Integer.MAX_VALUE) {   
                return Integer.MAX_VALUE;
            } else if (ret < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int)ret;
    }
}
