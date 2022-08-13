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
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Please select the character : ");
        for (GameChar character : charList) {
            System.out.println("ID : " + character.getIdNumber() +
                    "\t Name : " + character.getCharName() +
                    "\t Damage : " + character.getDamage() +
                    "\t Health : " + character.getHealth() +
                    "\t Coin : " + character.getCoin());
        }
        System.out.print("Please choose one : ");
        int selectID = scan.nextInt();
        switch (selectID) {
            case 1:
                initChar(new Samurai());
                break;
            case 2:
                initChar(new Archer());
                break;
            case 3:
                initChar(new Knight());
                break;
            default:
                initChar(new Archer());
        }

        System.out.println("Your character is ");
        System.out.println("Name : " + this.getCharName() +
                "\t Damage :  " + this.getDamage() +
                "\t Health : " + this.getHealth() +
                "\t Money : " + this.getCoin());

    }

    public void selectLoc() {
        while (true) {
            Location location = null;
            System.out.println("##### -- Locations -- #####");
            System.out.println("ID : 1 - Safe House --> There is no enemy !!" +
                    "\nID : 2 - Store \t--> You buy something and improve yourself !!");

            System.out.print("Please choose one : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new Store(this);
                    break;
                default:
                    location = new SafeHouse(this);
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER !!");
                break;
            }
        }
    }

    public void initChar(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
        this.setCharName(gameChar.getCharName());
    }

}
