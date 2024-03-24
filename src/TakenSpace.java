public class TakenSpace extends Space {
    TakenSpace(String space) {
        super(space);
    }
    public String toString() {
        return ANSI.ANSI_RED_BACKGROUND + super.toString();
    }

}
