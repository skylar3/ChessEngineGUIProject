package com.example.chessengineguiproject;

import javafx.scene.image.Image;

public class Knight {
    private Image knight;
    private int row;
    private int col;
    public Knight(Image knight, int col, int row) {
        this.knight = knight;
        this.col = col;
        this.row = row;
    }
    public Image getKnight() {
        return knight;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
}
