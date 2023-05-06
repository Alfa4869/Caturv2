/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package caturv2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import GameRule.Board;

public class GamePanel extends JPanel implements Runnable{
    
    //SCREEN SETTING
    final int originalTileSize = 16;
    
    final int scale = 3;
    
    public final int tileSize = 720/8; // 90 x 90
    
    
    
    final int screenWidth = 720; // 768 px
    final int screenHeight = 720; // 576 px
    
    Thread gameThread;
    KeyHandler keyH = new KeyHandler();
    
    
    
    
    public int FPS = 60;
    
    
    Board PB = new Board(this);
    Cursor cursor = new Cursor(this, keyH);
    
    
    
    
    
    
    
    

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    
    
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        int drawCount= 0;
        double timer = 0;
        double currentTime;
        double lastTime = System.nanoTime();
        
        while(gameThread != null){
            //System.out.println("The Game loop is running");
            
            
            
            //Menghitung FPS-------------------------------
            currentTime = System.nanoTime();
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            drawCount++;
            if (timer >= 1000000000) {
                //System.out.println("FPS : " + drawCount);
                timer = 0;
                drawCount = 0;
            }
            //---------------------------------------
            
            
            
            //UPDATE
            update();
            
            
            //THEN PAINT
            repaint();
            
            
            //program sleep selama 1/60 second lalu looping lagi sehingga
            //tercipta 60 FPS
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                
                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                
                Thread.sleep((long) remainingTime);
                
                nextDrawTime += drawInterval;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(){
        cursor.update();
        
    }
    
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        
        Graphics2D g2 = (Graphics2D)G;
        
        PB.draw(g2);
        
        cursor.draw(g2);
        
        g2.dispose();
    }
}
