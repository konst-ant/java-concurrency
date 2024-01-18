package threadSyncUtils;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Exchanger;

/**
 * Created by kantipin on 16.05.2016.
 */
public class Main_Exchanger {
    public static void main(String[] args) {
        Exchanger<List<String>> exchanger = new Exchanger<>();
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        Producer producer = new Producer(exchanger, buffer1);
        Consumer consumer = new Consumer(exchanger, buffer2);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
