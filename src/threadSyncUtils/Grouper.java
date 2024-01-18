package threadSyncUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kantipin on 24.04.2016.
 */
public class Grouper implements Runnable{
    Results results;
    int searchNumber;
    CountDownLatch mainBlocker;

    public Grouper(Results results, int searchNumber, CountDownLatch mainBlocker) {
        this.results = results;
        this.mainBlocker = mainBlocker;
    }


    @Override
    public void run() {
        int counter=0;
        int[] data = results.getData();
        for(int i=0; i<data.length; i++) {
                counter+=data[i];
        }
        System.out.printf("Grouper: total occurencces of %d inside matrix is %d\n", searchNumber, counter);
        mainBlocker.countDown();
    }
}
