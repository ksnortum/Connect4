import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

public class BoardView extends BorderPane {

    private GridPane grid;
    private TextField text;
    private Button enter;
    private Label playerTurn;

    public BoardView()
    {
        grid = new GridPane();
        grid.setGridLinesVisible(true);

        fillGrid();
        grid.setHgap(10);
        grid.setVgap(10);

        HBox top = new HBox();
        text = new TextField();
        enter = new Button("Enter Column Number");
        playerTurn = new Label("Player 1 turn (Red)");
        top.getChildren().addAll(text, enter, playerTurn);

        this.setCenter(grid);
        this.setTop(top);
        BorderPane.setMargin(top, new Insets(10, 20, 10, 20));
    }

    /**
     * Fills the grid with black boxes to represent each cell
     */
    public void fillGrid() {
        for (int i = 0; i < Board.ROWS; ++i) {
            for (int j = 0; j < Board.COLUMNS; ++j) {
                Label cell = new Label();
                cell.setStyle("-fx-background-color: #000000;");
                cell.setMinHeight(50);
                cell.setMinWidth(50);
                grid.add(cell, j, i);
            }
        }
    }

    public void addPiece(Piece piece) {
        int row = piece.getRow();
        int col = piece.getCol();
        Button button = piece.getPiece();
        grid.add(button, col - 1, row - 1);
    }

    public BorderPane getRoot() {
        return this;
    }

    public GridPane getGrid() {
        return grid;
    }

    public Button getEnter() {
        return enter;
    }

    public TextField getText() {
        return text;
    }

    public Label getPlayerTurn() {
        return playerTurn;
    }
}