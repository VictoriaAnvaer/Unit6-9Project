import java.util.ArrayList;
public class Board {
    private String name;
    private Space[][] grid;
    private boolean isWinner;
    public static ArrayList<Integer> drawNum = new ArrayList<>();
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
    }
    public boolean getIsWinner() {
        return isWinner;
    }
    public String getName() {
        return name;
    }
    public static int drawNum() {
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
    public void findDrawnNum(int num) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] instanceof NumberSpace) {
                    if (((NumberSpace) grid[r][c]).getNum() == num) {
                        grid[r][c] = new TakenSpace(grid[r][c].getSpace());
                        checkWinner();
                    }
                }
            }
        }

    }

    @Override
    public String toString() {
        String printBoard = name + "\n" + Util.ANSI_BLACK_BACKGROUND + " B  I  N  G  O " + Util.ANSI_RESET + "\n";
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] instanceof TakenSpace) {
                    printBoard+=Util.ANSI_RED_BACKGROUND + grid[r][c] + Util.ANSI_WHITE_BACKGROUND + " ";
                } else {
                    printBoard+=Util.ANSI_WHITE_BACKGROUND + grid[r][c] + " ";
                }
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
    private void checkWinner() { // MAKE MORE EFFICIENT
        // check each row and diag
        int diag = 0;
        int diag1 = 0;
        for (int r = 0; r < grid.length; r++) {
            int taken = 0;
            if (grid[r][r] instanceof TakenSpace) {
                diag++;
            }
            if (grid[r][4 - r] instanceof TakenSpace) {
                diag1++;
            }
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] instanceof TakenSpace) {
                    taken++;
                } else {
                    c = 5;
                }
            }
            if (taken == 5) {
                isWinner = true;
                return;
            }
        }
        if (diag == 5 || diag1 == 5) {
            isWinner = true;
            return;
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
                return;
            }
        }
    }
}


