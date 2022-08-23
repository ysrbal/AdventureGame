import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private int maxMonsterNumber;
    private String award;

    public BattleLoc(Player player, int locIDNumber, String locName, Monster monster, int maxMonsterNumber, String award) {
        super(player, locIDNumber, locName);
        this.monster = monster;
        this.award = award;
        this.maxMonsterNumber = maxMonsterNumber;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public int getMaxMonsterNumber() {
        return maxMonsterNumber;
    }

    public void setMaxMonsterNumber(int maxMonsterNumber) {
        this.maxMonsterNumber = maxMonsterNumber;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int start() {
        int monsterNumber = this.randomMaxMonsterNumber();
        System.out.println("Be careful!! You are stepping into the danger zones.");
        System.out.println("Now, you're in a " + this.getLocName() + " and " + monsterNumber + " " + this.getMonster().getMonsterName() + " live here.");
        System.out.println("You have to beat them. If you win, you will get some Coin and " + getAward() + ".");
        System.out.println("What do you want now!!");
        System.out.print("Fight or Run : ");
        return monsterNumber;
    }

    @Override
    public boolean onLocation() {
        if (this.getLocName().equals("Mine")) {
            return getLocationMine();
        }
        int monsterNumber = start();
        String selectMoveCase = scan.nextLine().toLowerCase();
        if (selectMoveCase.equals("fight") && fight(monsterNumber)) {
            System.out.println("You've the killed all the enemies inside the " + this.getLocName());
            if (this.award.equals("Food") && !getPlayer().getInventory().isFood()) {
                this.getPlayer().getInventory().setFood(true);
                System.out.println("You earned " + this.award + ". " + this.award + " added your inventory.");
            } else if (this.award.equals("Wood") && !getPlayer().getInventory().isWood()) {
                this.getPlayer().getInventory().setWood(true);
                System.out.println("You earned " + this.award + ". " + this.award + " added your inventory.");
            } else if (this.award.equals("Water") && !getPlayer().getInventory().isWater()) {
                this.getPlayer().getInventory().setWater(true);
                System.out.println("You earned " + this.award + ". " + this.award + " added your inventory.");
            }
            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died !!");
            return false;
        }
        System.out.println("You coward !!");
        return true;
    }

    public boolean getLocationMine() {
        int monsterNumber = start();
        String selectMoveCase = scan.nextLine();
        selectMoveCase = selectMoveCase.toLowerCase();
        if (selectMoveCase.equals("fight") && fight(monsterNumber)) {
            System.out.println(this.getLocName() + " has been cleared !");

            int luckyNumber = random.nextInt(101);

            if (luckyNumber >= 55) {
                System.out.println("You've won nothing");
            } else if (luckyNumber >= 30) {
                System.out.println("You won random amount of money!");
                luckyNumber = random.nextInt(101);
                if (luckyNumber >= 50) {
                    System.out.println("You won 1 money! ");
                    getPlayer().setCoin(getPlayer().getCoin() + 1);
                } else if (luckyNumber >= 20) {
                    System.out.println("You won 5 money! ");
                    getPlayer().setCoin(getPlayer().getCoin() + 5);
                } else {
                    System.out.println("Jackpot! You won 10 money! ");
                    getPlayer().setCoin(getPlayer().getCoin() + 10);
                }
            } else if (luckyNumber >= 15) {
                System.out.println("You won random armour!");
                luckyNumber = random.nextInt(101);
                if (luckyNumber >= 50) {
                    System.out.println("You won light armour! ");
                    if (getPlayer().getInventory().getArmor().getItemBlock() > 1) {
                        System.out.println("But you have better armour! No changes");
                    } else {
                        getPlayer().getInventory().getArmor().setItemBlock(1);
                        System.out.println("You equipped your armour !");
                    }
                } else if (luckyNumber >= 20) {
                    System.out.println("You won medium armour! ");
                    if (getPlayer().getInventory().getArmor().getItemBlock() > 3) {
                        System.out.println("But you have better armour! No changes");
                    } else {
                        getPlayer().getInventory().getArmor().setItemBlock(3);
                        System.out.println("You equipped your armour !");
                    }
                } else {
                    System.out.println("You won heavy armour! ");
                    if (getPlayer().getInventory().getArmor().getItemBlock() > 5) {
                        System.out.println("But you have better armour! No changes");
                    } else {
                        getPlayer().getInventory().getArmor().setItemBlock(5);
                        System.out.println("You equipped your armour !");
                    }
                }
            } else {
                System.out.println("You won random weapon!");
                luckyNumber = random.nextInt(101);
                if (luckyNumber >= 50) {
                    System.out.println("You won gun! ");
                    if (getPlayer().getInventory().getWeapon().getItemDamage() > 2) {
                        System.out.println("But you have better weapon! No changes");
                    } else {
                        getPlayer().getInventory().getWeapon().setItemDamage(2);
                        System.out.println("You equipped your weapon !");
                    }
                } else if (luckyNumber >= 20) {
                    System.out.println("You won medium weapon! ");
                    if (getPlayer().getInventory().getWeapon().getItemDamage() > 3) {
                        System.out.println("But you have better weapon! No changes");
                    } else {
                        getPlayer().getInventory().getWeapon().setItemDamage(3);
                        System.out.println("You equipped your weapon !");
                    }
                } else {
                    System.out.println("You won heavy armour! ");
                    if (getPlayer().getInventory().getWeapon().getItemDamage() > 5) {
                        System.out.println("But you have better weapon! No changes");
                    } else {
                        getPlayer().getInventory().getWeapon().setItemDamage(5);
                        System.out.println("You equipped your weapon !");
                    }
                }
            }

            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You died !");
            return false;
        }
        return true;
    }


    public int randomMaxMonsterNumber() {
        Random random = new Random();
        return random.nextInt(maxMonsterNumber) + 1;
    }

    public boolean fight(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setMonsterHealth(this.getMonster().getMonsterFirstHealth());
            this.getPlayer().printPlayerInfo();
            this.getMonster().printMonsterInfo();
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getMonsterHealth() > 0) {
                int chance = Math.round((float) Math.random());
                System.out.println("Chance : " + chance);
                switch (chance) {
                    case 0:
                        System.out.print("Hit or Run ? : ");
                        String selectedCombat = scan.nextLine().toLowerCase();
                        if (selectedCombat.equals("hit")) {
                            System.out.println("You hit with " + this.getPlayer().getInventory().getWeapon().getItemName());
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                            endOfRound();
                            if (this.getMonster().getMonsterHealth() > 0) {
                                System.out.println(this.getMonster().getMonsterName() + " hit!");
                                int monsterDamage = this.getMonster().getMonsterDamage() - getPlayer().getBlock();
                                if (monsterDamage < 0) {
                                    monsterDamage = 0;
                                }
                                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                                endOfRound();
                            }
                        } else {
                            System.out.println("Screw your ass while running !!");
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - 2);
                            System.out.println("Your health is : " + this.getPlayer().getHealth());
                            return false;
                        }
                        break;
                    case 1:
                        if (this.getMonster().getMonsterHealth() > 0) {
                            System.out.println(this.getMonster().getMonsterName() + " hit!");
                            int monsterDamage = this.getMonster().getMonsterDamage() - getPlayer().getBlock();
                            if (monsterDamage < 0) {
                                monsterDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                            endOfRound();
                        }
                        System.out.print("Hit or Run ? : ");
                        selectedCombat = scan.nextLine().toLowerCase();
                        if (selectedCombat.equals("hit")) {
                            System.out.println("You hit with " + this.getPlayer().getInventory().getWeapon().getItemName());
                            this.getMonster().setMonsterHealth(this.getMonster().getMonsterHealth() - this.getPlayer().getTotalDamage());
                            endOfRound();
                        } else {
                            System.out.println("Screw your ass while running !!");
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - 2);
                            System.out.println("Your health is : " + this.getPlayer().getHealth());
                            return false;
                        }
                        break;
                    default:
                        return true;
                }
            }
            if (this.getMonster().getMonsterHealth() < this.getPlayer().getHealth()) {
                System.out.println("You've defeat the enemy !!");
                System.out.println("#####################");
                System.out.println("You earned " + this.getMonster().getMonsterAwardCoin() + " coins.");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getMonsterAwardCoin());
                System.out.println("You have " + this.getPlayer().getCoin() + " coins.");
                System.out.println("#####################");

            } else {
                return false;
            }
        }
        return true;
    }


    public void endOfRound() {
        System.out.println("Your remaining health : " + this.getPlayer().getHealth());
        System.out.println("=========");
        System.out.println(this.getMonster().getMonsterName() + " remaining health : " + this.getMonster().getMonsterHealth());
        System.out.println();
    }

}

