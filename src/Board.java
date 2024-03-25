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
        for (int c = 0; c < grid[0].length; c++) {
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
    public void checkWinner() { // MAKE MORE EFFICIENT
        // check each row
        for (int r = 0; r < grid.length; r++) {
            int taken = 0;
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] instanceof TakenSpace) {
                    taken++;
                } else {
                    c = 5;
                }
            }
            if (taken == 5) {
                isWinner = true;
            }
        }
        // check each column
        for (int c = 0; c < grid[0].length; c++) {
            int taken = 0;
            for (int r = 0; r < grid.length; r++) {
                if (grid[r][c] instanceof TakenSpace) {
                    taken++;
                } else {
                    r = 5;
                }
            }
            if (taken == 5) {
                isWinner = true;
            }
        }
        // check diag
        int taken = 0;
        int taken1 = 0;
        for (int i = 0; i < 5; i++) {
            if (grid[i][i] instanceof TakenSpace) {
                taken++;
            }
            if (grid[i][4 - i] instanceof TakenSpace) {
                taken1++;
            }
        }
        if (taken == 5 || taken1 == 5) {
            isWinner = true;
        }
    }
    public void findDrawnNum() {
        int num = drawNum();
        System.out.println("Drawn number was: " + num);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
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
        String printBoard = Util.ANSI_BLACK_BACKGROUND + " B  I  N  G  O " + Util.ANSI_RESET + "\n";
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                printBoard+= grid[r][c] + " ";
                if (grid[r][c].getSpace().length() == 1) {
                    printBoard+=" ";
                }
            }
            printBoard+= Util.ANSI_RESET + "\n";
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


