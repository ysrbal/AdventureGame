public class Weapon extends Item {


    public Weapon(int itemID, String itemName, int itemDamage, int itemBlock, int itemPrice) {
        super(itemID, itemName, itemDamage, itemBlock, itemPrice);
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon(1, "Gun", 2, 0, 25);
        weaponList[1] = new Weapon(2, "Sword", 3, 0, 35);
        weaponList[2] = new Weapon(3, "Rifle", 7, 0, 45);
        return weaponList;
    }

    public static Weapon getWeaponID(int id) {

        for (Weapon w : Weapon.weapons()) {
            if (w.getItemID() == id) {
                return w;
            }
        }
        return null;
    }




}
