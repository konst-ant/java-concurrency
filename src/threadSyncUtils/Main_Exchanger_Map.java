package threadSyncUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;

/**
 * Created by kantipin on 16.05.2016.
 */
public class Main_Exchanger_Map {
    public static void main(String[] args) {
        Exchanger<Map<Integer, String>> exchanger = new Exchanger<>();
        Map<Integer, String> buffer1 = new HashMap<>();
        Map<Integer, String> buffer2 = new HashMap<>();

        Producer_Map producer = new Producer_Map(exchanger, buffer1);
        Consumer_Map consumer = new Consumer_Map(exchanger, buffer2);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}
