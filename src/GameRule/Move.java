/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameRule;

/**
 *
 * @author ASUS
 */
public class Move {
    int rowFrom, colFrom, rowTo, colTo;
    String model;
    String type;

    public Move(int rowFrom, int colFrom, int rowTo, int colTo, String model, String type) {
        this.rowFrom = rowFrom;
        this.colFrom = colFrom;
        this.rowTo = rowTo;
        this.colTo = colTo;
        this.model = model;
        this.type = type;
    }

    public Move(int rowFrom, int colFrom, int rowTo, int colTo, String model) {
        this.rowFrom = rowFrom;
        this.colFrom = colFrom;
        this.rowTo = rowTo;
        this.colTo = colTo;
        this.model = model;
        this.type = "normal";
    }
    
    
}
