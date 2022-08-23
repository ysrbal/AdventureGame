public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean water;
    private boolean food;
    private boolean wood;

    public Inventory() {
        this.weapon = new Weapon(-1, "Punch", 0, 0, 0);
        this.armor = new Armor(-1,"None",0,0,0);
        this.food = false;
        this.water = false;
        this.wood = false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWood() {
        return wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }
}
