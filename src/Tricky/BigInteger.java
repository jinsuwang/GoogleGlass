/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky;

import java.util.Arrays;

/**
 *
 * @author Sam
 */
public class BigInteger {
    
    public String bigIntegerMultiply(String a, String b ){
        
        int lenA = a.length();
        int lenB = b.length();
        
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        reverse(charA); reverse(charB);
        multiply( charA, charB );
        return "";
    }
    
    private static void reverse( char[] arr ){
        for( int left = 0, right = arr.length-1; left < right; left++, right-- ){
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }
    
    public static void main(String[] args) {
        char[] test = "12345".toCharArray();
        reverse( test );
        System.out.println(Arrays.toString(test ));
        
    }

    private void multiply(char[] charA, char[] charB) {
        
        int csize = charA.length + charB.length + 3;
        int[] c = new int[csize];
        for( int i = 0; i < charA.length; i++ ){
            for( int j = 0; i < charB.length; i++ ){
                c[i+j] += Character.getNumericValue(charA[i]) * Character.getNumericValue(charB[j]);
            }
        }
        
        for( int m = 0; m < csize; m++ ){
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if( carry > 0 ){
                c[m+1] += carry;
            }
        }
    }
}
