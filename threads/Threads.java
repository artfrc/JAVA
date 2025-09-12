import java.util.ArrayList;
import java.util.List;

public class Threads {

    public static void main(String[] args) throws InterruptedException {

        // atual
//        Thread t = Thread.currentThread();
//        System.out.println(t.getName());

        //nova
//        Thread t1 = new Thread(new MyRunnable());
//        t1.start();

        //com lambda
//        Thread t2 = new Thread( () -> System.out.println("teste"));
//        t2.start();

        //Synchronized
        int n = 5, count = -1;
        MyRunnable runnable = new MyRunnable();
        List<Thread> threads = new ArrayList<>();

        for(int i =  0; i < n; i++) {
            Thread t = new Thread(runnable);
            threads.add(t);
            t.start();
        }

        for(Thread t : threads) {
            t.join();
        }

        System.out.println("Valor final: " + runnable.getCount());
        System.out.println("Valor esperado: " + n*2);


    }
}