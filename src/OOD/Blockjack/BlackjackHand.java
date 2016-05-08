/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOD.Blockjack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sam
 */
public class BlackjackHand {
    
    private static class Card {
        private Card() {
            
        }
        public boolean  isAce(){
            return false;
        }
        public int getMinValue(){
            return 0;
        }
    }
    
    private enum Suit{
        Club(0), Diamond(1),Heart(2), Space(3);
        int v;
        private Suit( int v){
            this.v = v;
        }
    }
    
    List<Card> cards;
    
    public int score(){
        List<Integer> possibleScores = getPossibleScore();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for( int score : possibleScores){
            if( score > 21 && score < min){
                min = score;
            }else if( score <= 21 && score > max ){
                max = score;
            }
        }
        return max == Integer.MIN_VALUE ? min : max;
    }    
    
    private List<Integer> getPossibleScore(){
        List<Integer> values = new ArrayList<Integer>();
        int countAce = 0;
        int value = 0;
        for( Card  c : cards ){
            if( c.isAce() ) countAce++;
            value += c.getMinValue();
        }
        values.add(value);
        while( countAce > 0 ){
            value += 10;
            values.add( value ); 
            countAce--;
        }
        return values;
    }
}
