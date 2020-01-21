import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
    	launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
        Board board = new Board();
        BoardView boardView = new BoardView();
        Scene scene = new Scene(boardView, 500, 500);
        new BoardController(board, boardView);
        
        stage.setTitle("Connect4");
        stage.setScene(scene);
        stage.show();
	}

}