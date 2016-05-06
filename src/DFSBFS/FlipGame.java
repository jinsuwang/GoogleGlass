/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Sam
 */
public class FlipGame { 
    public static List<String> generatePossibleNextMoves(String s) {
        
        List<String> sol = new ArrayList<String>();
        
        for( int i = 0; i < s.length()-1; i++ ){
            String tmp = s.substring(i,i+2);
            if( tmp.equals("++")){
                sol.add( s.substring(0,i) + "--"+ s.substring(i+2));
            }
        }
        return sol;
    }
    
    
    
    
    public static void main(String[] args) {
         List<String> sol = generatePossibleNextMoves("++++");
         System.out.println(sol.toString());
    }
}
