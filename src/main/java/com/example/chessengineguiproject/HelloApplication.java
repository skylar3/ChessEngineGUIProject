package com.example.chessengineguiproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Create a StackPane to hold everything
        StackPane root = new StackPane();

        // Load chessboard background image
        Image chessBoardImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/chessengineguiproject/ChessBoard.png")));
        ImageView chessBoardView = new ImageView(chessBoardImage);
        chessBoardView.setFitWidth(600); // Set the width of the chessboard
        chessBoardView.setFitHeight(600); // Set the height of the chessboard

        // Create the GridPane for pieces
        GridPane chessBoardLayout = new GridPane();
        chessBoardLayout.setHgap(0);
        chessBoardLayout.setVgap(0);

        // Set the dimensions for the GridPane (8x8 grid)
        chessBoardLayout.setGridLinesVisible(false); // Disable grid lines

        // Set Column and Row Constraints to control the size
        double squareSize = 75;
        for (int i = 0; i < 8; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setPrefWidth(squareSize);  // Set the width of each column
            chessBoardLayout.getColumnConstraints().add(colConstraints);

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPrefHeight(squareSize);  // Set the height of each row
            chessBoardLayout.getRowConstraints().add(rowConstraints);
        }

        // Load chess piece images and resize
        Image whitePawn = loadImage("/com/example/chessengineguiproject/Chess Assets/pw.png", squareSize);
        Image blackPawn = loadImage("/com/example/chessengineguiproject/Chess Assets/pb.png", squareSize);
        Image whiteKing = loadImage("/com/example/chessengineguiproject/Chess Assets/kw.png", squareSize);
        Image blackKing = loadImage("/com/example/chessengineguiproject/Chess Assets/kb.png", squareSize);
        Image whiteQueen = loadImage("/com/example/chessengineguiproject/Chess Assets/qw.png", squareSize);
        Image blackQueen = loadImage("/com/example/chessengineguiproject/Chess Assets/qb.png", squareSize);
        Image whiteBishop = loadImage("/com/example/chessengineguiproject/Chess Assets/bw.png", squareSize);
        Image blackBishop = loadImage("/com/example/chessengineguiproject/Chess Assets/bb.png", squareSize);
        Image whiteKnight = loadImage("/com/example/chessengineguiproject/Chess Assets/nw.png", squareSize);
        Image blackKnight = loadImage("/com/example/chessengineguiproject/Chess Assets/nb.png", squareSize);
        Image whiteRook = loadImage("/com/example/chessengineguiproject/Chess Assets/rw.png", squareSize);
        Image blackRook = loadImage("/com/example/chessengineguiproject/Chess Assets/rb.png", squareSize);

        // Add pieces to the board
        // White pieces (row 0 and 1)
        addPiece(chessBoardLayout, whiteRook, 0, 0);
        addPiece(chessBoardLayout, whiteKnight, 1, 0);
        addPiece(chessBoardLayout, whiteBishop, 2, 0);
        addPiece(chessBoardLayout, whiteQueen, 3, 0);
        addPiece(chessBoardLayout, whiteKing, 4, 0);
        addPiece(chessBoardLayout, whiteBishop, 5, 0);
        addPiece(chessBoardLayout, whiteKnight, 6, 0);
        addPiece(chessBoardLayout, whiteRook, 7, 0);

        // White pawns (row 1)
        for (int i = 0; i < 8; i++) {
            addPiece(chessBoardLayout, whitePawn, i, 1);
        }

        // Black pieces (row 6 and 7)
        addPiece(chessBoardLayout, blackRook, 0, 7);
        addPiece(chessBoardLayout, blackKnight, 1, 7);
        addPiece(chessBoardLayout, blackBishop, 2, 7);
        addPiece(chessBoardLayout, blackQueen, 3, 7);
        addPiece(chessBoardLayout, blackKing, 4, 7);
        addPiece(chessBoardLayout, blackBishop, 5, 7);
        addPiece(chessBoardLayout, blackKnight, 6, 7);
        addPiece(chessBoardLayout, blackRook, 7, 7);

        // Black pawns (row 6)
        for (int i = 0; i < 8; i++) {
            addPiece(chessBoardLayout, blackPawn, i, 6);
        }

        // Add chessboard and pieces to the layout
        root.getChildren().addAll(chessBoardView, chessBoardLayout);

        final Text source = new Text(50, 100, "DRAG ME");
        final Text target = new Text(300, 100, "DROP HERE");




        // Set up the scene
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Chess Game");
        stage.setScene(scene);
        stage.show();
    }

    private Image loadImage(String path, double size) {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(path)));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        return image;
    }

    private void addPiece(GridPane gridPane, Image pieceImage, int col, int row) {
        ImageView imageView = new ImageView(pieceImage);
        imageView.setFitWidth(75);  // Resize the piece
        imageView.setFitHeight(75); // Resize the piece
        gridPane.add(imageView, col, row); // Place piece at the specified position
    }

    public static void main(String[] args) {
        launch();
    }
}
