import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Runnable {
    private AtomicInteger count =  new AtomicInteger(-1);

    public MyRunnable(){}

    @Override
    public void run() {

        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + this.count.incrementAndGet());

    }

    public AtomicInteger getCount() {
        return count;
    }
}