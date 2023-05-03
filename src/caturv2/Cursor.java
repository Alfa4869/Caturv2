/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caturv2;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author ASUS
 */
public class Cursor {
    int row, col;
    GamePanel gp;
    KeyHandler keyH;
    
    boolean noUp, noDown, noLeft, noRight, noSpace;

    public Cursor(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        row = 0;
        col = 0;
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
            
            
            
            
            
            
            
            
            noSpace = true;
        }
        
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.orange);
        g2.fillRect(col*gp.tileSize, row*gp.tileSize, gp.tileSize, gp.tileSize);
    }
    
    
    
    
}