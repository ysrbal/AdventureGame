public abstract class Item {
    private int itemID;
    private String itemName;
    private int itemDamage;
    private int itemPrice;
    private int itemBlock;

    public Item(int itemID, String itemName, int itemDamage, int itemBlock, int itemPrice) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDamage = itemDamage;
        this.itemPrice = itemPrice;
        this.itemBlock = itemBlock;

    }



    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemDamage() {
        return itemDamage;
    }

    public void setItemDamage(int itemDamage) {
        this.itemDamage = itemDamage;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemBlock() {
        return itemBlock;
    }

    public void setItemBlock(int itemBlock) {
        this.itemBlock = itemBlock;
    }


}
