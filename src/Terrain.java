public class Terrain {
    private String name;
    private int level;
    Terrain(String name, int level) {
        this.name = name;
        this.level = level;
    }
    public String returnName() {
        return name;
    }
    public int returnLevel() {
        return level;
    }

}
