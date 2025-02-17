package com.example.chessengineguiproject;

import javafx.scene.image.ImageView;

public class Piece  extends HelloApplication{

private ImageView piece;
    public Piece(ImageView piece)
    {
        this.piece = piece;
    }
    public ImageView getPiece()
    {
        return piece;
    }
}
