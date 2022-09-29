package geek.problem;

import java.util.Arrays;

public class Closure {
    public static void main(String[] args) {
        int i = 0;
        Arrays.asList(1, 2, 3, 4).stream().peek(it -> {
//            i++;
            return;
        }).forEach((it) -> {
            System.out.println(it);
            return;
        });
        System.out.println("HELLO " + i);
    }
}
