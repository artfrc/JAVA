public class MyRunnable implements Runnable {
    private  int count;

    public MyRunnable() {
        this.count = -1;
    }

    @Override
    public synchronized void run() {
        String name = Thread.currentThread().getName();
        for(int i = 0; i < 2; i++) {
            count++;
            System.out.println(name + ": " + count);
        }

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}