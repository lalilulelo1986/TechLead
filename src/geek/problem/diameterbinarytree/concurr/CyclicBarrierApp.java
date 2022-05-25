package geek.problem.diameterbinarytree.concurr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApp {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("MERGING"));
        Runnable barrierAction = () -> {
            System.out.println("doing work...");
            try {
                Thread.sleep(3000);
                System.out.println(barrier.await());
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        List<Thread> threads = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(barrierAction);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads)
            thread.join();
    }
}
