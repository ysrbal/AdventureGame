public class GameChar {
    private String name;
    private String ID;
    private int damage;
    private int health;
    private int coin;

    public GameChar(String ID, String name, int damage, int health, int coin) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
}

