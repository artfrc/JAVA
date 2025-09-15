import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyRunnable implements Runnable {
    private List<String> myList = new ArrayList<>();

    public MyRunnable() {
        this.myList = Collections.synchronizedList(this.myList);
    }

    @Override
    public void run() {

        int n = 1;

        for(int i = 0; i < n; i++) {
            String name = Thread.currentThread().getName();
            myList.add("Hello World! " + name);
        }

    }

    public List<String> getMyList() {
        return myList;
    }
}