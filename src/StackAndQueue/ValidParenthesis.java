/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StackAndQueue;

import java.util.Stack;

/**
 *
 * @author Sam
 */
public class ValidParenthesis {
    
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 ){
			return true;
        }
        String sampleLeft = "([{";
        String sampleRight = ")]}";
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++ ){	
                if(sampleLeft.indexOf(s.charAt(i)) >= 0 ){
                        stack.push(sampleLeft.indexOf(s.charAt(i)));
                }
                if(sampleRight.indexOf(s.charAt(i)) >= 0 ){
                        if(stack.isEmpty() || stack.peek() != sampleRight.indexOf(s.charAt(i))) return false;
                        if(stack.peek() == sampleRight.indexOf(s.charAt(i))){
                                stack.pop();
                        }
                }
        }
        return stack.isEmpty();
    }
    
}
