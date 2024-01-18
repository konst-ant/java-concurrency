package threadSyncUtils;

/**
 * Created by kantipin on 21.04.2016.
 */
public class PrintJob implements Runnable{
    PrintQueue q;
    int printNumber;

    public PrintJob(PrintQueue q, int printNumber) {
        this.q = q;
        this.printNumber = printNumber;
    }


    @Override
    public void run() {
        q.printJob(new Object(), printNumber);
        System.out.printf("Thread %s : printed document number %d\n", Thread.currentThread().getName(), printNumber);
    }
}
