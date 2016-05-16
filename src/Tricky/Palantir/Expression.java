/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tricky.Palantir;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sam
 */
public interface Expression {
    Set<Character> getChars();
    boolean eval( Map<Character, Integer>  proposedSolution );
}
