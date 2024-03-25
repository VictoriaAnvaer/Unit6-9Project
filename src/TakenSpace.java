public class TakenSpace extends Space {
    TakenSpace(String space) {
        super(space);
    }
    public String toString() {
        return Util.ANSI_RED_BACKGROUND + super.toString();
    }

}
