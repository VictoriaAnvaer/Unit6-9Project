public class Person {
    private String name;
    private int level;
    private int health;

    Person(String name, int level, int health) {
        this.name = name;
        this.level = level;
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public String menu() {
        return "NAME: " + name + " LEVEL: " + level + " HEALTH: " + health + "-";
    }

    public int attack() {
        return ((int) (Math.random() * 5 + 2) + level);
    }
    public boolean defend() {
        if ((int) (Math.random() * 100 + 1) > level * 5) {
            return false;
        }
        return true;
    }
}
