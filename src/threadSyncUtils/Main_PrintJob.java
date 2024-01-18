package threadSyncUtils;

/**
 * Created by kantipin on 21.04.2016.
 */
public class Main_PrintJob {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();

        for(int i=0; i< 5; i++) {
            PrintJob job = new PrintJob(queue, i);
            Thread jobThread = new Thread(job);
            jobThread.start();
        }
    }
}
