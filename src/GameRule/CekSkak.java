/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameRule;

import Piece.Piece;
import Piece.Empty;
import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Queen;
import Piece.Rook;
import Piece.Pawn;

/**
 *
 * @author ASUS
 */
public class CekSkak {
    
    Board VB;
    Piece[][] sq;
    
    
    Move[] moves;

    public CekSkak(Piece[][] sq, Move mov) {
        this.VB = createVirtualBoard(sq);
        
        
        
        this.sq = copySq(VB.sq);
        
        moves = new Move[30];
    }
    
    private Piece[][] copySq(Piece[][] oldSq){
        
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
    
    private Board createVirtualBoard(Piece[][] oldSq){
        
        
        return new Board(oldSq);
    }
    
    public boolean isSkak(Move move){
        
//        System.out.println("CEK SKAK");
//        System.out.println("FROM "+ move.rowFrom + " " + move.colFrom);
        
        movePiece(move);
        VB.sq = sq;
        
//        System.out.println("TO   "+ move.rowTo + " " + move.colTo);
        
        
        boolean nowColor = sq[move.rowFrom][move.colFrom].isWhite;
//        if (nowColor) {
//            System.out.println("putih");
//        }else{
//            System.out.println("hitam");
//        }
        
        int KingRow = 0;
        int KingCol = 0;
        
        //get king row, col
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
        
        for (int row = 0; row < sq.length; row++) {
            for (int col = 0; col < sq[row].length; col++) {
                if (sq[row][col].isWhite != nowColor) {
                    
                    moves = sq[row][col].getMoves();
                    
                    
                    
                    //apakah ada yang skak?
                    for (Move move1 : moves) {
                        
                        if (move1 == null) {
                            break;
                        }
                        
//                        System.out.println(move1.model);
//                        System.out.println("Row:" + move1.rowTo + " Col:" + move1.colTo);
//                        System.out.println("Kow:" + KingRow +     " Kol:" + KingCol);
                        
                        
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
        
        if (move.model == "King") {
            sq[move.rowTo][move.colTo] = new King(move.rowTo, move.colTo, move.fromColor, VB);
            sq[move.rowFrom][move.colFrom] = new Empty(move.rowFrom, move.colFrom, move.fromColor, VB );
            
        }else{
            sq[move.rowTo][move.colTo] = new Pawn(move.rowTo, move.colTo, move.fromColor, VB);
            sq[move.rowFrom][move.colFrom] = new Empty(move.rowFrom, move.colFrom, move.fromColor, VB );
        }
        
        
        
        
            
            
        
    }
    
}
