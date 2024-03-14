public class Player extends Person{
    private Inventory inventory;
    private int gold;
    Player(String name) {
        super(name, 1, 100);
        inventory = new Inventory();
        gold = 0;
    }
    public Inventory returnInventory() {
        return inventory;
    }
    public int returnGold() {
        return gold;
    }
    public String menu() {
        return super.menu() + "\nGOLD: " + gold + "\nINVENTORY: "; //IMPLEMENT
    }
}
