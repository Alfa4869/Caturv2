/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import GameRule.Board;
/**
 *
 * @author ASUS
 */
public class Pawn extends Piece{

    public Pawn(int row, int col, boolean isWhite, Board PB) {
        super(row, col, "Pawn", isWhite, PB);
    }
    
    
    public void getPieceMoves(){
        int ori = 1;
        int moving;
                
        
        
        if (isWhite) {
            moving = -1;
            ori = 6;
            
        }else{
            moving = 1;
            ori = 1;
        }
        
        
        if (isEmpty(row + moving,col)) {
            if (row == ori) {
                if (isEmpty(row + moving*2,col)) {
                    
                    addMove(row + moving*2, col);
                }
            }
            addMove(row + moving, col);
            
        
        }
        
        if (isOpponent(row + moving,col-1)) {
            addMove(row + moving, col-1);
        }
        if (isOpponent(row + moving,col+1)) {
            addMove(row + moving, col+1);
        }
        
        //en passsant
        if (isWhite) {
            if (row == 3) {
                if (isOpponent(row,col+1)) {
                    if (isEnPassantAble(row,col+1)) {
                        addMove(row + moving,col+1, "enPassant");
                    }
                    
                }
                if (isOpponent(row,col-1)) {
                    if (isEnPassantAble(row,col-1)) {
                        addMove(row + moving,col-1, "enPassant");
                    }
                    
                }
            }
        }else{
            if (row == 4) {
                if (isOpponent(row,col+1)) {
                    if (isEnPassantAble(row,col+1)) {
                        addMove(row + moving,col+1, "enPassant");
                    }
                    
                }
                if (isOpponent(row,col-1)) {
                    if (isEnPassantAble(row,col-1)) {
                        addMove(row + moving,col-1, "enPassant");
                    }
                    
                }
            }
        }
        
        
        
    
    }
    
    
}
