package geek.problem.generic.bound;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AddToList {
    public static void main(String[] args) {
        ArrayList<Object> strings = new ArrayList<>(Arrays.asList(new Object()));
        ArrayList<String> strings1 = new ArrayList<>(Arrays.asList("6500", "7600", "8700"));
        copyAll(strings, strings1);
    }

    static void copyAll(List<Object> to, List<String> from) {
        to.addAll(from);
    }

    void dodo(List<? extends Number> list, List<? extends Number> list2) {
        List<? super Number> lowerBounded = new ArrayList<Number>();
        lowerBounded.add(0);
        lowerBounded.add(0.0);
        Object object = lowerBounded.get(1);

        new ArrayList<Integer>(Arrays.asList(1));
//        list.addAll(new ArrayList<Integer>(Arrays.asList(1)));
        Number number = list.get(0);
        System.out.println(number);
    }

    void demo(Source<String> strs) {
        Source<? extends Object> objects = strs;
        objects.nextT();
//        objects.add(new Object());
        // ...
    }
}

interface Source<T> {
    T nextT();
    void add(T t);
}
