package geek.problem.diameterbinarytree;

public class StaticVsDynamic {
    public static void main(String[] args) {

        // Пример статического и динамического связывания в Java
        Insurance current = new CarInsurance();

        // Динамическое связывание на основе объекта
        int premium = current.premium();

        // Статическое связывание на основе класса
        String category = current.category();

        Base.foo2();

//        System.out.println("premium : " + premium);
        System.out.println("category : " + category);
        System.out.println("foo2 : " + current.foo2());
        Base.foo2();
    }
}

interface Base {
    //    default String category() {
//        return "Base Insurance";
//    }
    public static String category() {
        return "Insurance";
    }

    int foo();

    static int foo2() {
        return 0;
    }
}

class Insurance implements Base  {
    public static final int LOW = 100;

    public int premium() {
        return LOW;
    }

//    @Override
//    public int foo() {
//        return 0;
//    }

    int foo2() {
        return 1;
    }

//    public static int foo() {
//        return 0;
//    }

    public static String category() {
        return "Insurance";
    }

    @Override
    public int foo() {
        return 0;
    }

}

class CarInsurance extends Insurance {
    public static final int HIGH = 200;

    public int premium() {
        return HIGH;
    }

    public static String category() {
        return "Car Insurance";
    }

}
