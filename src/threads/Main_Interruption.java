package threads;

/**
 * Created by KAntipin on 25.03.2016.
 */
public class Main_Interruption {
    public static void main(String[] args) {
        Thread task = new Thread(new InterruptionTask());
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.exit(0);
        }

        task.interrupt();
    }

}
