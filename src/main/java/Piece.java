/*
Piece needs a row, a column, a colour
add a button for it later
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

public class Piece {

    private int row;
    private int col;
    private int colour;
    private Button piece;

    public Piece(int row, int col, int colour) {
        this.row = row;
        this.col = col;
        this.colour = colour;
        createPiece();
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getColour() {
        return colour;
    }

    public Button getPiece() {
        return piece;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Create the javafx button for the piece
     */
    public void createPiece() {
        piece = new Button();
        piece.setMinSize(50, 50);
        if (colour == 1) {
            piece.setStyle("-fx-background-color: #f70d1a;" + "-fx-background-radius: 50em; ");
        } else {
            piece.setStyle("-fx-background-color: #add8e6;" + "-fx-background-radius: 50em; ");
        }
    }

}