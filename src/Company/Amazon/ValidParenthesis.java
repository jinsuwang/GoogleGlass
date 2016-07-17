/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Company.Amazon;
import java.util.*;
/**
 *
 * @author Sam
 */
public class ValidParenthesis {
    public static boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
	    if (  "({[".indexOf(c) != -1 ) {
                stack.push(c);
            } else {
               if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                   stack.pop();
               } else {
                   return false;
               }
           }
       }
       return stack.isEmpty();
    }

    private static boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
            || (c1 == '[' && c2 == ']');
    }
    
    public static void main(String[] args) {
        System.out.println(isValid("{[()]}"));
    }
}
