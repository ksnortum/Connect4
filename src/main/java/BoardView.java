import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

public class BoardView extends Application {

    private BorderPane root;
    private GridPane grid;
    private TextField text;
    private Button enter;
    private Label playerTurn;

    /**
     * The main entry point for JavaFX programs.
     */
    @Override
    public void start(Stage stage)
    {
        root = new BorderPane();

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

        root.setCenter(grid);
        root.setTop(top);
        root.setMargin(top, new Insets(10, 20, 10, 20));

        Scene scene = new Scene(root, 500, 500);
        stage.setTitle("Connect4");
        stage.setScene(scene);
        stage.show();
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
        return root;
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