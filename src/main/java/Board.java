/*
Board has an array that contains 1 or 2, 1 is red, 2 is blue for where each piece currently is
Calculates when a winner has occured etc
 */

import java.util.*;

public class Board {

    public static final int ROWS = 6;
    public static final int COLUMNS = 7;
    public static final int RED = 1;
    public static final int BLUE = 2;
    private int[][] board;
    private List<Piece> pieces;

    public Board() {
        board = new int[ROWS][COLUMNS];
        pieces = new ArrayList<>();
    }

    /**
     * Add a 1 or 2 to board in the specified column if it is a valid column.
     * Create the piece and add it to the list of pieces
     * @param colour colour the piece in the GUI should be
     * @param col the column of the piece
     * @return piece if one was created, else null if column was not valid
     */
    public Piece addPiece(int colour, int col) {
        if (isColumnValid(col)) {
            int row = findRow(col);
            board[row -1][col - 1] = colour;
            Piece piece = new Piece(row, col, colour);
            pieces.add(piece);
            return piece;
        }
        else {
            return null;
        }
    }

    /**
     * Checks if the column is full by looking at the value of the top row in that column
     * and valid if is between 1 and max number of columns
     * @param col the column being checked
     * @return true if column is full, else false
     */
    public boolean isColumnValid(int col) {
        if (col > 0 && col <= COLUMNS) {
            return board[0][col - 1] == 0;
        }
        return false;
    }

    /**
     * Find the row the piece would be placed in if the column is valid
     * Will only be called if isColumnValid returns true
     * @param col the column of the piece
     * @return the row the piece should be in
     */
    public int findRow(int col) {
        int row = ROWS;
        boolean found = false;
        while (row > 0 && !found) {
            if (board[row - 1][col - 1] == 0) {
                found = true;
            }
            else {
                --row;
            }
        }
        return row;
    }

    public boolean redWinner()
    {

        boolean horizontal = checkHorizontal(Board.RED);
        boolean vertical = checkVertical(Board.RED);
        boolean diagonalRight = checkDiagonalRight(Board.RED);
        boolean diagonalLeft = checkDiagonalLeft(Board.RED);
        return (horizontal || vertical || diagonalRight || diagonalLeft);
    }
    public boolean blueWinner()
    {

        boolean horizontal = checkHorizontal(Board.BLUE);
        boolean vertical = checkVertical(Board.BLUE);
        boolean diagonalRight = checkDiagonalRight(Board.BLUE);
        boolean diagonalLeft = checkDiagonalLeft(Board.BLUE);
        return (horizontal || vertical || diagonalRight || diagonalLeft);
    }

    public boolean checkHorizontal(int colour)
    {
        for (int i = 1; i <= ROWS; i++ ) {
            for (int j = 1; j <= COLUMNS - 3; j++) {
                if (board[i - 1][j - 1] == colour && board[i - 1][j] == colour
                        && board[i - 1][j + 1] == colour && board[i - 1][j + 2] == colour) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkVertical(int colour)
    {
        for (int j = 1; j <= COLUMNS; j++ ) {
            for (int i = 1; i <= ROWS - 3; i++) {
                if (board[i - 1][j - 1] == colour && board[i][j - 1] == colour
                        && board[i + 1][j - 1] == colour && board[i +2][j - 1] == colour) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonalRight(int colour) // going north east or south west
    {
        for (int i = 4; i <= ROWS; i++) {
            for (int j = 1; j <= COLUMNS - 3; j++) {
                if (board[i - 1][j - 1] == colour && board[i-2][j] == colour
                        && board[i - 3][j + 1] == colour && board[i -4][j + 2] == colour) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonalLeft(int colour) { // going north west or south east
        for (int i = 4; i <= ROWS; i++) {
            for (int j = 4; j <= COLUMNS; j++) {
                if (board[i - 1][j - 1] == colour && board[i - 2][j - 2] == colour
                        && board[i - 3][j - 3] == colour && board[i -4][j - 4] == colour) {
                    return true;
                }
            }
        }
        return false;
    }

}
