public class Space {
    private String space;
    Space(String space) {
        this.space = space;
    }
    public String getSpace() {
        return space;
    }
    @Override
    public String toString() {
        if (space.length() == 1) {
            return " " + space;
        }
        return space;
    }
}
