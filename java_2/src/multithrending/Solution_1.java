package multithrending;

import ipodrom.Hippodrome;
import ipodrom.Horses;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution_1 {

    public static void main(String[] args) {

        List<Horses> list = new ArrayList<>();
        list.add(new Horses("Fors"));
        list.add(new Horses("Kaif"));
        list.add(new Horses("Maik"));

        Hippodrome hippodrome = new Hippodrome();
//        Thread thread = new Thread(hippodrome);
//        thread.start();
        hippodrome.Ipodrom(list);
    }

}
