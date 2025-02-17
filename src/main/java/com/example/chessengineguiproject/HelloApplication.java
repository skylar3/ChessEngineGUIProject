package com.example.chessengineguiproject;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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
        //drag piece logic
        //get node from chess board.
        //make a funcion that adds
        // Add chessboard and pieces to the layout
        root.getChildren().addAll(chessBoardView, chessBoardLayout);
        addDragAll(chessBoardLayout);















        // Set up the scene
        //removeNodeByRowColumnIndex(1, 1, chessBoardLayout);

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
        addDrag(imageView, gridPane);
        addTarget(gridPane,col,row);



        System.out.println(pieceImage.toString());

    }
    public void removeNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
       Node node  = getNodeFromGridPane(gridPane, column, row);

        gridPane.getChildren().remove(node);
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
    private int convertLayoutXtoGridX(int layoutX) {
        return (int)layoutX/75;
    }
    private int convertLayoutYtoGridY(int layoutY) {
        return (int)layoutY/75;
    }


    /**
     * Below defines the Dragging mechanisms. Defines a source to drag and a target.
     * @param piece
     * @param chessBoardLayout
     */
    private void addDrag(Node piece, GridPane chessBoardLayout)
    {

        // 1. Create the Drag Source



        // Set an action when the label is detected for dragging
        piece.setOnDragDetected(event -> {


            // Start a drag-and-drop operation with COPY transfer mode
            Dragboard db = piece.startDragAndDrop(TransferMode.COPY);

            // Define the content to be transferred
            ClipboardContent content = new ClipboardContent();
            //content.putString(piece.getLayoutX() + "," + piece.getLayoutY());
            content.putString(convertLayoutXtoGridX((int)piece.getLayoutX()) + "," + convertLayoutYtoGridY((int)piece.getLayoutY()));  // Store as a string "col,row"

            ImageView imageView = (ImageView) piece;
            content.putImage(imageView.getImage());

            // Set the content for the dragboard
            db.setContent(content);

            // Consume the event to indicate that it's being handled
            event.consume();
            piece.setOnDragDone(new EventHandler <DragEvent>() {
                public void handle(DragEvent event) {
                    /* the drag-and-drop gesture ended */
                    System.out.println("onDragDone");

                    /* if the data was successfully moved, clear it */


                    event.consume();
                }
            });

        });
    }

    private void addTarget(GridPane gridPane, int col, int row) {
        Label dropTarget = new Label(row+ col + "");
        gridPane.add(dropTarget, col, row);
        // Set an action when a drag enters the drop target area
        dropTarget.setOnDragOver(event -> {

                    // Check if the dragged item is not the drop target itself and if it contains string data
                    if (event.getGestureSource() != dropTarget) {

                        // Accept the transfer modes (COPY or MOVE in this case)
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

                    }


                    // Consume the event to indicate that it's being handled
                });

            dropTarget.setOnDragDropped(event->{

                Dragboard db = event.getDragboard();
                if (db.hasString()) { // Checking if there is string data (the original position)
                    // Retrieve the original position (col, row) from the dragboard
                    String position = db.getString();
                    System.out.println(position);
                    if (position != null) {
                        String[] positionParts = position.split(",");
                        int originalCol = Integer.parseInt(positionParts[0]);
                        int originalRow = Integer.parseInt(positionParts[1]);

                        removeNodeByRowColumnIndex(originalRow, originalCol, gridPane);
                        removeNodeByRowColumnIndex(originalRow, originalCol, gridPane);

                    }
                }

                boolean success = false;
                if(getNodeFromGridPane(gridPane, col, row) != null) {
                    addPiece(gridPane,db.getImage(), col, row);


                    success = true;
                    System.out.println(db.getImage());
                }
                event.setDropCompleted(success);

                event.consume();
                });
    }

    private void addDragAll(GridPane chessBoardLayout) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Node piece = getNodeFromGridPane(chessBoardLayout, i, j);
                if (piece != null) {

                    addDrag(piece, chessBoardLayout);

                }
                addTarget(chessBoardLayout, i, j);

            }
        }
    }



    public static void main(String[] args) {
        launch();
    }
}