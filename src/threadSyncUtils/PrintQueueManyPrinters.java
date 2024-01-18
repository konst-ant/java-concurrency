package threadSyncUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kantipin on 21.04.2016.
 */
public class PrintQueueManyPrinters extends PrintQueue{
    Lock    lockPrinters;
    boolean[] printers;

    public PrintQueueManyPrinters() {
        semaphore = new Semaphore(3);
        lockPrinters = new ReentrantLock();
        printers = new boolean[3];
        for (int i = 0; i < 3; i++) {
            printers[i] = true;
        }
    }

    @Override
    public void printJob(Object document, int number) {
        int seconds = (int)(Math.random()*10);

        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();
            System.out.printf("PrintQueue: printing job number %d on printer %d (%d seconds)\n", number,
                    assignedPrinter, seconds);
            TimeUnit.SECONDS.sleep(seconds);
            releasePrinter(assignedPrinter);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }

    }

    public int getPrinter() {
        int assign=-1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < 3; i++) {
                if (printers[i]) {
                    assign = i;
                    printers[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return assign;
    }

    public void releasePrinter(int number) {
        try {
            lockPrinters.lock();
            printers[number] = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
    }
}
