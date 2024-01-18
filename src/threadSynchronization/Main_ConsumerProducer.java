package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Main_ConsumerProducer {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Consumer consumer = new Consumer(storage);
        Producer producer = new Producer(storage);

        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);

        consumerThread.start();
        producerThread.start();


    }
}
