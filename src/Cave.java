import java.util.ArrayList;
import java.util.Scanner;

public class Cave extends Terrain {
    private int enemyNumber;
    private int dragonNumber;
    private ArrayList<Person> enemy;
    private final Scanner SCANNER = new Scanner(System.in);;


    Cave(String name, int level) {
        super(name, level);
        dragonNumber = (int) (Math.random() * 2);
        enemyNumber = ((int) (Math.random() * 4 + 2)) - dragonNumber;
        enemy = new ArrayList<>();
        for (int i = 0; i < dragonNumber; i++) {
            int x = i + 1;
            Person dragon = new Dragon("Dragon", x);
            enemy.add(dragon);
        }
        for (int i = 0; i < enemyNumber; i++) {
            int x = i + 1;
            Person skeleton = new Person("Skeleton", x, x * 100);
            enemy.add(skeleton);
        }
    }

    public void fightMenu() {
        System.out.println("\n------FIGHT MENU------");
        for (int i = 0; i < enemy.size(); i++) {
            if (enemy.get(i) == null) {
                System.out.println("-" + (i + 1) + "- " + enemy.get(i).getName() + " SLAIN");
            } else {
                System.out.println("-" + (i + 1) + "- " + enemy.get(i).menu());
            }
        }
        System.out.println("----------------------");
        System.out.println("-1- ATTACK");
        System.out.println("-2- USE ITEM");
        System.out.println("-3- VIEW STATS");
        System.out.println("-4- ESCAPE");

    }
    public void mineMenu(Player player) {
        System.out.println("----------------------");
        int randomNumber = (int) (Math.random() * 5 + 1);
        System.out.print("Select a random number from 1 to 5: ");
        int playerNumber = SCANNER.nextInt();
        if (randomNumber == playerNumber) {
            System.out.println("Congratulations! You guessed correctly. You win " + (randomNumber * 5) + " gold!");
            player.changeGold(randomNumber * 5);
        } else {
            System.out.println("The number was " + randomNumber);
        }

    }

}
