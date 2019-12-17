package tasks;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution_1 {
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
        int max = bytes[0];
        for (int i = 1; i != bytes.length; ++i) {
            if (bytes[i] > max)
                max = bytes[i];

        }
        System.out.println(max);
    }
}
