package geek.problem.clazz;

public class ParrentClass {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello");
        printParents(String.class);
        printParents(Integer.class);
        printParents(MyClass.class);

//        if (MyClass.class instanceof MyInt)
//            System.out.println("yes");

        if (Long.class instanceof Object)
            System.out.println("yes");

//        Class.forName("geek.problem.diameterbinarytree.clazz.MyClass");

        Integer num = 1;
        if (num instanceof Number) {
            System.out.println("An integer is a number!");
        }
    }

    private static void printParents(Class<?> clazz) {

        while (clazz != null) {
            System.out.print(clazz.getName());

            if (clazz.getSuperclass() != null) {
                System.out.print(" > ");
            }
            clazz = clazz.getSuperclass();
        }
        System.out.println();
    }
}

interface MyInt {
}

class MyClass implements MyInt {
    static {
        System.out.println("MyClass static initialisation");
    }
}