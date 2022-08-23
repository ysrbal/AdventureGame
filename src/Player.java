import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);
    private int damage;
    private int block;
    private int playerFirstHealth;
    private int health;
    private int coin;
    private String name;
    private String charName;
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
        this.charName = charName;
        this.block = block;
        this.inventory = new Inventory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getItemDamage();
    }

    public int getDamage() {
        return damage;
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

    public int getBlock() {
        return block + this.getInventory().getArmor().getItemBlock();
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getPlayerFirstHealth() {
        return playerFirstHealth;
    }

    public void setPlayerFirstHealth(int playerFirstHealth) {
        this.playerFirstHealth = playerFirstHealth;
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
                "\t Money : " + this.getCoin() +
                "\t Block : " + this.getBlock());

    }

    public void printPlayerInfo() {
        System.out.println("##############");
        System.out.println("Your stats :");
        System.out.println("Weapon : " + this.getInventory().getWeapon().getItemName() +
                "\t Damage :  " + this.getTotalDamage() +
                "\t Armor : " + this.getInventory().getArmor().getItemName() +
                "\t Block : " + this.getBlock() +
                "\t Health : " + this.getHealth() +
                "\t Money : " + this.getCoin());

    }

    public void selectLoc() {
        Location location = null;
        while (true) {
            if(isWin(this)){
                System.out.println("#####################");
                System.out.println("Congratulations !!");
                System.out.println("You finished the game !! See you next adventure.");
                break;
            }
            printPlayerInfo();
            System.out.println();
            System.out.println("##### -- Locations -- #####");
            System.out.println();
            System.out.println("ID : 1 - Safe House --> There is no enemy !!" +
                    "\nID : 2 - Store\t-->You buy something and improve yourself !!" +
                    "\nID : 3 - Cave\t-->There are some strange noises coming from inside." +
                    "\nID : 4 - Forest\t-->It's a foggy and dark place. It looks dangerous." +
                    "\nID : 5 - River\t-->The river is cool and lots of fish available. There may be dangerous creatures that are hungry or thirsty." +
                    "\nID : 6 - Mine\t-->Strange sounds are coming from the depths." +
                    "\nID : 0 - Exit\t-->You can leave the game!!");

            System.out.print("Please choose one : ");
            int selectLoc = scan.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(this);
                    break;
                case 2:
                    location = new Store(this);
                    break;
                case 3:
                    location = new Cave(this);
                    break;
                case 4:
                    location = new Forest(this);
                    break;
                case 5:
                    location = new River(this);
                    break;
                case 6:
                    location = new Mine(this);
                    break;
                default:
                    location = new SafeHouse(this);
            }
            if (location == null) {
                System.out.println("I have failed you " + this.getName() + "!! I have failed you.");
                break;
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
        this.setPlayerFirstHealth(gameChar.getHealth());
        this.setCoin(gameChar.getCoin());
        this.setCharName(gameChar.getCharName());
    }

    public boolean isWin(Player player) {
        return getInventory().isFood() && getInventory().isWater() && getInventory().isWood();
    }

}
