import java.util.ArrayList;
public class Board {
    private String name;
    private Space[][] grid;
    private boolean isWinner;
    private ArrayList<Integer> drawNum;
    Board(String name) {
        this.name = name;
        //setting up grid
        grid = new Space[5][5];
        grid[2][2] = new TakenSpace("XX");
        int low = 1;
        for (int c = 0; c < 5; c++) {
            int[] ranArray = ranNum(low);
            int i = 0;
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] == null) {
                    grid[r][c] = new NumberSpace(ranArray[i]);
                    i++;
                }
            }
            low+=15;
        }
        drawNum = new ArrayList<>();
    }
    public boolean getIsWinner() {
        return isWinner;
    }
    public void findDrawnNum() {
        int num = drawNum();
        System.out.println("Drawn number was: " + num);
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (grid[r][c] instanceof NumberSpace) {
                    if (((NumberSpace) grid[r][c]).getNum() == num) {
                        grid[r][c] = new TakenSpace(grid[r][c].getSpace());
                    }

                }
            }
        }

    }

    @Override
    public String toString() {
        String printBoard = ANSI.ANSI_BLACK_BACKGROUND + " B  I  N  G  O " + ANSI.ANSI_RESET + "\n";
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < grid.length; c++) {
                printBoard+= grid[r][c] + " ";
                if (grid[r][c].getSpace().length() == 1) {
                    printBoard+=" ";
                }
            }
            printBoard+= ANSI.ANSI_RESET + "\n";
        }
        return printBoard;
    }
    private static int[] ranNum(int low) {
        int[] ranArray = new int[15];
        for (int i = 0; i < ranArray.length; i++) {
            ranArray[i] = i + low;
        }
        Util.shuffle(ranArray);
        return ranArray;
    }
    private int drawNum() {
        int num = (int) ( Math.random() * 74) + 1;
        for (int i = 0; i < drawNum.size(); i++) {
            if (drawNum.get(i) == num) {
                num = (int) ( Math.random() * 74) + 1;
                i = 0;
            }
        }
        drawNum.add(num);
        return num;
    }
}


