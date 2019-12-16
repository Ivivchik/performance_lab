package Solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution5 {

    public static void main(String[] args) throws IOException {
        List<Person> allPeople = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        while (true)
        {
            Person person = new Person();
            String s = reader.readLine();
            if (s.equals("-c"))
            {
                System.out.println("Введите данные человвека : имя, пол, дата рождения");
                String name = reader.readLine();
                String sex = reader.readLine();
                String bd = reader.readLine();
                person = new Person(name, sex, bd);
                allPeople.add(i, person);
            }
            else if (s.equals("-u"))
            {
                System.out.print("Введите id человека :");
                int j = Integer.parseInt(reader.readLine());
                System.out.println("Введите новые данные для человека : имя, пол, дата рождения");
                String name = reader.readLine();
                String sex = reader.readLine();
                String bd = reader.readLine();
                person = allPeople.get(j);
                person.setName(name);
                person.setSex(sex);
                person.setBirthDay(bd);
            }
            else if (s.equals("-d"))
            {
                System.out.print("Введите id человека :");
                int k = Integer.parseInt(reader.readLine());
                allPeople.remove(k);
            }
            else if (s.equals("-i"))
            {
                System.out.println("Введите id человека или команду all");
                String str = reader.readLine();
                if (str.equals("all"))
                {
                    for (Person allPerson : allPeople) {
                        allPeople.toString();
                    }
                }
                else{
                    System.out.println(allPeople.get(Integer.parseInt(str)));
                }
            }
            else
                System.out.println("Wrong command");
            i++;
        }
    }
}
