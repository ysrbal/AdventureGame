import java.util.Scanner;

public class Game {
    private Scanner scan = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Adventure !!");
        System.out.print("Please enter the character name : ");
        String playerName = scan.nextLine();
        Player p1 = new Player(playerName);
        System.out.println("We wish you success in this challenging adventure "+p1.getName()+"!!");
        System.out.println("-------------------------------------------");
        p1.selectChar();
        System.out.println("-------------------------------------------");

    }
}
