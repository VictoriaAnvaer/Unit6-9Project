import java.util.Scanner;
public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Board board;
    //private Board[][] boardList; // if player wants multiple boards or multiple players
    public Game() {
    }
    public void start() {
        welcomePlayer();
        drawNumbers();
    }
    private void welcomePlayer() {
        System.out.println("-------WELCOME-------");
        System.out.print("Enter your name: ");
        String name = SCANNER.nextLine();
        board = new Board(name);
    }
    private void drawNumbers() {
        while (!board.getIsWinner()) {
            System.out.println(board);
            System.out.println("ENTER when you are ready to draw next number");
            SCANNER.nextLine();
            board.findDrawnNum();
            board.checkWinner();
        }
        System.out.println(board);
        System.out.println("Congratulations! you have won.");
    }
}
