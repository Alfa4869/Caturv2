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
public class Bishop extends Piece{

    public Bishop(int row, int col, boolean isWhite, Board PB) {
        super(row, col, "Bishop", isWhite, PB);
    }
    
    public void getImage(){
        try{
            if (isWhite) {
                image = ImageIO.read(getClass().getResourceAsStream("asset/bishop_white.png"));
            }else{
                image = ImageIO.read(getClass().getResourceAsStream("asset/bishop_black.png"));
            }
                
            
            
        }catch(Exception e){}
        
    }
    
    
    @Override
    public void getPieceMoves(){
        
        
        
        for (int i = 1; i <= 7; i++) {
            if (col + i <= 7 && row + i <= 7) {
                if (isEmpty(row + i, col + i) || isOpponent(row + i, col + i)) {
                    addMove(row+i, col+i);
                }
                if (!isEmpty(row + i, col + i)) {
                    break;
                }
            }
        }
        
        for (int i = 1; i <= 7; i++) {
            if (col + i <= 7 && row - i >= 0) {
                if (isEmpty(row - i, col + i) || isOpponent(row - i, col + i)) {
                    addMove(row-i, col+i);
                }
                if (!isEmpty(row - i, col + i)) {
                    break;
                }
            }
        }
        
        for (int i = 1; i <= 7; i++) {
            if (col - i >= 0 && row + i <= 7) {
                if (isEmpty(row + i, col - i) || isOpponent(row + i, col - i)) {
                    addMove(row+i, col-i);
                }
                if (!isEmpty(row + i, col - i)) {
                    break;
                }
            }
        }
        
        for (int i = 1; i <= 7; i++) {
            if (col - i >= 0 && row - i >= 0) {
                if (isEmpty(row - i, col - i) || isOpponent(row - i, col - i)) {
                    addMove(row-i, col-i);
                }
                if (!isEmpty(row - i, col - i)) {
                    break;
                }
            }
        }
    }
    
}
