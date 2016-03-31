/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Sam
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        if( s == null || s.length() == 0 || wordDict == null ) return null;
        return dfs( s, wordDict, map );    
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        
    }
}
