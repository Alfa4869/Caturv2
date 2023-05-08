/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GameRule;

import Interface.IVirtualBoard;
import Piece.Bishop;
import Piece.Empty;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Alfa
 */
public class Bot implements IVirtualBoard{

    List<Move> LM;
    Piece[][] sq;
    Board VB;
    
    //this bot color
    boolean color;
    

    public Bot(Board PB, boolean color) {
        this.VB = createVirtualBoard(PB);
        sq = VB.sq;
        this.color = color;
        
        LM = PB.getAllThisColorMoves(color);
    }
    
    
    
    public Piece[][] copySq(Board oldBoard, Board newBoard) {
        Piece[][] oldSq = oldBoard.sq;
        Piece[][] newSq = new Piece[8][8];
        
        
        for (int row = 0; row < oldSq.length; row++) {
            for (int col = 0; col < oldSq[row].length; col++) {
                switch (oldSq[row][col].model) {
                    case "Pawn":
                        newSq[row][col] = new Pawn(row,col,oldSq[row][col].isWhite, newBoard);
                        break;
                    case "Rook":
                        newSq[row][col] = new Rook(row,col,oldSq[row][col].isWhite, newBoard);
                        break;
                    case "Knight":
                        newSq[row][col] = new Knight(row,col,oldSq[row][col].isWhite, newBoard);
                        break;
                    case "Bishop":
                        newSq[row][col] = new Bishop(row,col,oldSq[row][col].isWhite, newBoard);
                        break;
                    case "Queen":
                        newSq[row][col] = new Queen(row,col,oldSq[row][col].isWhite, newBoard);
                        break;
                    case "King":
                        newSq[row][col] = new King(row,col,oldSq[row][col].isWhite, newBoard);
                        break;
                    
                    case "Empty":
                        newSq[row][col] = new Empty(row,col, newBoard);
                        break;
                    default:
                        
                        break;
                }
                
            }
        }
        
        
        return newSq;
    }
    

    

    
    @Override
    public Board createVirtualBoard(Board oldBoard) {
        
        Board newBoard = new Board();
        newBoard.sq = copySq(oldBoard, newBoard);
        return newBoard;    
    }
    
    public Move getRandomMove(){
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(LM.size());

        return LM.get(randomIndex);
    }
    
    public Move getRandomMove(List<Move> moves){
        
        Random rand = new Random();
        int randomIndex = rand.nextInt(moves.size());

        return moves.get(randomIndex);
    }
    
    
    
    private Move getRandomMaxPoin(List<Integer> poins){
        int max = Collections.max(poins);
        
        List<Move> newMoves = new ArrayList();
        
        for (int i = 0; i < poins.size(); i++) {
            if (poins.get(i) == max) {
                newMoves.add(LM.get(i));
                
            }
        }
        
        return getRandomMove(newMoves);
        
        
    }
    
    private Move getRandomMinPoin(List<Integer> poins){
        int min = Collections.min(poins);
        
        List<Move> newMoves = new ArrayList();
        
        for (int i = 0; i < poins.size(); i++) {
            if (poins.get(i) == min) {
                newMoves.add(LM.get(i));
                
            }
        }
        
        return getRandomMove(newMoves);
        
        
    }
    
    
    // RECURSIVE
    public int getThisBoardPoin(Board boardA, int depth){
        
        if (depth <= 0) {
            System.out.println(boardA.getPoinRatio());
            return boardA.getPoinRatio();
        }
        
        List<Integer> poin = new ArrayList();
        
        
        List<Move> thisBoardMoves = boardA.getAllThisColorMoves(color);
        
        Board boardB;
        
        for (Move move : thisBoardMoves) {
            boardB = createVirtualBoard(boardA);
            
            boardB.movePiece(move);
            
            if (depth > 0) {
                Bot opponentBot = new Bot(boardB, !color);
            
                boardB.movePiece(opponentBot.getBestMove(depth-1));
            }
            
            
            //cekBoard(boardB);
            
            poin.add(getThisBoardPoin(boardB, depth-1));
            
            
        }
        
        
        if (color) {
            return Collections.max(poin);
        }
        return Collections.min(poin);
        
    }
    
    public Move getBestMove(int depth){
        List<Integer> poin = new ArrayList();
        
        Board localBoard;
        
        for (Move move : LM) {
            localBoard = createVirtualBoard(VB);
            
            
            cekBoard(localBoard);
            
            poin.add(getThisBoardPoin(localBoard, depth));
        }
        
//        System.out.println("-------");
//        for (Integer poi : poin) {
//            System.out.println(poi);
//        }
        
        if (color) {
            return getRandomMaxPoin(poin);
        }
        return getRandomMinPoin(poin);
        
        
        
        
        
    }

    private void cekBoard(Board boardB) {
        System.out.println("----------");
        Piece[][] sq = boardB.sq;
        for (Piece[] sq1 : sq) {
            for (Piece sq11 : sq1) {
                if ("Empty".equals(sq11.model)) {
                    System.out.print("0 ");
                }else{
                    System.out.print(sq11.model.charAt(0) + " " );
                }
                
            }
            System.out.println("");
        }
    }
}
