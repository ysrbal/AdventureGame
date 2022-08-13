public class Store extends Location {

    public Store(Player player) {
        super(player, "2", "Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("----- STORE -----");
        System.out.println("Welcome to the store. You can buy different types items here.");
        System.out.println("What do you want to buy? : ");
        System.out.println("-----ITEMS-----");
        System.out.println("1- Weapon" + "\n2- Armor" + "\n3-Exit");
        System.out.print("Your choose : ");
        int selectCase = scan.nextInt();
        while (selectCase < 1 || selectCase > 3) {
            System.out.println("Incorrect entry. Please try again.");
            selectCase = scan.nextInt();
        }
        switch (selectCase) {
            case 1:
                printWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("The force may be with you !!");
                return true;
        }

        return true;
    }


    public void printWeapon() {
        System.out.println("----- WEAPONS -----");
        for (Weapon wp : Weapon.weapons()) {
            System.out.println("ID : " + wp.getItemID() +
                    "\tName : " + wp.getItemName() +
                    "\tDamage : " + wp.getItemDamage() +
                    "\tPrice : " + wp.getItemPrice());
        }
        System.out.print("Please choose one : ");
        int selectWeapon = scan.nextInt();
        while (selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Incorrect entry. Please try again.");
            selectWeapon = scan.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponID(selectWeapon);
        if (selectedWeapon != null) {
            if (selectedWeapon.getItemPrice() > this.getPlayer().getCoin()) {
                System.out.println("There is not enough money!");
            } else {
                this.getPlayer().setDamage((this.getPlayer().getDamage() + selectedWeapon.getItemDamage()));
                System.out.println("You have a nice " + selectedWeapon.getItemName());
                System.out.println("You are stronger now!");
                System.out.println("Your damage : " + this.getPlayer().getDamage());
                System.out.println("---------------------");
                int balance = this.getPlayer().getCoin() - selectedWeapon.getItemPrice();
                this.getPlayer().setCoin(balance);
                System.out.println("Your have " + this.getPlayer().getCoin() + " coins left.");

            }
        }

    }

    public void printArmor() {
        System.out.println("-----ARMORS-----");
        for (Armor ar : Armor.armors()) {
            System.out.println("ID : " + ar.getItemID() +
                    "\tName : " + ar.getItemName() +
                    "\tBlock : " + ar.getItemBlock() +
                    "\tPrice : " + ar.getItemPrice());
        }
        System.out.print("Please choose one : ");
        int selectArmor = scan.nextInt();
        while (selectArmor < 1 || selectArmor > Armor.armors().length) {
            System.out.println("Incorrect entry. Please try again.");
            selectArmor = scan.nextInt();
        }
        Armor selectedArmor = Armor.getArmorID(selectArmor);
        if (selectedArmor != null) {
            if (selectedArmor.getItemPrice() > this.getPlayer().getCoin()) {
                System.out.println("There is not enough money!");
            } else {
                System.out.println("You have a nice " + selectedArmor.getItemName());
                int balance = this.getPlayer().getCoin() - selectedArmor.getItemPrice();
                this.getPlayer().setCoin(balance);
                System.out.println("You have " + this.getPlayer().getCoin() + " coins left.");
            }
        }

    }

}

