/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Array;

/**
 *
 * @author Sam
 */
public class Compression {
    
    public static String convert(String str){
        // handle corner case
        if( str == null || str.length() == 0 ) return str;

        int count;
        char currChar;
        StringBuffer sb = new StringBuffer();
        boolean isNumeric = false;

        for( int i = 0; i < str.length(); i++){

                currChar = str.charAt(i);
                count = 1;
                isNumeric = false;

                if( Character.isDigit( str.charAt(i) )){
                        isNumeric = true;
                }
                while( i < str.length()-1 &&  str.charAt(i) == str.charAt(i+1) ) {
                        count++;
                        i++;
                }
                if( isNumeric == true )
                        sb.append("//");

                sb.append(currChar);
                sb.append(count);
        }
        return sb.toString();
    }   
    
    public static void main(String[] args) {
        String sol = convert("aaavbbcc");
        System.out.println(sol);
    }
}
