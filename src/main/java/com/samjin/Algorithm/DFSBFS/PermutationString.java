/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sam
 */
public class PermutationString {
    
    public static List<List<String>> getPermutationString(List<String> strs){
        List<List<String>> sol = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        dfs(sol, path, strs, 0);
        return sol;
    }

    private static void dfs(List<List<String>> sol, List<String> path, List<String> strs, int i) {
        if(i == strs.size()){
            sol.add( new ArrayList<String>(path)); 
        }else{
            if(strs.get(i).length() == 0){
                dfs( sol, path, strs, i+1);
            }else{
                path.add(strs.get(i).toLowerCase());
                
                dfs( sol, path, strs, i+1);
                path.remove(path.size()-1);

                path.add(strs.get(i).toUpperCase());
                dfs( sol, path, strs, i+1);
                path.remove(path.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
//        List<String> test = Arrays.asList( new String[]{"aq2", "bDe"} );
////        System.out.println(test);
//        List<List<String>> sol = getPermutationString( test );
//        for( List<String> str : sol ){
//            System.out.println(str);
//        }

            Map<String, String> map = new HashMap<String,String>();
         System.out.println(map.get("xx"));
     
    }
}
