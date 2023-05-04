/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import GameRule.Move;
import GameRule.Board;
import GameRule.CekSkak;
import java.awt.image.BufferedImage;


/**
 *
 * @author ASUS
 */
public class Piece {
    
    Board PB;
    
    //Attribute
    public int row, col;
    public String model;
    public boolean isWhite;
    public boolean hadMoved;
    public int moveSince;
    public BufferedImage image;
    
    
    //local variables
    Move[] moves;
    int counter;
    
    

    public Piece(int row, int col, String model, boolean isWhite, Board PB) {
        this.row = row;
        this.col = col;
        this.model = model;
        this.isWhite = isWhite;
        this.PB = PB;
        
        moves = new Move[20];
        counter = 0;
        hadMoved = false;
        moveSince = 0;
        
        
    }
    
    public Move[] getMoves(){
        moves = new Move[20];
        counter = 0;
        getPieceMoves();
        return moves;
        
    }
    
    public Move[] getLegalMoves(){
        Move[] newMoves= getMoves();
        
        
        for (int idx = 0; idx < newMoves.length; idx++) {
            
            if (newMoves[idx] == null) {
                break;
            }
            
            CekSkak CK = new CekSkak(PB.sq, newMoves[idx]);
            if (CK.isSkak(newMoves[idx])) {
                System.out.println("ada yang skak");
                newMoves[idx].type = "illegal";
            }
        }
        
        return newMoves;
        
        
        
    }
    
    protected void addMove(int toRow, int toCol, String type){
        
        Move move = new Move(row, col, toRow, toCol, model,isWhite, type );
        
        
        
        
        moves[counter] = move;
        counter++;
        
        
    }
    
    protected void addMove(int toRow, int toCol){
        
        
        Move move = new Move(row, col, toRow, toCol, model, isWhite);
        
        
        
       
        moves[counter] = move;
        counter++;
        
    }
    
    public boolean isEmpty(int row, int col){
        return "Empty".equals(PB.sq[row][col].model);
    }
    
    public boolean isInBoard(int row, int col){
        return (row>=0 && row<=7) && (col>=0 && col<=7);
    }
    
    public boolean isOpponent(int row, int col){
        if (isInBoard(row,col) && !isEmpty(row,col)) {
            return PB.sq[row][col].isWhite != isWhite;
        }
        return false;
    }
    
    public boolean isHadMoved(int row, int col){
        if (isInBoard(row,col)) {
            return PB.sq[row][col].hadMoved;
        }
        return false;
    }
    
    public boolean isEnPassantAble(int row, int col){
        if (isInBoard(row,col)) {
            return PB.sq[row][col].moveSince == 1;
        }
        return false;
        
    }
    
    
    protected void getPieceMoves(){
        
    }
    
    public void getImage(){
        
    }
        
    
    
    
}
