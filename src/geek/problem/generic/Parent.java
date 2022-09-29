package geek.problem.generic;

import java.util.List;

public class Parent {
    public static void main(String[] args) {
        dodo(List.of(new Child()));
    }

    public static void dodo(List<? extends Parent> parents) {
        System.out.println(parents);
        "".hashCode();
    }
}

class Child extends Parent {

}
