/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class IsomorphicStrings{
        
    public static boolean isIsomorphic(String s, String t) {
        
        if( s == null || t == null || s.length() == 0 ) return true;
        
        Map<Character,Character> map = new HashMap<Character,Character>();
        
        char[] ms = new char[256];
        char[] mt = new char[256];
        

        for( int i=0; i < s.length(); i++ ){
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if( ms[c1] == 0 && mt[c2] == 0 ){
                ms[c1] = c2;
                mt[c2] = c1;
            }else{
                if( ms[c1] != c2 || mt[c2] != c1 ) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
        System.out.println( isIsomorphic( "egg", "add" ));
        System.out.println( isIsomorphic( "foo", "bar" ));
        System.out.println( isIsomorphic( "paper", "title" ));
        
    }
}
