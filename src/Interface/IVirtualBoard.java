/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import GameRule.Board;
import Piece.Piece;

/**
 *
 * @author ASUS
 */
public interface IVirtualBoard {
    
    
    
    
    Piece[][] copySq(Board oldBoard, Board newBoard);
    
    Board createVirtualBoard(Board oldBoard);
        
        
        
    
}
