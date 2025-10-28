public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldin!");
        System.out.println("Yapmak istediğiniz işlem: ");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Çıkış");


        int selectCase = input.nextInt();

        if ((selectCase < 1) && (selectCase>3)) {
            System.out.print("Lütfen geçerli bir değer giriniz: ");
            selectCase = input.nextInt();
        }else if(selectCase == 1) {
            printWeapon();
            buyWeapon();
        }else if(selectCase == 2) {
            printArmor();
            buyArmor();
        }else if(selectCase == 3) {
            System.out.println("İyi günler !");
        }

        return true;

    }

    public  void printWeapon() {
        System.out.println("****Silahlar****");
        System.out.println();
        for (Weapon  w : Weapon.weapons()) {
            System.out.println(w.getId() + " * " + w.getName() + "  <Para: " + w.getPrice()+ ">" + " ,  <Hasar: " + w.getDamage() + ">");
        }



    }

    public void buyWeapon() {
        System.out.print("Silah seçiniz: ");
        int selectWeaponId = input.nextInt();
        if ((selectWeaponId< 1) && (selectWeaponId>Weapon.weapons().length)) {
            System.out.print("Lütfen geçerli bir değer giriniz: ");
            selectWeaponId = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponId);
        if ( selectedWeapon!= null) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Bakiye yetersiz! ");
            }else {
                System.out.println(selectedWeapon.getName() + "Silahını satın aldınız. ");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Bakiye: " + this.getPlayer().getMoney());
                System.out.println("Bir önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                System.out.println("Yeni silahınız: ");
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        }
    }



    public void printArmor() {
        System.out.println("****Zırhlar****");
        System.out.println();
        for (Armor  a : Armor.armors()) {
            System.out.println(a.getId() + " * " + a.getName() + "  <Para: " + a.getPrice()+ ">" + " ,  <Engelleme: " + a.getBlock() + ">");
        }
    }


    public void buyArmor(){
        System.out.print("Zırh seçiniz: ");
        int selectArmorId = input.nextInt();
        if ((selectArmorId< 1) && (selectArmorId>Armor.armors().length)) {
            System.out.print("Lütfen geçerli bir değer giriniz: ");
            selectArmorId = input.nextInt();
        }
        Armor selectedArmor = Armor.getArmorObjByID(selectArmorId);
        if ( selectedArmor!= null) {
            if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                System.out.println("Bakiye yetersiz! ");
            }else {
                System.out.println(selectedArmor.getName() + "Silahını satın aldınız. ");
                int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Bakiye: " + this.getPlayer().getMoney());
                System.out.println("Bir önceki silahınız: " + this.getPlayer().getInventory().getArmor().getName());
                System.out.println("Yeni silahınız: ");
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        }

    }

}
