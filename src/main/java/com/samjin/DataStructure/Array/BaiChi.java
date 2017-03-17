/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.DataStructure.Array;

import java.util.Vector;
/**
 *
 * @author Sam
 */
public class BaiChi {
    
    public static void baichi(){
        Vector sol = new Vector();
        for( int i = 1; i <= 100; i++ ){
            if( i % 3 == 0 && i % 5 == 0){
                sol.add("baichi");
            }else if( i % 3 == 0 ){
                sol.add("bai");
            }else if( i % 5 == 0 ){
                sol.add("chi");
            }else{
                sol.add(i);
            }
        }
        System.out.println(sol.toString());
    }
    
    public static void main(String[] args) {
        baichi();
    }
}
