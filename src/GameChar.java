public class GameChar {
    private String charName;
    private String idNumber;
    private int damage;
    private int health;
    private int coin;

    public GameChar(String ID, String charName, int damage, int health, int coin) {
        this.charName = charName;
        this.idNumber = ID;
        this.damage = damage;
        this.health = health;
        this.coin = coin;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String name) {
        this.charName = charName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

