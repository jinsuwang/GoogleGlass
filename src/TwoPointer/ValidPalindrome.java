/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TwoPointer;

/**
 *
 * @author Sam
 */
public class ValidPalindrome {
    public static  boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        String lowerS = s.toLowerCase();
        while( left < right){
            while( left < right && !Character.isLetterOrDigit(lowerS.charAt(left))){
                left++;
            }
            while( left < right && !Character.isLetterOrDigit(lowerS.charAt(right))){
                right--;
            }
            if( lowerS.charAt(left) != lowerS.charAt(right) ) return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String test = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(test));
    }
}
