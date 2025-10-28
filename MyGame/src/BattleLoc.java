import javax.tools.JavaFileManager;
import java.util.Random;

public class BattleLoc extends Location{
    private Monster monster;
    private String award;
    private  int maxMonster;

    BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }
    @Override
    public boolean onLocation(){
        System.out.println("Şuan buradasınız! " +  this.getPlayer());
        System.out.println("Dikkatli ol! Burada" + randomMonsterNumber() + this.getMonster().getName() + "yaşıyor!");
        System.out.println("[F]Savaş veya [E]Çık");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {

        }else if(selectCase.equals("E")) {

        }else {
            System.out.println("Lütfen geçerli bir değer giriniz! ");
        }
        return true;
    }

    public boolean combat(int maxMonster) {
        for (int i = 1; i <= maxMonster; i++) {
            playerStats();
        }



        return false;
    }

    public void playerStats() {
        System.out.println("Karakter Bilgileri: ");
        System.out.println("Sağlık->" + this.getPlayer().getHealth());
        System.out.println("Hasar->" + this.getPlayer().getDamage());
        System.out.println("Para->" + this.getPlayer().getMoney());
    }
    public int randomMonsterNumber() {
        Random rnd = new Random();
        return rnd.nextInt(3) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
