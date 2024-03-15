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
    public void changeGold(int change) {
        gold+=change;
    }
    @Override
    public String menu() {
        return "------PLAYER MENU------\n" + super.menu() + "\nGOLD: " + gold + "\nINVENTORY: " + inventory.returnItems();
    }
}
