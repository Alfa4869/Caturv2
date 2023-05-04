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
    public int rowFrom, colFrom, rowTo, colTo;
    public String model;
    public String type;
    public boolean fromColor;

    public Move(int rowFrom, int colFrom, int rowTo, int colTo, String model, boolean fromColor, String type) {
        this.rowFrom = rowFrom;
        this.colFrom = colFrom;
        this.rowTo = rowTo;
        this.colTo = colTo;
        this.model = model;
        this.fromColor = fromColor;
        this.type = type;
    }

    public Move(int rowFrom, int colFrom, int rowTo, int colTo, String model, boolean fromColor) {
        this.rowFrom = rowFrom;
        this.colFrom = colFrom;
        this.rowTo = rowTo;
        this.colTo = colTo;
        this.model = model;
        this.fromColor = fromColor;
        this.type = "normal";
    }
    
    
}
