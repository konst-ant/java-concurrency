package tmp;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Incrementer implements Runnable {

    AtomicIntegerArray arr;

    public Incrementer(AtomicIntegerArray arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length(); i++) {
            // just a hack to check consistency :)))
            //if (i%2 != 0)
            arr.getAndIncrement(i);
        }
    }
}
