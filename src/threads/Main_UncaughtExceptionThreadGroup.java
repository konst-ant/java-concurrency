package threads;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Main_UncaughtExceptionThreadGroup {
    public static void main(String[] args) {
        UncaughtExceptionThreadGroupTask task = new UncaughtExceptionThreadGroupTask();
        UncaughtExceptionThreadGroup threadGroup = new UncaughtExceptionThreadGroup("UncaughtException");

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }
    }
}
