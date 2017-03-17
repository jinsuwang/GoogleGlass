/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.StringOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class RepeatedDNASequences {
    
    private static Integer encode( String s ){
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                sum = sum * 4;
            } else if (s.charAt(i) == 'C') {
                sum = sum * 4 + 1;
            } else if (s.charAt(i) == 'G') {
                sum = sum * 4 + 2;
            } else {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
        
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> hash = new HashSet<Integer>();
        Set<String> dna = new HashSet<String>();
        for( int i = 9; i < s.length(); i++ ){
            String subString = s.substring( i-9, i+1 );
            int encoded = encode(subString);
            if( hash.contains( encoded )){
                dna.add( subString );
            }else{
                hash.add( encoded );
            }
        }
        return new ArrayList<String>(dna);
    }  
}
