import java.util.Scanner;
public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Town town;
    private Shop shop;
    private Player player;
    public Game() {
        town = new Town("Town", 1);
        shop = new Shop();
        player = null;
    }
    public void start() {
        welcomePlayer();
        menu();
    }
    private void welcomePlayer() {
        System.out.println("-------WELCOME-------");
        System.out.print("Please enter your name to start the game: ");
        String name = SCANNER.nextLine();
        player = new Player(name);
    }
    private void menu() {
        int choice = -1;
        while (choice != 6) { //IMPLEMENT
            System.out.println("\n---------MENU---------");
            System.out.println("-1- TRAVEL TO CAVES");
            System.out.println("-2- TRAVEL TO PLAINS");
            System.out.println("-3- GO TO SHOP");
            System.out.println("-4- GO TO TRADING HALL");
            System.out.println("-5- VIEW PLAYER MENU");
            System.out.println("-6- QUIT GAME");
            System.out.print("SELECT AN OPTION: ");
            choice = SCANNER.nextInt();
            choice(choice);
        }
    }
    private void choice(int choice) {
        System.out.println();
        if (choice == 1) {

        } else if (choice == 2) {

        } else if (choice == 3) {
            int shopChoice = -1;
            while (shopChoice != 3) {
                shop.shopMenu();
                shopChoice = SCANNER.nextInt();
                SCANNER.nextLine();
                shopChoice(shopChoice);
            }
        } else if (choice == 4) {
            town.trade();
        } else if (choice == 5) {
            System.out.println(player.menu());
        } else if (choice == 6) {
            System.out.println("GOODBYE");
        }else {
            System.out.println("INVALID SELECTION!");
        }
    }

    private void shopChoice(int shopChoice) {
        if (shopChoice == 1) {
            shop.itemCatalog();
            System.out.print("WOULD YOU LIKE TO PURCHASE AN ITEM [y/n]? ");
            String itemBuy = SCANNER.nextLine();
            if (itemBuy.equals("y")) {
                System.out.print("SELECT AN ITEM NAME: ");
                String itemSelect = SCANNER.nextLine();
                shop.buyItem(itemSelect, player);
            }

        } else if (shopChoice == 2) {
            System.out.print("ENTER AN ITEM NAME: ");
            String itemSell = SCANNER.nextLine();
            shop.sellItem(itemSell, player);

        } else if (shopChoice == 3) {
            System.out.println("GOODBYE");
        } else {

        }
    }
}
