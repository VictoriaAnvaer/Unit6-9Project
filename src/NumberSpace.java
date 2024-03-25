public class NumberSpace extends Space {
    private int num;
    NumberSpace(int num) {
        super(String.valueOf(num));
        this.num = num;
    }
    public int getNum() {
        return num;
    }
    public String toString() {
        return Util.ANSI_WHITE_BACKGROUND + super.toString();

    }
}
