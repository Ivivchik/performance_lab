package Solution;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число a: ");
        int a = scanner.nextInt();
        System.out.print("Введите число b: ");
        int b = scanner.nextInt();
        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        System.out.println("НОД a и b: " + a);
    }
}
