import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Hoşgeldiniz! ");
        System.out.print("Lütfen Bir isim Giriniz: ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Hoşgeldiniz! ");
        System.out.println("Oyuna başlamak için bir karakter seçiniz! ");
        player.selectChar();

        while (true) {

            Location location = null;

            System.out.println("Bölgeler");
            System.out.println("1-Güvenli ev");
            System.out.println("2-Mağaza");
            System.out.println("3-Mağra");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;

                default:
                    location = new SafeHouse(player);

            }
            if(!location.onLocation()) {
                System.out.println("Oyun Bitti!");
                break;
            }
        }
    }
}
