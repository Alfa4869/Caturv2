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
        this.VB = createVirtualBoard(copySq(PB.sq));
        sq = VB.sq;
        this.color = color;
        
        LM = PB.getAllThisColorMoves(color);
    }
    
    
    
    
    

    @Override
    public Piece[][] copySq(Piece[][] oldSq) {
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
    public Board createVirtualBoard(Piece[][] oldSq) {
        return new Board(oldSq);    
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
    
    public int getThisMovePoin(){
        List<Integer> poin = new ArrayList();
        
        
        return Collections.max(poin);
        
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
    
    public Move getBestMove(int depth){
        List<Integer> poin = new ArrayList();
        
        Board localBoard;
        
        for (Move move : LM) {
            localBoard = createVirtualBoard(copySq(VB.sq));
            localBoard.movePiece(move);
            poin.add(localBoard.getPoinRatio());
        }
        
        System.out.println("-------");
        for (Integer poi : poin) {
            System.out.println(poi);
        }
        
        if (color) {
            return getRandomMaxPoin(poin);
        }
        return getRandomMinPoin(poin);
        
        
        
        
        
    }
}
