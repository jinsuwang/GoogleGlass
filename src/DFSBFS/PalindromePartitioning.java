/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> sol = new ArrayList<List<String>>();
        if ( s == null ) return sol;
        List<String> curr = new ArrayList<String>();
        dfs( s, sol, curr, 0);
        return sol;
    }

    private static void dfs(String s, List<List<String>> sol, List<String> curr, int index) {
        if( index == s.length() ){
            sol.add(new ArrayList<String>( curr ));
        }else{
            for( int i = index+1; i <= s.length(); i++ ){
                if( !isPalindrome( s.substring(index, i))){
                    continue;
                }else{
                    curr.add(s.substring(index, i));
                    dfs( s, sol, curr, i );
                    curr.remove(curr.size()-1);
                }
            }
        }    
    }
    
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while( left <= right ){
            if( s.charAt(left) != s.charAt(right) ){
                return false;
            }
            left++; right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        String a = "amanaplanacanalpanama";
        List<List<String>> ret = partition(a);
        for( List<String> e : ret){
            System.out.println(e.toString());
        }
    }
    
}
