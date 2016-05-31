/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package String;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    
    // Given "pwwkew", the answer is "wke"
    
    public int lengthOfLongestSubstring(String s) {
        
        if( s == null || s.length() == 0 ){
            return 0;
        }
        
        Set<Character> set = new HashSet<Character>();
        
        int leftBound = 0, max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (set.contains(s.charAt(i))) {
            
                while( leftBound < i && s.charAt(leftBound) != s.charAt(i) ){
                    set.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            }else{  
                set.add(s.charAt(i));
                max = Math.max(max, i - leftBound + 1);
            }
        }
        return max;
    }
}
