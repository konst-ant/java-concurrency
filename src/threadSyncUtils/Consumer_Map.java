package threadSyncUtils;

import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * Created by kantipin on 16.05.2016.
 */
public class Consumer_Map implements Runnable{
    Exchanger<Map<Integer, String>> exchanger;
    Map<Integer, String> buffer;

    public Consumer_Map(Exchanger exchanger, Map<Integer, String> buffer) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int cycle=1;
        for (int i=0; i<10; i++) {
            // get buffer from producer
            System.out.printf("Consumer: consuming buffer the %d time\n", cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // empty-up the buffer received
            for (int j=0; j<10; j++) {
                int idx = i*10 + j;
                String event = buffer.get(idx);
                System.out.printf("Consumer: received event: %s\n", event);

                // Note: for Map removal is optional, it won't prevent further buffer filling, yet will save memory
                // If we had a list, we would rather be mandatory to clean up the buffer
                buffer.remove(idx);
            }
            cycle++;
        }
    }
}
