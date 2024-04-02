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
        return super.toString();

    }
}
