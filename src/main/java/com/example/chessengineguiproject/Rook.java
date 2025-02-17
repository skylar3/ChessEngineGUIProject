package com.example.chessengineguiproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook {
    private Image rook;
    private int row;
    private int col;

    public Rook(Image rook, int col, int row) {
        this.rook = rook;
        this.row = row;
        this.col = col;
    }

    public Image getRook() {
        return rook;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }

    // Create the ImageView for the Rook piece
    public ImageView getRookImageView() {
        ImageView imageView = new ImageView(rook);
        imageView.setFitWidth(75);
        imageView.setFitHeight(75);

        return imageView;
    }


}
