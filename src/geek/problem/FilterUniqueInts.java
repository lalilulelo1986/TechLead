package geek.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class FilterUniqueInts {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);

        Collections.sort(list);

        Integer prev = null;
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(prev))
                iterator.remove();
            prev = next;
        }

        System.out.println(list);
    }
}
