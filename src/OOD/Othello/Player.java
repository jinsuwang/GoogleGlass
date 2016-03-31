/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOD.Othello;

/**
 *
 * @author Sam
 */
public class Player {
    
    private Color color;
    public Player(Color color){
        this.color = color;
    }
    public int getScore(){ return 0; };
    public boolean playPiece( int r, int c){
        return Game.getInstance().getBoard().placeColor( r, c, color );
    }
    public Color getColor(){ return color; }
    
}
