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
public class King extends Piece{

    public King(int row, int col, boolean isWhite, Board PB) {
        super(row, col, "King", isWhite, PB);
    }
    
    public void getPieceMoves(){
        //ROW +       
        if (row+1 <= 7 && (isEmpty(row+1, col) || isOpponent(row+1, col))) {
            addMove(row+1, col);
        }
        //ROW -
        if (row-1 >= 0 && (isEmpty(row-1, col) || isOpponent(row-1, col))) {
            addMove(row-1, col);
        }
        //COL +       
        if (col+1 <= 7 && (isEmpty(row, col+1) || isOpponent(row, col+1))) {
            addMove(row, col+1);
        }
        //COL -
        if (col-1 >= 0 && (isEmpty(row, col-1) || isOpponent(row, col-1))) {
            addMove(row, col-1);
        }
        //ROW + COL +
        if ((row+1 <= 7 && col+1 <= 7) && (isEmpty(row+1, col+1) || isOpponent(row+1, col+1))) {
            addMove(row+1, col+1);
        }
        //ROW - COL +
        if ((row-1 >= 0 && col+1 <= 7) && (isEmpty(row-1, col+1) || isOpponent(row-1, col+1))) {
            addMove(row-1, col+1);
        }
        //ROW - COL -
        if ((row-1 >= 0 && col-1 >= 0) && (isEmpty(row-1, col-1) || isOpponent(row-1, col-1))) {
            addMove(row-1, col-1);
        }
        //ROW + COL -
        if ((row+1 <= 7 && col-1 >= 0) && (isEmpty(row+1, col-1) || isOpponent(row+1, col-1))) {
            addMove(row+1, col-1);
        }
        
        //CASTLING
        if (!hadMoved) {
            //short castle
            if (!isHadMoved(row,7) && isEmpty(row,5) && isEmpty(row,6)) {
                addMove(row,6);
            }
            //long castle
            if (!isHadMoved(row,0) && isEmpty(row,1) && isEmpty(row,2) && isEmpty(row,3)) {
                addMove(row,2);
            }
        }
    }
    
}
