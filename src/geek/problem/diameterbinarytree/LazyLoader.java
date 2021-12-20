package geek.problem.diameterbinarytree;

public class LazyLoader {

    static {
        System.out.println("LazyLoader static initializer");
    }

    public static void main(String[] args) throws InterruptedException {
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