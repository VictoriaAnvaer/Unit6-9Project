import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Board board;
    private ArrayList<Board> boardList; // if player wants multiple boards or multiple players
    private ArrayList<Board> winningBoardList; // winning boards so that it does not interfere with asking if player wants to continue
    private boolean game;
    public Game() {
        boardList = new ArrayList<>();
        winningBoardList = new ArrayList<>();
        game = true;
    }
    public void start() {
        welcomePlayer();
        drawNumbers();
    }
    private void welcomePlayer() {
        System.out.println(Util.ANSI_RED + "\uD83C\uDFB0|------------WELCOME------------|\uD83C\uDFB0");
        System.out.print(Util.ANSI_BLUE + "\uD83D\uDC65 How many players would you like? ");
        int numPlayer = SCANNER.nextInt();
        SCANNER.nextLine();
        for (int i = 0; i < numPlayer; i++) {
            System.out.print("\uD83D\uDC64 Enter player " + (i + 1) + " name: ");
            String name = SCANNER.nextLine();
            board = new Board(name);
            boardList.add(board);
        }
        System.out.print(Util.ANSI_RESET);
    }
    private void drawNumbers() {
        while (game && !boardList.isEmpty()) {
            System.out.println();
            printBoards();
            System.out.print(Util.ANSI_RED + "ENTER" + Util.ANSI_RESET +  " when you are ready to draw next number ");
            SCANNER.nextLine();
            int drawnNum = Board.drawNum();
            System.out.println("\n\nDrawn number was: " + Util.ANSI_YELLOW +  drawnNum + Util.ANSI_RESET);
            // VVV so that winning boards also display updated for visual purposes VVV
            for (int i = 0; i < winningBoardList.size(); i++) {
                winningBoardList.get(i).findDrawnNum(drawnNum);
            }
            for (int i = 0; i < boardList.size(); i++) {
                boardList.get(i).findDrawnNum(drawnNum);
                if (boardList.get(i).getIsWinner()) {
                    System.out.println("\n" + boardList.get(i));
                    System.out.print(boardList.get(i).getName() + "'s board has won. Would you like to continue? [y/n] ");
                    String con = SCANNER.nextLine();
                    winningBoardList.add(winningBoardList.size(), boardList.remove(i));
                    if (con.equals("n")) {
                        game = false;
                    }
                }
            }
        }
        System.out.println();
        printBoards();
        System.out.println();
        System.out.println("Congratulations! You got a bingo.");
    }

    private void printBoards() {
        for (int i = 0; i < boardList.size(); i++) {
            System.out.println(boardList.get(i));
        }
        if (!winningBoardList.isEmpty()) {
            System.out.println("Winning Boards: ");
            for (int i = 0; i < winningBoardList.size(); i++) {
                System.out.println(winningBoardList.get(i));
            }
        }
    }
}
