/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Tricky;

/**
 *
 * @author Sam
 */
public class CountandSay {
    
    public static String countAndSay(int n) {
        if( n == 1) return "1";
        String str = n + "";
        int count = 1, index = 0;
        StringBuffer sb = new StringBuffer();
        
        while( index < str.length() ){
            while( index < str.length()-1 && str.charAt(index) == str.charAt(index+1)){
                count++;
                index++;
            }
            sb.append(count);
            sb.append(str.charAt(index));
            
            count = 1;
            index++;
            
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(countAndSay(0));
    }
}
