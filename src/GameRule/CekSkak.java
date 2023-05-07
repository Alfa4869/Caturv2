/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameRule;

import Interface.IVirtualBoard;
import Piece.Piece;
import Piece.Empty;
import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Queen;
import Piece.Rook;
import Piece.Pawn;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class CekSkak implements IVirtualBoard{
    
    Board VB;
    Piece[][] sq;
    
    
    List<Move> moves;

    public CekSkak(Piece[][] sq, Move mov)  {
        this.VB = createVirtualBoard(sq);
        
        
        
        this.sq = copySq(VB.sq);
        
        moves = new ArrayList();
    }
    
    @Override
    public Piece[][] copySq(Piece[][] oldSq){
        
        Piece[][] newSq = new Piece[8][8];
        
        for (int row = 0; row < oldSq.length; row++) {
            for (int col = 0; col < oldSq[row].length; col++) {
                switch (oldSq[row][col].model) {
                    case "Pawn":
                        newSq[row][col] = new Pawn(row,col,oldSq[row][col].isWhite, VB);
                        break;
                    case "Rook":
                        newSq[row][col] = new Rook(row,col,oldSq[row][col].isWhite, VB);
                        break;
                    case "Knight":
                        newSq[row][col] = new Knight(row,col,oldSq[row][col].isWhite, VB);
                        break;
                    case "Bishop":
                        newSq[row][col] = new Bishop(row,col,oldSq[row][col].isWhite, VB);
                        break;
                    case "Queen":
                        newSq[row][col] = new Queen(row,col,oldSq[row][col].isWhite, VB);
                        break;
                    case "King":
                        newSq[row][col] = new King(row,col,oldSq[row][col].isWhite, VB);
                        break;
                    
                    case "Empty":
                        newSq[row][col] = new Empty(row,col, VB);
                        break;
                    default:
                        
                        break;
                }
                
            }
        }
        
        
        return newSq;
        
    }
    
    @Override
    public Board createVirtualBoard(Piece[][] oldSq){
        
        
        return new Board(oldSq);
    }
    
    public boolean isSkak(Move move){
        //loka var
        boolean nowColor = sq[move.rowFrom][move.colFrom].isWhite;
        int KingRow = 0;
        int KingCol = 0;
        
        //move piece dalam Virtual Board
        movePiece(move);
        VB.sq = sq;
        
        
        
        
        //get king row, col (termasuk setelah movePiece)
        for (int row = 0; row < sq.length; row++) {
            for (int col = 0; col < sq[row].length; col++) {
                if (sq[row][col].model == "King" && sq[row][col].isWhite == nowColor) {
                    
                    KingRow = row;
                    KingCol = col;
                    break;
                }
            }
        }
        
        //get all opponent move
        for (Piece[] sq1 : sq) {
            for (Piece sq11 : sq1) {
                if (sq11.isWhite != nowColor && !"King".equals(sq11.model)) {
                    moves = sq11.getMovesAsList();
                    
                    //apakah ada yang skak?
                    for (Move move1 : moves) {
                        
                        if (KingRow == move1.rowTo && KingCol == move1.colTo) {
                            return true;
                        }
                    }
                }
            }
        }
        
        
        
        return false;
    }
    
    
    
    public void movePiece(Move move){
        
        if ("King".equals(move.model)) {
            sq[move.rowTo][move.colTo] = new King(move.rowTo, move.colTo, move.fromColor, VB);
            sq[move.rowFrom][move.colFrom] = new Empty(move.rowFrom, move.colFrom, move.fromColor, VB );
            
        }else{
            sq[move.rowTo][move.colTo] = new Pawn(move.rowTo, move.colTo, move.fromColor, VB);
            sq[move.rowFrom][move.colFrom] = new Empty(move.rowFrom, move.colFrom, move.fromColor, VB );
        }
        
        
        
        
            
            
        
    }
    
}
