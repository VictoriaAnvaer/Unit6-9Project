import java.util.Scanner;
public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Town town;
    private Shop shop;
    private Player player;
    public Game() {
        town = null;
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
        while (1 == 1) { //IMPLEMENT
            System.out.println("\n---------MENU---------");
            System.out.println("-1- TRAVEL TO CAVES");
            System.out.println("-2- TRAVEL TO PLAINS");
            System.out.println("-3- GO TO SHOP");
            System.out.println("-4- GO TO TRADING HALL");
            System.out.println("-5- VIEW PLAYER MENU");
            System.out.print("SELECT AN OPTION: ");
            int choice = SCANNER.nextInt();
            choice(choice);
        }
    }
    private void choice(int choice) {
        System.out.println();
        if (choice == 1) {

        } else if (choice == 2) {

        } else if (choice == 3) {

        } else if (choice == 4) {

        } else if (choice == 5) {
            System.out.println(player.menu());
        } else {
            System.out.println("INVALID SELECTION!");
        }
    }
}
