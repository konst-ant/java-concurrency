package threadSynchronization;

/**
 * Created by kantipin on 13.04.2016.
 */
public class Main_PriceInfo {
    public static void main(String[] args) {
        PriceInfo info = new PriceInfo();
        Thread[] readThreads = new Thread[5];
        Thread writeThread;

        for (int i = 0; i < 5; i++) {
            readThreads[i] = new Thread(new PriceReader(info));
        }
        writeThread = new Thread(new PriceWriter(info));

        for (int i = 0; i < 5; i++) {
            readThreads[i].start();
        }
        writeThread.start();
    }
}
