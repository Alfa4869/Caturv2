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
public class Rook extends Piece{

    public Rook(int row, int col, boolean isWhite, Board PB) {
        super(row, col, "Rook", isWhite, PB);
    }
    
    public void getImage(){
        try{
            if (isWhite) {
                image = ImageIO.read(getClass().getResourceAsStream("asset/rook_white.png"));
            }else{
                image = ImageIO.read(getClass().getResourceAsStream("asset/rook_black.png"));
            }
                
            
            
        }catch(Exception e){}
        
    }
    
    public void getPieceMoves(){
        //COL + 
        for (int i = 1; i <= 7; i++) {
            if (col + i <= 7) {
                if (isEmpty(row, col + i) || isOpponent(row , col + i)) {
                    addMove(row, col+i);
                }
                if (!isEmpty(row, col + i)) {
                    break;
                }
            }
        }
        
        //COL - 
        for (int i = 1; i <= 7; i++) {
            if (col - i >= 0) {
                if (isEmpty(row, col - i) || isOpponent(row , col - i)) {
                    addMove(row, col-i);
                }
                if (!isEmpty(row, col - i)) {
                    break;
                }
            }
        }
        
        //ROW + 
        for (int i = 1; i <= 7; i++) {
            if (row + i <= 7) {
                if (isEmpty(row + i, col) || isOpponent(row + i, col)) {
                    addMove(row + i, col);
                }
                if (!isEmpty(row + i, col)) {
                    break;
                }
            }
        }
        
        //ROW -
        for (int i = 1; i <= 7; i++) {
            if (row - i >= 0) {
                if (isEmpty(row - i, col) || isOpponent(row - i, col)) {
                    addMove(row - i, col);
                }
                if (!isEmpty(row - i, col)) {
                    break;
                }
            }
        }
    }
 
    
}
