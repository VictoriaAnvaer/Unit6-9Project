public class Player extends Person{
    private Inventory inventory;
    private int gold;
    Player(String name) {
        super(name, 1, 100);
        inventory = new Inventory();
        gold = 100;
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
    @Override
    public boolean defend() {
        if ((int) (Math.random() * 100 + 1) > (getLevel() + inventory.getShieldDefend()) * 5) {
            return false;
        }
        return true;
    }
}
