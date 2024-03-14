public class Person {
    private String name;
    private int level;
    private int health;

    Person(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public String returnName() {
        return name;
    }
    public int returnLevel() {
        return level;
    }
    public int returnHealth() {
        return health;
    }
    public String menu() {
        return "NAME: " + name + "\nLEVEL: " + level + "\nHEALTH: " + health;
    }

    public void attack() {
        //IMPLEMENT
    }
}
