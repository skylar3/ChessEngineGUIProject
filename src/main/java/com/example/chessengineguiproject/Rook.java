package com.example.chessengineguiproject;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

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

    // Create the ImageView for the Rook piece
    public ImageView getRookImageView() {
        ImageView imageView = new ImageView(rook);
        imageView.setFitWidth(75);
        imageView.setFitHeight(75);

        return imageView;
    }

    private void setUpDragAndDrop(ImageView imageView) {
        imageView.setOnDragDetected(event -> {
            // Start drag event
            System.out.println("Drag Detected for Rook");

            Dragboard dragboard = imageView.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putImage(rook); // Put the image content on the clipboard
            dragboard.setContent(content);

            // Store the original position of the piece for later use
            event.consume();
        });

        imageView.setOnDragOver(event -> {
            // Allow drop if the target is a valid square
            if (event.getGestureSource() != imageView && event.getDragboard().hasImage()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
            event.consume();
        });

        imageView.setOnDragEntered(event -> {
            // Change appearance to indicate the piece can be dropped
            if (event.getGestureSource() != imageView && event.getDragboard().hasImage()) {
                imageView.setOpacity(0.5); // Example visual feedback
            }
            event.consume();
        });

        imageView.setOnDragExited(event -> {
            // Reset the appearance when drag exits
            imageView.setOpacity(1.0);
            event.consume();
        });

        imageView.setOnDragDropped(event -> {
            // Drop event handling
            boolean success = false;
            Dragboard dragboard = event.getDragboard();

            if (dragboard.hasImage()) {
                // Update the piece's position
                System.out.println("Piece Dropped");
                success = true;
            }
            event.setDropCompleted(success);
            event.consume();
        });

        imageView.setOnDragDone(event -> {
            // Cleanup after drag is done
            if (event.getTransferMode() == TransferMode.MOVE) {
                System.out.println("Drag Finished");
            }
            event.consume();
        });
    }
}
