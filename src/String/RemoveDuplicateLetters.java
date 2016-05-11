/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        
        char[] arr = s.toCharArray();
        
        // counter
        for( char c : arr ){
            count[c-'a']++;
        }
        
        boolean[] visited = new boolean[26];
        
        for( char c : arr ){
            count[c-'a']--;
            
            System.out.println(stack.toString());
            if( visited[c-'a'] ) continue;
            
            while( !stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] > 0 ){ // not last one and 
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a'] = true;
        }
        String sol = "";
        for(char c : stack ){
            sol += c;
        }
        
        return sol;
    }
    
    public static void main(String[] args) {
        String test = "cbacdcbc";
        System.out.println(removeDuplicateLetters(test));
    }
}
