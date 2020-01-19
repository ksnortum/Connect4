/*
This class controls the view and the model and tells each one what to do
 */

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BoardController {

    private Board board;
    private BoardView boardView;
    private int turn;

    public BoardController(Board board, BoardView boardView) {
        this.board = board;
        this.boardView = boardView;
        Stage stage = new Stage();
        boardView.start(stage);
        boardView.getEnter().setOnAction(e -> enterClicked());
    }

    public void enterClicked() {
        String text = boardView.getText().getText();
        try {
            int col = Integer.parseInt(text);
            Piece piece = board.addPiece(turn + 1, col);
            if (piece != null) {
                boardView.addPiece(piece);
                nextTurn();
            }
            else { // column not valid
                errorDialog();
            }

        }
        catch (NumberFormatException ex) {
            errorDialog();
        }
        boardView.getText().clear();

        if(hasWinner()) {
            winnerDialog();
        }
    }

    public void errorDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Enter a number between 1 and " + Board.COLUMNS);
        alert.showAndWait();
    }

    public void nextTurn() {
        turn = (turn + 1) % 2; // turn is either 1 or 2, red or blue
        boardView.getText().clear();
        Label playerTurn = boardView.getPlayerTurn();
        if ((turn + 1) == 1) {
            playerTurn.setText("Player 1 turn (Red)");
        }
        else {
            playerTurn.setText("Player 2 turn (Blue)");
        }
    }

    public boolean hasWinner()
    {
        if (board.redWinner()) {
            return true;
        }
        if (board.blueWinner()) {
            return true;
        }
        return false;
    }

    public void winnerDialog() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Winner");
        alert.setHeaderText(null);
        alert.setContentText("Player "+ turn + " wins!");
        alert.showAndWait();
    }

}
