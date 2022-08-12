public class Store extends Location {
    public Store(Player player) {
        super(player, "2", "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- STORE -----");
        System.out.println("Welcome to the store." +"\nYou can buy different types items here.");
        return true;
    }

    public void buy() {
        System.out.println("What do you want to buy? : ");
        System.out.println("What kind items do you need ? :");
    }
}
