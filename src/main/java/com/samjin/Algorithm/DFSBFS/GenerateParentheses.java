/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class GenerateParentheses {
    
    public static List<String> generateParenthesis(int n) {
        
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        dfs(result, "", n, n);
        return result;
    }
    
    public static void dfs(ArrayList<String> result, String paren, // current paren
            int left, int right) {  // how many right paren we need to add
	if (left == 0 && right == 0) {
            result.add(paren);
            return;
	}
        if (left > 0) { 
            dfs(result, paren + "(", left - 1, right);
        }
        
        if (right > 0 && left < right) {
            dfs(result, paren + ")", left, right - 1);
        }
    }
    
    public static void main(String[] args) {
        List<String>  sol = generateParenthesis(3);
        System.out.println(sol.toString());
    }
}
