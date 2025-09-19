import java.util.ArrayList;
import java.util.List;

public class Threads {

    public static void main(String[] args) throws InterruptedException {

        MyRunnable runnable = new MyRunnable();
        int n = 3;
        List<Thread> threads = new ArrayList<>();

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
        /*
         * Evitar usar, temos outros modos de fazer isso a seguir...
        */

        //Synchronized com collections...

        for(int i =  0; i < n; i++) {
            Thread t = new Thread(runnable);
            threads.add(t);
            t.start();
        }

        for(Thread t : threads) {
            t.join();
        }

//        for(String item : runnable.getMyList()) {
//            System.out.println(item);
//        }

        // Classes atomicas

    }
}