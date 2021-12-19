package geek.problem.diameterbinarytree;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Pecs2 {
    List<? extends Number> list;
    List<? super Number> list2;
    void first() {
        Number number = list.get(0);
//        list.add(new Object());
    }

    void second() {
        list2.add(3L);
//        list2.add(new Object());
        Object n = list2.get(0);
    }

    void demo(Source<?> strs) {
        Source<? extends Object> objects = strs; // !!! Not allowed in Java
        // ...
    }

    List<? extends Number> nums = new LinkedList<Long>();

    void demo2(Source<?> strs) {
        Function<Integer, Integer> f;
    }
}