package com.example.chessengineguiproject;

import javafx.scene.image.Image;

public class Pawn {
    private int row;
    private int col;
    private Image pawn;
    public Pawn(Image pawn, int col, int row) {
        this.row = row;
        this.col = col;
        this.pawn = pawn;
    }
    public int getCol() {
        return col;
    }
    public int getRow()
    {
        return row;
    }
    public Image getPawn()
    {
        return pawn;
    }
    public void setRow(int row)
    {
        this.row = row;
    }
    public void setCol(int col)
    {
        this.col=col;
    }
}
