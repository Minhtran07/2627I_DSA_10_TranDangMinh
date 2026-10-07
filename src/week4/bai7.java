package week4;

import java.util.Scanner;

public class bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] count = new int[100];

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            count[num]++;
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(count[i]);
            if (i < 99) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}