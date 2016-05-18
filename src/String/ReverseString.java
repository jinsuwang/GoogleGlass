/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

/**
 *
 * @author Sam
 */
public class ReverseString {
    
    public static String reverseWords( String s ){
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
            reverseString(chars, first, end);
            i++;
        }

        reverseString(chars, 0, len - 1);

        return String.valueOf(chars).trim();
    
    }
    
    
    public static void main(String[] args) {
        String sentence = "the skyline is blue";
        System.out.println( "<"+reverseWords( sentence )+">");
    }
    
    
    
    private static void reverseString(char[] cArr, int left, int right ){
        
        if (cArr == null || left >= right || right >= cArr.length) {
            return;
        }
        
        while( left <= right ){
            char tmp = cArr[left];
            cArr[left] = cArr[right];
            cArr[right] = tmp;
            left++;
            right--;
        }
    }
}
