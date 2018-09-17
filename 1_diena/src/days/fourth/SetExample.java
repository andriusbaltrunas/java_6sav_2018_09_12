package days.fourth;

import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args){
        Set<String> names = new TreeSet<>();

        names.add("Jonas");
        names.add("Andrius");
        names.add("Antanas");
        names.add("Jonas");
        names.add("Petras");

        names.forEach(System.out :: println);
    }
}
