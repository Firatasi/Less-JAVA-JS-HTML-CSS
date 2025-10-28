import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int row, col;

        System.out.print("Mayın tarlası oyununa hoş geldiniz! \nOyunun büyüklüğünü giriniz.\n");

        System.out.print("1-Satır sayısı giriniz: ");
        row = input.nextInt();

        System.out.print("2-Kolon sayısı giriniz: ");
        col = input.nextInt();

        Mayin mayin = new Mayin(row,col);
        mayin.run();

    }



}