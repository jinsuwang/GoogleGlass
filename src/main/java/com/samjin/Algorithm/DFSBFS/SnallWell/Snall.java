/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samjin.Algorithm.DFSBFS.SnallWell;

/**
 *
 * @author Sam
 */
public class Snall{
    
    private int day;
    private int night;
    private Well well;
    
    Snall( int day, int night ){
        this.day = day;
        this.night = night;
    }
    
    Snall(){
        this.day = 3;
        this.night = 2;
    }
    
    public void placeToWell( Well well ){
        this.well = well;
    }
    
    public int move(){
//        System.out.println( distance );
        if( well != null ){
            return move( well.getDepth() );
        }
        return -1;
    }
    
    private int move( int distance ){
        if( distance <= day ) return 1;
        System.out.println(distance);
        return move( distance - day - night ) + 1;
    }    
    
    
    public int moveQuick( int distance ){
        return ( distance - day ) / ( day + night ) + 1 ; 
    }
    
    
    public static void main(String[] args) {
        Snall s = new Snall( 3, -2 );
        s.placeToWell(new Well(10));
        System.out.println(s.move());
    }


//    @Override
//    public Iterator iterator() {
//        return new Iterator<String>(){
//            @Override
//            public boolean hasNext() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public String next() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        }
//    }
}
