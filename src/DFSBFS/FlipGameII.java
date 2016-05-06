/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class FlipGameII {
    
    public static boolean canWin(String s, int level ) {
        List<String> tmp = new ArrayList<String>();
        for( int i = 0; i < s.length()-1; i++ ){
            if(s.substring(i,i+2).equals("++"))
                tmp.add( s.substring(0,i) + "--"+ s.substring(i+2) );
        }
        
//        System.out.println(" Level: " + level + " prev: "+ s + tmp.toString());
        
        for( String e : tmp ){
            if( !canWin(e) ){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        System.out.println( canWin("+--+", 0) );
        
    }
    
}
