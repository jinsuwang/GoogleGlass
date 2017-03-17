/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Sam
 */
public class PermutationSequence {
    
    public static String getPermutation(int n, int k) {
        List<String> ret = generateSequence(n);
        return ret.get(k-1);
    }
    
    private static List<String> generateSequence( int n ){
        List<String> ret = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        helper( ret, used, sb );
        return ret;
    }

    private static void helper(List<String> ret, boolean[] used, StringBuilder sb ) {
        if( sb.length() == used.length ){
            ret.add( sb.toString());
            return;
        }
        else{
            for( int i = 0; i < used.length; i++ ){
                if( used[i] ) continue;
                sb.append( Integer.toString(i+1) );
                used[i] = true;
                helper(ret, used, sb );
                used[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    
    
    
    public static String getPermutation2(int n, int k) {
        List<Character> digits = new LinkedList<Character>();
        
        for( char i = '1'; i <= '0'+n; i++ ){
            digits.add(i);
        }        
        k--;
        StringBuilder sb = new StringBuilder();
        
        int sum = 1;
        
        for( int i = 1; i <= n; i++ ){
            sum *= i; // n!
        }
        
        for( int i = n; i >= 1; i-- ){
            sum = sum / i; //(n-1)!;
            int digitsIndex = k / sum; // find first digit
            k = k % sum;
//            System.out.println("sum: "+ sum + " digitsIndex: " + digitsIndex + " k: "+k);
            sb.append( digits.get(digitsIndex) );
            digits.remove(digitsIndex);        
        }
        return sb.toString();   
    }
  
        
    public static void main(String[] args) {
        String generateSequence = getPermutation(3,2);
        System.out.println(generateSequence);
        String generateSequence2 = getPermutation2(3,2);
        System.out.println(generateSequence2);
    }
}
