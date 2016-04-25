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
public class OneDistance {
    
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if( n < m ) return isOneEditDistance( t, s );
        if( n - m > 1) return false;
        
        int i = 0,  shift = n - m;
        while ( i < m && s.charAt(i) == t.charAt(i)) i++;
        if( i == m){ // finish scan
            return shift == 1;
        }
        // allow one integer.
        if (shift==0 ) i++; 
        while ( i < m && s.charAt(i) == t.charAt(i+shift)) i++; // use shift to skip one char in t
        return i == m;
    }
}
