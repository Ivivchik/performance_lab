package tasks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution_6 {
    public static void main(String[] args) throws IOException {
        FileInputStream filename = new FileInputStream(args[1]);
        FileOutputStream fileOutputName = new FileOutputStream(args[2]);
        if (args.length != 0 && args[0].equals("-e")) {
            byte b;
            while (true) {
                b = (byte) filename.read();
                if (b == -1)
                    break;
                fileOutputName.write(b - 1);
            }
        } else if (args.length != 0 && args[0].equals("-d")) {
            byte b;
            while (true) {
                b = (byte) filename.read();
                if (b == -1)
                    break;
                fileOutputName.write(b + 1);
            }
        }
    }
}

