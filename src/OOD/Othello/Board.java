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
public class Board {
    private int blackCount = 0;
    private int WhiteCount = 0;
    private Piece[][] board;
    
    public Board( int rows, int columns ){
        board = new Piece[rows][columns];
    }
    public void initialize(){};
    /* Most import section */
    public boolean placeColor( int row, int col, Color color){ return true; }
    private int flipSection( int row, int column, Color color, Direction d ){ return -1; }
    public void updateScore( Color newColor, int newPieces ){}
    
    public int getScoreForColor( Color c ){ return -1;}
}
