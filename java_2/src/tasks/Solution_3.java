package tasks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3 {

    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        str = reader.readLine();
        byte[] bytes = new byte[256];

        FileInputStream f = new FileInputStream(str);
        byte b;
        while (true) {
            b = (byte) f.read();
            if (b == -1)
                break;
            bytes[b]++;
        }
        int maxValue = bytes[0];
        for (int i = 0; i < bytes.length; i++) {
            int tmpData = (int) bytes[i];
            if (tmpData > maxValue)
                maxValue = tmpData;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == maxValue) {
                System.out.print(i);
                System.out.print(" ");
            }
        }

        f.close();
        System.in.close();
        System.out.close();
    }
}
