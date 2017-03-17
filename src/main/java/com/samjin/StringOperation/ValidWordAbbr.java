/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.StringOperation;

/**
 *
 * @author Sam
 */
public class ValidWordAbbr {
    
    String[] dict;
    
    public ValidWordAbbr(String[] dictionary) {
        this.dict = dictionary;
        
    }

    public boolean isUnique(String word) {
        for( String e : dict ){
            if( e.equals(word)) continue;
            if( e.length() == word.length() ){
                if( e.length() <= 2 ) return !e.equals(word);
                else{
                    if( e.charAt(0) == word.charAt(0) && 
                            e.charAt(e.length()-1) == word.charAt(word.length()-1)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        //String[] dict = new String[]{ "deer", "door", "cake", "card"};
        String[] dict = new String[]{ "hello" };

        ValidWordAbbr vwa = new ValidWordAbbr(dict);
        System.out.println( vwa.isUnique( "hello" ));
//        System.out.println( vwa.isUnique( "cart" ));
//        System.out.println( vwa.isUnique( "cane" ));
//        System.out.println( vwa.isUnique( "make" ));
        
    }
    
}
