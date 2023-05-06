/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caturv2;

import java.awt.Color;
import java.awt.Graphics2D;

import GameRule.Board;
import GameRule.Move;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author ASUS
 */
public class Cursor {
    int row, col;
    GamePanel gp;
    KeyHandler keyH;
    BufferedImage cursorImage, moveImage;
    
    
    //lokal
    boolean noUp, noDown, noLeft, noRight, noSpace;
    int currentRow, currentCol;
    List<Move> movesToShow;

    public Cursor(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        row = 0;
        col = 0;
        
        movesToShow = new ArrayList();
        
        getImages();
    }
    
    
    void resetMovesToShow(){
        movesToShow.clear();
    }
    
    
    Move getThisMove(int row, int col){
        for (Move move : movesToShow) {
            if (move == null) {
                break;
            }
            
            if (move.rowTo == row && move.colTo == col) {
                return move;
            }
        }
        return null;
    }
    
    boolean isInMoves(int row, int col){
        for (Move move : movesToShow) {
            if (move == null) {
                break;
            }
            
            if (move.rowTo == row && move.colTo == col) {
                return true;
            }
        }
        return false;
    }
    
    public void update(){
        
        if (!keyH.upPressed) {
            noUp = false;
        }
        if(!keyH.downPressed){
            noDown = false;
        }
        if(!keyH.leftPressed){
            noLeft = false;
        }
        if(!keyH.rightPressed){
            noRight = false;
        }
        if (!keyH.spacePressed) {
            noSpace = false;
        }
        
        
        if (keyH.upPressed == true && row != 0 && !noUp) {
            row --;
            noUp = true;
        }
        if (keyH.downPressed == true && row != 7 && !noDown) {
            row++;
            noDown = true;
        }
        if (keyH.leftPressed == true && col != 0 && !noLeft) {
            col--;
            noLeft = true;
        }
        if (keyH.rightPressed == true && col != 7 && !noRight) {
            col++;
            noRight = true;
            
        }
        
        
        if (keyH.spacePressed == true && !noSpace) {
            
            
            
            
            if (isInMoves(row,col)) {
                gp.PB.movePiece(getThisMove(row,col));
                resetMovesToShow();
                gp.PB.isCheckMate(true);
                gp.PB.isCheckMate(false);
                
                
                
            }else{
                currentRow = row;
                currentCol = col;
                movesToShow = gp.PB.sq[row][col].getLegalMoves();
            }
            
            
            
            
            
            
            noSpace = true;
        }
        
    }
    
    
    private void getImages(){
        try{
            
            cursorImage = ImageIO.read(getClass().getResourceAsStream("asset/cursor.png"));

            moveImage = ImageIO.read(getClass().getResourceAsStream("asset/legal_move.png"));
            
                
            
            
        }catch(Exception e){}
    }
    
    public void draw(Graphics2D g2){
        drawAvailableMove(g2);
        
        
        g2.drawImage(cursorImage, col*gp.tileSize, row*gp.tileSize, null);
        
        
    }
    
    public void drawAvailableMove(Graphics2D g2){
        
        for (Move movesToShow1 : movesToShow) {
            
            //g2.fillRect(movesToShow1.colTo * gp.tileSize, movesToShow1.rowTo * gp.tileSize, gp.tileSize, gp.tileSize);
            g2.drawImage(moveImage, movesToShow1.colTo * gp.tileSize, movesToShow1.rowTo*gp.tileSize, null);
        
        }
    }
    
    
    
    
}