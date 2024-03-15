public class Shop {
    String[][] items;
    int[][] itemsPrice;
    Shop() {
        items = new String[][]{{"Novice Sword", "Advanced Sword", "Legendary Sword"},
                {"Novice Shield", "Advanced Shield", "Legendary Shield"},
                {"Pickaxe", "Health Potion", "Attack Potion"}};
        itemsPrice = new int[][]{{10, 15, 25}, {10, 15, 25}, {20, 5, 5}};
    }

    public void shopMenu() {
        System.out.println("---------SHOP---------");
        System.out.println("-1- VIEW ITEM CATALOG");
        System.out.println("-2- SELL AN ITEM");
        System.out.println("-3- LEAVE");
        System.out.print("SELECT AN OPTION: ");
    }
    public boolean buyItem(String item, Player player) {
        for (int r = 0; r < items.length; r++) {
            for (int c = 0; c < items.length; c++) {
                if (items[r][c] != null && items[r][c].equals(item)) {
                    if (player.returnGold() >= itemsPrice[r][c]) {
                        player.changeGold(-itemsPrice[r][c]);
                        player.returnInventory().addItem(items[r][c]);
                        if (r == 1 || r == 2) {
                            items[r][c] = null;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean sellItem(String item, Player player) {
        for (int r = 0; r < items.length; r++) {
            for (int c = 0; c < items[r].length; c++) {
                if (items[r][c] != null && items[r][c].equals(item)) {
                    player.changeGold(itemsPrice[r][c]);
                    return true;
                }
            }
        }
        return false;
    }

    public void itemCatalog() {
        System.out.println();
        for (int r = 0; r < items.length; r++) {
            System.out.print("SHELF " + (r + 1));
            for (int c = 0; c < items[r].length; c++) {
                if (items[r][c] == null) {
                    System.out.println("| EMPTY");
                } else {
                    System.out.print(" | " + items[r][c] + " " + itemsPrice[r][c] + "G");
                }
            }
            System.out.print(" |\n");
        }
        System.out.println();
    }
}
