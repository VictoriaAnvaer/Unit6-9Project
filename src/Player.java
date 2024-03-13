public class Player extends Person{
    private Inventory inventory;
    Player(String name, int level) {
        super(name, level, 100);
        inventory = new Inventory();
    }
    public Inventory returnInventory() {
        return inventory;
    }
}
