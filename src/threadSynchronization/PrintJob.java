package threadSynchronization;

/**
 * Created by kantipin on 12.04.2016.
 */
public class PrintJob implements Runnable {
    PrintQueue queue;

    public PrintJob(PrintQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.printJob(new Object());
        System.out.println("Printed document");
    }
}
