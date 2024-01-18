package threadSynchronization;

/**
 * Created by kantipin on 12.04.2016.
 */
public class Main_Print {
    public static void main(String[] args) {
        PrintQueue queue = new PrintQueue();

        for (int i = 0; i < 10; i++) {
            PrintJob job = new PrintJob(queue);
            Thread thread = new Thread(job);
            thread.start();
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
