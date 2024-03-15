import java.util.ArrayList;

public class Inventory {
    ArrayList<String> items;
    String swordName;
    String shieldName;
    int swordAttack;
    int shieldDefend;
    Inventory() {
        swordName = "Starter Sword";
        shieldName = "Starter Shield";
        swordAttack = 2;
        shieldDefend = 2;
        items = new ArrayList<>();
        items.add(swordName);
        items.add(shieldName);
    }
    public ArrayList<String> returnItems() {
        return items;
    }
    public void addItem(String item) {
        items.add(item);
    }


}
