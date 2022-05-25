package geek.problem.diameterbinarytree;

interface Dymond {
    static void foo() {
        System.out.println("static foo");
    }
}

abstract class AbstactA {
    void foo() {
        System.out.println("No static foo");
    }
}

class Child extends AbstactA implements Dymond {
    public static void main(String[] args) {
        new Child().foo();
        Dymond.foo();
        new Dymond1().foo2();
    }
}

interface A1 {
    default void foo2() {
        System.out.println("Def A");
    }
}

interface B1 {
    default void foo2() {
        System.out.println("Def A");
    }
}

class Dymond1 implements A1, B1 {

    @Override
    public void foo2() {
        B1.super.foo2();
    }
}