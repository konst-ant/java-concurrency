package threadSynchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kantipin on 12.04.2016.
 */
public class PrintQueue {
    private Lock queueLock;

    public PrintQueue () {
        // fair version
        // Note: tryLock() is not affected by fair attribute, so if using lock() the threads will be activating in order of max waiting time, and if tryLock() no order is guaranteed
        queueLock = new ReentrantLock();
        //queueLock = new ReentrantLock(true);
    }


    /*
     * @param document fictitious document which would be printed
     */
    public void printJob(Object document) {
        // check double locking - note it should be double unlock() !!! otherwise the resource is locked forever
        queueLock.lock();
        queueLock.lock();
        // alternatively - implement locking with tryLock()
        /*boolean lockSuccess = false;
        do {
             lockSuccess = queueLock.tryLock();
        } while (!lockSuccess);*/

        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("PrintQueue: thread %s executing printing job of %d second(s)\n", Thread.currentThread()
                    .getName(), (int) (duration / 1000));
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
            queueLock.unlock();
        }

        // fair version - two times lock
        queueLock.lock();
        try {
            long duration = (long) (Math.random() * 10000);
            System.out.printf("PrintQueue: thread %s executing (another) printing job of %d second(s)\n", Thread.currentThread()
                    .getName(), (int) (duration / 1000));
            Thread.sleep(duration);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }

}
