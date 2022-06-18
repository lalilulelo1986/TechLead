package geek.problem.diameterbinarytree.concurr;

public class UncheckedExHandler {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("handling message: " + t);
            }
        };

        Thread myThread = new Thread(() -> {
            System.out.println("Starting thread");
            int i = 1/0;
        });
        myThread.setUncaughtExceptionHandler(handler);

        myThread.start();

        for (int i = 0; i < 9; i++) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
