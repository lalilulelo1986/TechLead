package geek.problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Iterator1 {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList();
        names.add("HOOOO");
        names.add("Max1");
        names.add("Max2");
        names.add("Max3");

        ListIterator<String> iterator = names.listIterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if (next.equals("HOOOO")) {
                iterator.add("HOOOO");
            }
        }

        System.out.println(names);
    }
}
