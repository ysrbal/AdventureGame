public class SafeHouse extends Location {

    public SafeHouse(Player player) {
        super(player, 1, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- SAFE HOUSE -----");
        System.out.println("Welcome to the Safe House. There isn't enemy here. You can rest and healthy.");
        this.getPlayer().setHealth(this.getPlayer().getPlayerFirstHealth());
        System.out.println("Your health full now.");
        System.out.println("----------------------");

        return true;
    }
}
