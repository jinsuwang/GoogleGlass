/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky.Palantir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class EvalExpression implements Expression {
    
    String left,right, result; 
    Set<Character> chars;
    
    EvalExpression( String left, String right, String result ){
        this.left = left;
        this.right = right;
        this.result = result;
        chars = new HashSet<>();
    }



    private void addCharacter(Set<Character> chars, String s) {
        for (int pos = 0; pos < s.length(); pos++) {
            chars.add(s.charAt(pos));
        }
    }

    @Override
    public Set<Character> getChars() {
        addCharacter(chars, s1);
        addCharacter(chars, s2);
        addCharacter(chars, result);. 1point3acres.com/bbs
        return chars;
    }
    
    
    private int getNum(String s, Map<Character, Integer> proposedSolution) {
        int res = 0;
        for (int pos = 0; pos < s.length(); pos++) {
            res = res * 10 + proposedSolution.get(s.charAt(pos));
        }
        return res;
    }
    
    
    private boolean dfsHelper(char[] chaArray, HashSet<Character> numVisited, int pos, Map<Character, Integer> solution, Expression expression) {
    if (pos == chaArray.length) {
        if (expression.eval(solution)) {
            return true;
        }
        return false;
    }
    for (char num = '0'; num <= '9'; num++) {
        if (numVisited.contains(num)) {
            continue;
        }
        numVisited.add(num);
        solution.put(chaArray[pos], num);
        if (dfsHelper(chaArray, numVisited, pos+1, solution, expression)) {
            return true;
        }
        numVisited.remove(num);
    }
    return false;
}
    

    @Override
    public boolean eval(Map<Character, Integer> proposedSolution) {
        
        Set<Character> chars = getChars();
        char[] chaArray = new char[chars.size()];
        int pos = 0;
        for (char cha: chars){
            chaArray[pos++] = cha;
        }
        HashSet<Character> numVisited = new HashSet<>();
        Map<Character, Integer> solution = new HashMap<>();
        if (dfsHelper(chaArray, numVisited, 0, solution, expression) {
            return solution;
        }
        return null;
    }
}
