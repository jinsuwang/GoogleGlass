/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DFSBFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class GeneralizedAbbreviation {
    
    public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        dfs(0, word.toCharArray(), new StringBuffer(), 0, res);
        return res;
    }
    
    public static void dfs(int pos, char[] word, StringBuffer sb, int count, List<String> res) {
        int len = word.length;
        int sbOriginSize = sb.length();
        if (pos == len) {
            if (count > 0) {
                sb.append(count);
            }
            res.add(sb.toString());
        }
        else {
            //choose to abbr word[pos]
            dfs(pos+1, word, sb, count+1, res);
            //choose not to abbr word[pos]
            //first append previous count to sb if count>0
            if (count > 0) sb.append(count);
            sb.append(word[pos]);
            dfs(pos+1, word, sb, 0, res);
//            sb.deleteCharAt(sb.length()-1)
        }
        sb.setLength(sbOriginSize);
    }
    
    public static void main(String[] args) {
        List<String> sol = generateAbbreviations("word");
        System.out.println( sol.toString() );
//        StringBuffer sb = new StringBuffer();
//        sb.append("123");
//        sb.setLength(1);
//        System.out.println(sb.toString());
    }
}
