package ipodrom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hippodrome implements Runnable{

    public static void Ipodrom(List<Horses> list)
    {
        List<Horses> horses = list;
        int width = 117;
        for (Horses hors : horses) {
                hors.setPosition(Position(hors.getPosition()));
                horseTrack(hors);
                if (hors.getPosition() >= width)
                    System.out.println(hors.getName() + " выйграла");
        }

    }

    public static void horseTrack(Horses horses){
        char[] track = new char[120];
        for (int i = 0; i != 120 ; ++i) {
            track[i] = ' ';
        }
        track[0] = '|';
        track[1] = ':';
        track[118] = ':';
        track[119] = '|';

        track[horses.getPosition()] = '>';
        for (int i = 0; i != 120 ; ++i) {
            System.out.print(track[i]);
        }
        System.out.println();
    }

    public static int Position(int position){
        int step = new Random().nextInt(16);
        step += 2;
        return position + step;
    }

    @Override
    public void run() {

    }
}
