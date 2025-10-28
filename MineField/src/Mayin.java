import java.util.Random;
import java.util.Scanner;

public class Mayin {
    int colNum, rowNum, size;
    int[][] map;
    int[][] board;
    boolean game = true;

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

     Mayin(int rowNum, int colNum) {
         this.rowNum = rowNum;
         this.colNum = colNum;
         this.map = new int[rowNum][colNum];
         this.board = new int[rowNum][colNum];
         this.size = rowNum*colNum;

     }

     public void run() {
         int row, col, succ = 0;
        prepareGame();
        //print(map);
        System.out.println("Oyun başladı! ");
        while(game) {
            print(board);
            System.out.print("Satır: ");
            row = input.nextInt();
            System.out.print("Sütun: ");
            col = input.nextInt();

            /*if (row >= 0 || row <= rowNum - 1) {
                System.out.println("Geçersiz koordinat");
                continue;
            }
            if (col >= 0 || row <= colNum - 1) {
                System.out.println("Geçersiz koordinat");
                continue;
            }*/

            if (map[row][col] != -1) {
                checkBomb(row, col);
                succ++;
                if (succ == (size - (size/4))) {
                    System.out.println("Kazandınız! ");
                }
            }else {
                game = false;
                System.out.println("Oyun bitti! ");
            }
        }
     }

     public void checkBomb(int r, int c) {
         if (board[r][c] == 0) {
             if ((c < colNum - 1) && (map[r][c+1] == -1)) {
                 board[r][c]++;
             }
             if ((r < rowNum - 3) && (map[r+1][c] == -1)) {
                 board[r][c]++;
             }
             if ((c > 0) && (map[r][c-1] == -1)) {
                 board[r][c]++;
             }
             if ((r > 0) && (map[r-1][c] == -1)) {
                 board[r][c]++;
             }
             if (board[r][c] == 0) {
                 board[r][c] = -2;
             }
         }

     }

     public void prepareGame() {
         int randRow, randCol, count = 0;

             while (count != (size / 4)) {
                 randRow = rand.nextInt(rowNum);
                 randCol = rand.nextInt(colNum);

                 if (map[randRow][randCol] != -1) {
                     map[randRow][randCol] = -1;
                     count++;
                 }
             }

     }

     public void print(int[][] arry) {

        for (int i = 0; i < arry.length; i++) {
            for (int j = 0; j < arry[0].length; j++) {
                if (arry[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arry[i][j] + " ");
            }
            System.out.println();
        }

     }

}
