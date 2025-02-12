package com.example.chessengineguiproject;

import javafx.scene.image.Image;

public class Bishop {
    private int row;
    private int col;
    private Image bishop;
    public Bishop(Image bishop, int col, int row) {
        this.row = row;
        this.col = col;
        this.bishop= bishop;

    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Image getBishop() {
        return bishop;
    }
}
