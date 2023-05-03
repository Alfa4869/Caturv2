/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import GameRule.Board;
import javax.imageio.ImageIO;
/**
 *
 * @author ASUS
 */
public class Knight extends Piece{

    public Knight(int row, int col, boolean isWhite, Board PB) {
        super(row, col, "Knight", isWhite, PB);
    }
    
    public void getImage(){
        try{
            if (isWhite) {
                image = ImageIO.read(getClass().getResourceAsStream("asset/knight_white.png"));
            }else{
                image = ImageIO.read(getClass().getResourceAsStream("asset/knight_black.png"));
            }
                
            
            
        }catch(Exception e){}
        
    }
    
    
    public void getPieceMoves(){
        
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // possible horizontal moves for the knight
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1}; // possible vertical moves for the knight
        
        // Check for valid moves
        for (int i = 0; i < 8; i++) {
            int newCol = col + dx[i];
            int newRow = row + dy[i];
            
            if (newCol >= 0 && newCol <= 7 && newRow >= 0 && newRow <= 7) {
                if (isEmpty(newRow,newCol) ) {
                    addMove(newRow, newCol);
                }
                if (isOpponent(newRow, newCol)) {
                    addMove(newRow, newCol);
                }
            }
        }
    }
    
    
}
