package threadSyncUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kantipin on 21.04.2016.
 */
public class VideoConference implements Runnable{
    private final CountDownLatch controller;

    public VideoConference(int number) {
        controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        // Note: this code executed by participant' threads, although it is inside VideoConference Runnable class
        System.out.printf("New participant has arrived: %s\n", name);
        controller.countDown();
        System.out.printf("Wwaiting for remaining %d participants\n", controller
                .getCount());
    }

    @Override
    public void run() {
        System.out.printf("%s: Starting video-conference with %d participants. Waiting for all to join.\n", Thread
                .currentThread().getName(), controller
                .getCount());
        try {
            controller.await();
        } catch (InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.printf("%s: All participants present. Starting ...\n", Thread.currentThread().getName());
    }
}
