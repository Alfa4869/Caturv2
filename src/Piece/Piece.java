/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Piece;

import GameRule.Move;
import GameRule.Board;
import GameRule.CekSkak;
import java.util.List;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


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
    List<Move> moves;
    
    
    

    public Piece(int row, int col, String model, boolean isWhite, Board PB) {
        this.row = row;
        this.col = col;
        this.model = model;
        this.isWhite = isWhite;
        this.PB = PB;
        
        moves = new ArrayList();
        
        hadMoved = false;
        moveSince = 0;
        
        
    }
    
    
    
    public List<Move> getMovesAsList(){
        
        moves.clear();
        
        List<Move> listMoves = new ArrayList();
        getPieceMoves();
        
        for (Move move : moves) {
            if (move == null) {
                break;
            }
            listMoves.add(move);
        }
        
        return listMoves;
        
    }
    
    public List<Move> getLegalMoves(){
        
        List<Move> listMoves = getMovesAsList();
        List<Move> movesToRemove = new ArrayList();
        
        
        for (Move listMove : listMoves) {
            CekSkak CK = new CekSkak(PB.sq, listMove);
            if (CK.isSkak(listMove)) {
                System.out.println("ada yang skak");
                movesToRemove.add(listMove);
                
            }
        }
        
        
        for (Move moveToRemove : movesToRemove) {
            listMoves.remove(moveToRemove);
        }
        
        
        return listMoves;
        
    }
    
    protected void addMove(int toRow, int toCol, String type){
        
        moves.add(new Move(row, col, toRow, toCol, model,isWhite, type ));
        
        
        
    }
    
    protected void addMove(int toRow, int toCol){
        
        
        moves.add( new Move(row, col, toRow, toCol, model, isWhite));
        
        
        
       
        
        
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
