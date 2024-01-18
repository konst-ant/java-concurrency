package threads;

/**
 * Created by KAntipin on 07.04.2016.
 */
public class Main_UncaughtExceptionThread {
    public static void main(String[] args) {
        Thread task = new Thread(new UncaughtExceptionTask());
        task.setUncaughtExceptionHandler(new ExceptionHandler());
        task.start();
    }
}
