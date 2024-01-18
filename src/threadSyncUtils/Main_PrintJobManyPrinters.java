package threadSyncUtils;

/**
 * Created by kantipin on 21.04.2016.
 */
public class Main_PrintJobManyPrinters {

    public static void main(String[] args) {
        PrintQueue queue = new PrintQueueManyPrinters();
        for (int i = 0; i < 5; i++) {
            Thread task = new Thread(new PrintJob(queue, i));
            task.start();
        }
    }
}
