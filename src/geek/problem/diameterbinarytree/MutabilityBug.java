package geek.problem.diameterbinarytree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class MutabilityBug {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(15, 1);
        map.put(16, 1);
        map.put(3, 1);
        map.forEach((k, v) -> System.out.println(k));

        new LinkedList<Integer>().stream().distinct();
    }
}

class A {
    A(final List<String> names) {
        this.names = new ArrayList(names);
    }

    private final List<String> names;

    public List<String> getNames() {
        return new ArrayList(names);
    }
}

class B extends A {
    B(final List<String> names) {
        super(names);
    }
}