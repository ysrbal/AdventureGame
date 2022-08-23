public class Monster {
    private String monsterName;
    private int monsterID;
    private int monsterDamage;
    private int monsterFirstHealth;
    private int monsterHealth;
    private int monsterAwardCoin;

    public Monster(String monsterName, int monsterID, int monsterDamage, int monsterHealth, int monsterAwardCoin) {
        this.monsterName = monsterName;
        this.monsterID = monsterID;
        this.monsterDamage = monsterDamage;
        this.monsterHealth = monsterHealth;
        this.monsterAwardCoin = monsterAwardCoin;
        this.monsterFirstHealth = monsterHealth;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getMonsterID() {
        return monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public int getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(int monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    public int getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(int monsterHealth) {
        if (monsterHealth < 0) {
            monsterHealth = 0;
        }
        this.monsterHealth = monsterHealth;
    }

    public int getMonsterAwardCoin() {
        return monsterAwardCoin;
    }

    public void setMonsterAwardCoin(int monsterAwardCoin) {
        this.monsterAwardCoin = monsterAwardCoin;
    }

    public int getMonsterFirstHealth() {
        return monsterFirstHealth;
    }

    public void setMonsterFirstHealth(int monsterFirstHealth) {
        this.monsterFirstHealth = monsterFirstHealth;
    }

    public void printMonsterInfo() {
        System.out.println("##############");
        System.out.println(this.getMonsterName() + " stats");
        System.out.println("Name : " + this.getMonsterName() +
                "\tDamage : " + this.getMonsterDamage() +
                "\t Health : " + this.getMonsterHealth() +
                "\t Award : " + this.getMonsterAwardCoin());
    }
}
