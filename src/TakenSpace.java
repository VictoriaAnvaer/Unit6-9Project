public class TakenSpace extends Space {
    TakenSpace(String space) {
        super(space);
    }
    @Override
    public String toString() {
        return Util.ANSI_RED_BACKGROUND + super.toString() + Util.ANSI_WHITE_BACKGROUND;
    }

}
