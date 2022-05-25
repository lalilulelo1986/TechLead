package geek.problem.diameterbinarytree;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LazyLoader {

    static {
        System.out.println("LazyLoader static initializer");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream().map((k) -> k * 2).collect(Collectors.toList());
        Integer get = integers.stream().map((k) -> k * 2).reduce(Integer::sum).orElse(0);
        System.out.println("eq: " + (integers == collect));
        System.out.println(integers);
        System.out.println(collect);

        System.out.println(Loader.INSTANCE);
//        Loader.foo();
        System.out.println(Foo.data);
    }

    private static class Loader {
        static {
            System.out.println("Loader loaded");
        }

        public static final String INSTANCE = "INSTANCE";

        static void foo() {
            System.out.println("calling foo");
        }
    }
}

class Foo {
    static {
        System.out.println("Foo init");
    }

    public static final String data = "data";
}

interface MyInt {
    static String s = "";
}

abstract class MyAbsClass {
    MyAbsClass() {
        new AtomicInteger().incrementAndGet();
    }
}