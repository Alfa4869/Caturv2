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
import caturv2.GamePanel;
import java.awt.Color;
import java.awt.Graphics2D;
/**
 *
 * @author ASUS
 */
public class Board {
    GamePanel gp;
    public Piece[][] sq;

    public Board(GamePanel gp) {
        this.gp = gp;
        
        sq = new Piece[8][8];
        initBoard();
    }
    
    private void initBoard(){
        for (int row = 0; row < sq.length; row++) {
            for (int col = 0; col < sq[row].length; col++) {
                sq[row][col] = new Empty(row,col,true, this);
            }
        }
        
        
        sq[0][0] = new Rook(0,0,false, this);
        sq[0][1] = new Knight(0,1,false, this);
        sq[0][2] = new Bishop(0,2,false, this);
        sq[0][3] = new Queen(0,3,false, this);
        sq[0][4] = new King(0,4,false, this);
        sq[0][5] = new Bishop(0,5,false, this);
        sq[0][6] = new Knight(0,6,false, this);
        sq[0][7] = new Rook(0,7,false, this);
        
        for (int i = 0; i < 8; i++) {
            sq[1][i] = new Pawn(1,i,false, this);
        }
        
        sq[7][0] = new Rook(7,0,true, this);
        sq[7][1] = new Knight(7,1,true, this);
        sq[7][2] = new Bishop(7,2,true, this);
        sq[7][3] = new Queen(7,3,true, this);
        sq[7][4] = new King(7,4,true, this);
        sq[7][5] = new Bishop(7,5,true, this);
        sq[7][6] = new Knight(7,6,true, this);
        sq[7][7] = new Rook(7,7,true, this);
        
        for (int i = 0; i < 8; i++) {
            sq[6][i] = new Pawn(6,i,true, this);
        }
    }
    
    
    public void draw(Graphics2D g2){
        
        boolean isWhite = true;
        int x,y;
        
        y = 0;
        for (int row = 0; row < sq.length; row++) {
            isWhite = !isWhite;
            x = 0;
            for (int col = 0; col < sq[row].length; col++) {
                if (isWhite) {
                    g2.setColor(Color.white);
                }else{
                    g2.setColor(Color.gray);
                }
                isWhite = !isWhite;
                
                g2.fillRect(x, y, gp.tileSize, gp.tileSize);
                
                
                if (!"Empty".equals(sq[row][col].model)) {
                    g2.drawImage(sq[row][col].image, x, y, null);
                }
                
                x += gp.tileSize;
            }
            
            y += gp.tileSize;
        }
        
    }
    
    
}
