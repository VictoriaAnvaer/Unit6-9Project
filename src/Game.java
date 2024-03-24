import java.util.Scanner;
public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Board board;
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
        }
    }
}
