import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Board board;
    private ArrayList<Board> boardList; // if player wants multiple boards or multiple players
    private boolean game;
    public Game() {
        boardList = new ArrayList<>();
        game = true;
    }
    public void start() {
        welcomePlayer();
        drawNumbers();
    }
    private void welcomePlayer() {
        System.out.println("-------WELCOME-------");
        System.out.print("How many players would you like? ");
        int numPlayer = SCANNER.nextInt();
        SCANNER.nextLine();
        for (int i = 0; i < numPlayer; i++) {
            System.out.print("Enter player " + (i + 1) + " name: ");
            String name = SCANNER.nextLine();
            board = new Board(name);
            boardList.add(board);
        }
    }
    private void drawNumbers() {
        while (game) {
            System.out.println();
            for (int i = 0; i < boardList.size(); i++) {
                System.out.println(boardList.get(i));
            }
            System.out.println("ENTER when you are ready to draw next number");
            SCANNER.nextLine();
            int drawnNum = Board.drawNum();
            System.out.println("Drawn number was: " + drawnNum);
            for (int i = 0; i < boardList.size(); i++) {
                boardList.get(i).findDrawnNum(drawnNum);
                if (boardList.get(i).getIsWinner()) {
                    //System.out.print(boardList.get(i).getName() + "'s board has won. Would you like to continue? [y/n] ");
                    //String con = SCANNER.nextLine();
                    //if (con.equals("n")) {
                        game = false;
                    //} FIX THIS PART SO THAT IT DOES NOT ASK EVERYTIME
                }
            }
        }
        for (int i = 0; i < boardList.size(); i++) {
            System.out.println(boardList.get(i));
            System.out.println();
        }
        System.out.println("Congratulations! Your board has won.");
    }
}
