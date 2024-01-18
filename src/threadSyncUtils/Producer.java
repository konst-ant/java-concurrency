package threadSyncUtils;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by kantipin on 16.05.2016.
 */
public class Producer implements Runnable {
    private final Exchanger<List<String>> exchanger;
    private List<String> buffer;

    public Producer(Exchanger exchanger, List<String> buffer) {
        this.exchanger = exchanger;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int cycle=1;
        for (int i=0; i<10; i++) {
            System.out.printf("Producer: filling buffer the %d time\n", cycle);
            for (int j=0; j<10; j++) {
                int idx = i*10 + j;
                String event = "Event" + (i*10 +j);
                System.out.printf("Producer: generated event: %s\n", event);
                buffer.add(event);
            }
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cycle++;
        }
    }
}
