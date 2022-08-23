public class Store extends Location {
    public Store(Player player) {
        super(player, 2, "Store");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("What do you want to buy? : ");
            System.out.println("-----ITEMS-----");
            System.out.println("1 - Weapon" + "\n2 - Armor" + "\n3 - Exit");
            System.out.print("Your choose : ");
            int selectCase = scan.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Incorrect entry. Please try again.");
                selectCase = scan.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("The force may be with you !!");
                    showMenu = false;
                    break;

            }
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
        System.out.println("0 : Exit");
    }

    public void buyWeapon() {
        System.out.print("Please choose one : ");
        int selectWeapon = scan.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length) {
            System.out.println("Incorrect entry. Please try again.");
            selectWeapon = scan.nextInt();
        }
        if (selectWeapon != 0) {
            Weapon selectedWeapon = Weapon.getWeaponID(selectWeapon);
            if (selectedWeapon != null) {
                if (selectedWeapon.getItemPrice() > this.getPlayer().getCoin()) {
                    System.out.println("There is not enough money!");
                } else {
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("You have a nice " + selectedWeapon.getItemName());
                    System.out.println("Now, you've increase +" + selectedWeapon.getItemDamage() + " damage!");
                    System.out.println("You are stronger now!");
                    System.out.println("Your damage : " + this.getPlayer().getTotalDamage());
                    System.out.println("---------------------");
                    int balance = this.getPlayer().getCoin() - selectedWeapon.getItemPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("Your have " + this.getPlayer().getCoin() + " coins left.");

                }
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
        System.out.println("0 : Exit");
    }

    public void buyArmor() {
        System.out.print("Please choose one : ");
        int selectArmor = scan.nextInt();
        while (selectArmor < 0 || selectArmor > Armor.armors().length) {
            System.out.println("Incorrect entry. Please try again.");
            selectArmor = scan.nextInt();
        }
        if (selectArmor != 0) {
            Armor selectedArmor = Armor.getArmorID(selectArmor);
            if (selectedArmor != null) {
                if (selectedArmor.getItemPrice() > this.getPlayer().getCoin()) {
                    System.out.println("There is not enough money!");
                } else {
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("You have a nice " + selectedArmor.getItemName());
                    System.out.println("Now, you've increase +" + selectedArmor.getItemBlock() + " block!");
                    System.out.println("You are stronger now!");
                    System.out.println("Your block : " + this.getPlayer().getBlock());
                    System.out.println("---------------------");
                    int balance = this.getPlayer().getCoin() - selectedArmor.getItemPrice();
                    this.getPlayer().setCoin(balance);
                    System.out.println("You have " + this.getPlayer().getCoin() + " coins left.");
                }
            }
        }
    }
}
