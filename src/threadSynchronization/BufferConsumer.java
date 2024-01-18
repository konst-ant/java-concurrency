package threadSynchronization;

import java.util.Random;

/**
 * Created by kantipin on 19.04.2016.
 */
public class BufferConsumer implements Runnable {
    Buffer buffer;

    public BufferConsumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    public void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
