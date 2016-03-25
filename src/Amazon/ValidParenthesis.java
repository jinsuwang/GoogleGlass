/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Amazon;
import java.util.*;
/**
 *
 * @author Sam
 */
public class ValidParenthesis {
    
    public static int isValid(String s) {
        if( s == null || s.length() == 0 ) return 0;
        Stack<Character> stack = new Stack<Character>();
        String left = "([{";
        String right = ")]}";
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty())  stack.push(s.charAt(i));
            else if( stack.peek() == right.charAt(left.indexOf(s.charAt(i)))){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? s.length() : -1; 
    }
}
