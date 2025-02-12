package com.example.chessengineguiproject;

import javafx.scene.image.Image;

public class Queen {
    private int row;
    private int col;
    private Image Queen;
    public Queen(Image Queen,int col, int row) {
        this.row = row;
        this.col = col;
        this.Queen = Queen;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Image getQueen() {
        return Queen;
    }
}
