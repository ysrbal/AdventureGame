import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);
    private int damage;
    private int health;
    private int coin;
    private String name;
    private String charName;

    public Player(String name) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
        this.charName = charName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void selectChar() {

    }
}
