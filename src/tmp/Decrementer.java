package tmp;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Decrementer implements Runnable {
    AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }
}
