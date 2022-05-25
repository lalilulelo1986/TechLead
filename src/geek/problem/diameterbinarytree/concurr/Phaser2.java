package geek.problem.diameterbinarytree.concurr;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class Phaser2 {
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        Phaser ph = new Phaser(1);
//
//        System.out.println("Phase: " + ph.getPhase());
//        assert (0 == ph.getPhase());
//        executorService.submit(new LongRunningAction("thread-1", ph));
//        executorService.submit(new LongRunningAction("thread-2", ph));
//        executorService.submit(new LongRunningAction("thread-3", ph));
//        Thread.sleep(3000);
//        ph.arriveAndAwaitAdvance();
//
//        System.out.println("Phase: " + ph.getPhase());
//        assert (1 == ph.getPhase());
//        executorService.submit(new LongRunningAction("thread-4", ph));
//        executorService.submit(new LongRunningAction("thread-5", ph));
//        ph.arriveAndAwaitAdvance();
//
//        System.out.println("Phase: " + ph.getPhase());
//        assert (2 == ph.getPhase());
//        executorService.submit(new LongRunningAction("thread-6", ph));
//        executorService.submit(new LongRunningAction("thread-7", ph));
//        executorService.submit(new LongRunningAction("thread-8", ph));
//        ph.arriveAndAwaitAdvance();
//
//        ph.arriveAndDeregister();
//        executorService.shutdown();
    }
}

class LongRunningAction implements Runnable {
    private final String threadName;
    private Phaser ph;

    LongRunningAction(String threadName, Phaser ph) {
        this.threadName = threadName;
        this.ph = ph;
        ph.register();
    }

    @Override
    public void run() {
        System.out.println("Before arriveAndAwaitAdvance: " + threadName);
        ph.arriveAndAwaitAdvance();
        try {
            System.out.println("Running start: " + threadName);
            Thread.sleep(2000);
//            System.out.println("Running end: " + Thread.currentThread());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndDeregister();
    }

    static void runTasks(List<Runnable> tasks) throws InterruptedException {
        final Phaser phaser = new Phaser(1); // "1" to register self
        // create and start threads
        for (final Runnable task : tasks) {
            phaser.register();
            new Thread(() -> {
                phaser.arriveAndAwaitAdvance(); // await all creation
                task.run();
            }).start();
        }
        Thread.sleep(2000);
        // allow threads to start and deregister self
        phaser.arriveAndDeregister();
    }

    public static void main(String[] args) throws InterruptedException {
        runTasks(Arrays.asList(
                () -> System.out.println("HELLO THREAD: " + Thread.currentThread().getName()),
                () -> System.out.println("HELLO THREAD 2: " + Thread.currentThread().getName())
        ));
    }
}