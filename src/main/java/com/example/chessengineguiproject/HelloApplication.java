package com.example.chessengineguiproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        // Create a StackPane to hold everything
        Group root = new Group();


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
        Rook whiteRookL = new Rook(loadImage("/com/example/chessengineguiproject/Chess Assets/rw.png", squareSize), 0, 0);
        Rook whiteRookR = new Rook(loadImage("/com/example/chessengineguiproject/Chess Assets/rw.png", squareSize), 7, 0);
        Pawn whitePawn = new Pawn(loadImage("/com/example/chessengineguiproject/Chess Assets/pw.png", squareSize), 0,0);
        Pawn blackPawn = new Pawn(loadImage("/com/example/chessengineguiproject/Chess Assets/pb.png", squareSize), 0, 0);
        King whiteKing = new King(loadImage("/com/example/chessengineguiproject/Chess Assets/kw.png", squareSize), 4, 0);
        King blackKing = new King(loadImage("/com/example/chessengineguiproject/Chess Assets/kb.png", squareSize), 4, 7);
        Queen whiteQueen = new Queen(loadImage("/com/example/chessengineguiproject/Chess Assets/qw.png", squareSize), 3, 0);
        Queen blackQueen = new Queen(loadImage("/com/example/chessengineguiproject/Chess Assets/qb.png", squareSize), 3, 7);
        Bishop whiteBishopL = new Bishop(loadImage("/com/example/chessengineguiproject/Chess Assets/bw.png", squareSize), 2, 0);
        Bishop whiteBishopR = new Bishop(loadImage("/com/example/chessengineguiproject/Chess Assets/bw.png", squareSize), 5, 0);
        Bishop blackBishopL = new Bishop(loadImage("/com/example/chessengineguiproject/Chess Assets/bb.png", squareSize), 2, 7);
        Bishop blackBishopR = new Bishop(loadImage("/com/example/chessengineguiproject/Chess Assets/bb.png", squareSize), 7, 5);
        Knight whiteKnightL = new Knight(loadImage("/com/example/chessengineguiproject/Chess Assets/nw.png", squareSize), 1, 0);
        Knight whiteKnightR = new Knight(loadImage("/com/example/chessengineguiproject/Chess Assets/nw.png", squareSize), 6, 0);
        Knight blackKnightL = new Knight(loadImage("/com/example/chessengineguiproject/Chess Assets/nb.png", squareSize), 1, 7);
        Knight blackKnightR = new Knight(loadImage("/com/example/chessengineguiproject/Chess Assets/nb.png", squareSize), 6, 7);
        Rook blackRookL = new Rook(loadImage("/com/example/chessengineguiproject/Chess Assets/rb.png", squareSize), 0, 7);
        Rook blackRookR = new Rook(loadImage("/com/example/chessengineguiproject/Chess Assets/rb.png", squareSize), 7, 7);

        // Add pieces to the board
        // White pieces (row 0 and 1)
        addPiece(chessBoardLayout, whiteRookL.getRook(), whiteRookL.getCol(), whiteRookL.getRow());
        addPiece(chessBoardLayout, whiteKnightL.getKnight(), whiteKnightL.getCol(), whiteKnightL.getRow());
        addPiece(chessBoardLayout, whiteBishopL.getBishop(), whiteBishopL.getCol(), whiteBishopR.getRow());
        addPiece(chessBoardLayout, whiteQueen.getQueen(), whiteQueen.getCol(), whiteQueen.getRow());
        addPiece(chessBoardLayout, whiteKing.getKing(), whiteKing.getCol(), whiteKing.getRow());
        addPiece(chessBoardLayout, whiteBishopR.getBishop(), whiteBishopR.getCol(), whiteBishopR.getRow());
        addPiece(chessBoardLayout, whiteKnightR.getKnight(), whiteKnightR.getCol(), whiteKnightR.getRow());
        addPiece(chessBoardLayout, whiteRookR.getRook(), whiteRookR.getCol(), whiteRookR.getRow());

        // White pawns (row 1)
        for (int i = 0; i < 8; i++) {
            whitePawn.setCol(i);
            addPiece(chessBoardLayout, whitePawn.getPawn(),whitePawn.getCol(), 1);
        }

        // Black pieces (row 6 and 7)
        addPiece(chessBoardLayout, blackRookL.getRook(), blackRookL.getCol(), blackRookL.getRow());
        addPiece(chessBoardLayout, blackKnightL.getKnight(), blackKnightL.getCol(), blackKnightL.getRow());
        addPiece(chessBoardLayout, blackBishopL.getBishop(), blackBishopL.getCol(), blackBishopL.getRow());
        addPiece(chessBoardLayout, blackQueen.getQueen(), blackQueen.getCol(), blackQueen.getRow());
        addPiece(chessBoardLayout, blackKing.getKing(), blackKing.getCol(), blackKing.getRow());
        addPiece(chessBoardLayout, blackBishopR.getBishop(), blackBishopR.getRow(), blackBishopR.getCol());
        addPiece(chessBoardLayout, blackKnightR.getKnight(), blackKnightR.getCol(), blackKnightR.getRow());
        addPiece(chessBoardLayout, blackRookR.getRook(), blackRookR.getCol(), blackRookR.getRow());

        // Black pawns (row 6)
        for (int i = 0; i < 8; i++) {
            blackPawn.setCol(i);
            addPiece(chessBoardLayout, blackPawn.getPawn(), blackPawn.getCol(), 6);
        }

        // Add chessboard and pieces to the layout
        root.getChildren().addAll(chessBoardView, chessBoardLayout);

        ImageView source = whiteRookL.getRookImageView();
        final Text target = new Text(300, 100, "DROP HERE");













        //setup drag and drop logic
        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                System.out.println("drag detected");

                Dragboard db = source.startDragAndDrop(TransferMode.ANY);

                ClipboardContent content = new ClipboardContent();
                content.putImage(whiteRookL.getRook());
                db.setContent(content);

                event.consume();
            }
        });

        //drag and drop logic cont
        target.setOnDragOver(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasImage()) {
                    /* allow for both copying and moving, whatever user chooses */
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
        });
        target.setOnDragEntered(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                System.out.println("onDragEntered");
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != target &&
                        event.getDragboard().hasString()) {
                    target.setFill(Color.GREEN);
                }

                event.consume();
            }
        });
        target.setOnDragExited(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* mouse moved away, remove the graphical cues */
                target.setFill(Color.BLACK);

                event.consume();
            }
        });
        target.setOnDragDropped(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                System.out.println("onDragDropped");
                Dragboard db = event.getDragboard();
                boolean success = false;

                if (db.hasImage()) {
                    // If image is dropped, change the target to show the dropped image
                    target.setText("");  // Clear the "DROP HERE" text
                    ImageView droppedImage = new ImageView(db.getImage());
                    droppedImage.setFitWidth(75); // You can resize it as necessary
                    droppedImage.setFitHeight(75);
                    root.getChildren().add(droppedImage); // Add the dropped image to the scene

                    success = true;
                }

                event.setDropCompleted(success);
                event.consume();
            }
        });


        source.setOnDragDone(new EventHandler <DragEvent>() {
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture ended */
                System.out.println("onDragDone");
                /* if the data was successfully moved, clear it */


                event.consume();
            }
        });



        // Set up the scene
        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Chess Game");
        root.getChildren().add(source);
        root.getChildren().add(target);
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
