package com.example.chessengineguiproject;

import javafx.scene.image.Image;

public class King {
    private int row;
    private int col;
    private Image king;
    public King(Image king, int col, int row) {
        this.king = king;
        this.col=col;
        this.row=row;
    }
    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public Image getKing() {
        return king;
    }
}
