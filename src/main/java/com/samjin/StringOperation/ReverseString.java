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
public class ReverseString {
    
    public static String reverseWords2( String s ){
        if (s == null) {
            return s;
        }
        char[] chars = s.toCharArray();

        int len = chars.length;
        int last = len - 1;

        int i = 0;
        int first = 0;
        int end = 0;

        while (i < len) {

            while (i < len && chars[i] == ' ') {
                i++;
            }
            
            first = i;

            while (i < last && chars[i] != ' ' && chars[i + 1] != ' ') {
                i++;
            }
            end = i;
            reverse(chars, first, end);
            i++;
        }
        reverse(chars, 0, len - 1);

        return String.valueOf(chars);
    
    }
    
    
    public static void main(String[] args) {
        String sentence = "the skyline is blue     ";
        System.out.println( reverseWords( sentence ));
    }
    
    
    public static String reverseWords(String str) {
        char[] s = str.toCharArray();
        reverse(s, 0, s.length - 1);
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
        return new String(s);
    }

    
    
    private static void reverse(char[] cArr, int left, int right ){
        while( left <= right ){
            char tmp = cArr[left];
            cArr[left] = cArr[right];
            cArr[right] = tmp;
            left++;
            right--;
        }
    }
    
    
    public static String reverseWords( char[] s ){
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
        return new String(s);
    }
}
