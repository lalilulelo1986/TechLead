package geek.problem.concurr;

import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

public class SyncFlash {
}

class cls1 {
    int x=10;
}

class cls2{
    int y=10;
}

class cls3{
    cls1 obj1;
    cls2 obj2;
    int val = 0;
    public void method2(){
        val = 10;
        synchronized(this){
//            System.out.println("before");
            val = 20;
//            System.out.println("done");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final cls3 obj3 = new cls3();

        Thread thread1 = new Thread(){
            public void run(){
                obj3.method2();
            }
        };
        thread1.start();
        Thread thread2 = new Thread(){
            public void run(){
                System.out.println(obj3.val);
            }
        };
        thread2.start();
        thread2.join();
        thread1.join();

        new WeakHashMap<Long, Lock>();
    }
}