public class Armor extends Item {


    public Armor(int itemID, String itemName, int itemDamage, int itemBlock, int itemPrice) {
        super(itemID, itemName, itemDamage, itemBlock, itemPrice);
    }

    public static Armor[] armors() {
        Armor[] armorList = new Armor[3];
        armorList[0] = new Armor(1, "Light Armor", 0, 1, 15);
        armorList[1] = new Armor(2, "Medium Armor", 0, 3, 25);
        armorList[2] = new Armor(3, "Heavy Armor", 0, 5, 40);

        return armorList;
    }

    public static Armor getArmorID(int id) {
        for (Armor ar : Armor.armors()) {
            if (ar.getItemID() == id) {
                return ar;
            }
        }
        return null;
    }
}
