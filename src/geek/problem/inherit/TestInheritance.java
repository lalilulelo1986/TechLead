package geek.problem.inherit;

public class TestInheritance {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.s);
    }
}

class A {
    protected String s = "A";
}

class B extends A {

}