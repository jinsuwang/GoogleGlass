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
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        String operators = "+-*/";
        for( int i = 0; i < tokens.length; i++ ){
            if( !operators.contains(tokens[i]) ){
                stack.push( Integer.valueOf(tokens[i]) );
            }else{
                int second = stack.pop();
                int first = stack.pop();
                String operator = tokens[i];
                if( operator.equals("*"))  stack.push( first * second );
                else if ( operator.equals("+")) stack.push( first + second );
                else if ( operator.equals("-")) stack.push( first - second );
                else stack.push( first / second );  
            }
        }
        return stack.peek();
    }
    
    public static void main(String[] args) {
        String[] test = {"2", "1", "+", "3", "*"};
        String[] test2 = {"4", "13", "5", "/", "+"};
        String[] test3 = { "0" ,"3", "/" };

        int result = evalRPN( test3 );
        System.out.println(result);
    }
}
