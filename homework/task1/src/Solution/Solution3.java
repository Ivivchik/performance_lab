package Solution;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.util.*;

public class Solution3 {

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String str = read.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(str));
        String s = reader.readLine();
        while (s != null)
        {
            list.add(Integer.parseInt(s));
            s = reader.readLine();
        }
        Collections.sort(list);
        for (Integer integer : list) {
            if (integer % 2 == 0)
                System.out.println(integer);
        }
    }

}
