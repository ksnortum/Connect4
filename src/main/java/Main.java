public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        BoardView boardView = new BoardView();
        new BoardController(board, boardView);
    }

}