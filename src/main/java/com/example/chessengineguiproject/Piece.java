package com.example.chessengineguiproject;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;

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
    public void setUpDragAndDrop(ImageView source, Text target)
    {
        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                /* drag was detected, start a drag-and-drop gesture*/
                /* allow any transfer mode */
                System.out.println("drag detected");
                Dragboard db = source.startDragAndDrop(TransferMode.ANY);

                /* Put a string on a dragboard */
                ClipboardContent content = new ClipboardContent();
                db.setContent(content);

                event.consume();
            }
        });
    }
}
