package Solution;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        int[] array = new int[2];
        array = minValue();
        System.out.println("Минимальное значение: " + array[0] + "\nЕго индекс: " + array[1]);
    }

    public static int[] minValue() {
        int size = 0;
        int[] massiv = new int[2];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        size = scanner.nextInt();
        int[] array = new int[size];
        System.out.print("Введите элементы массива:");
        for (int i = 0; i != size; ++i) {
            array[i] = scanner.nextInt();
        }
        int i = 0;
        int min = array[0];
        for (int j = 1; j != size; ++j) {
            if (min > array[j]) {
                min = array[j];
                i = j;
            }
        }
        massiv[0] = min;
        massiv[1] = i;
        return (massiv);
    }
}
