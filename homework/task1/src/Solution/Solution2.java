package Solution;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел(строго больше 0): ");
        int n = scanner.nextInt();
        System.out.print("Вводите числа :");
        int max = scanner.nextInt();
        int a = 0;
        for (int i = 1; i != n; ++i) {
            a = scanner.nextInt();
            if (max < a)
                max = a;
        }
        System.out.println("Максимальное равно: " + a);
    }
}
