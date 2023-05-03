/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameRule;

import Piece.Piece;
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
                x += gp.tileSize;
            }
            
            y += gp.tileSize;
        }
        
    }
    
    
}
