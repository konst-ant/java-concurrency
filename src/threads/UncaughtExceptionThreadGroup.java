package threads;

/**
 * Created by kantipin on 11.04.2016.
 */
public class UncaughtExceptionThreadGroup extends ThreadGroup{

    UncaughtExceptionThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Thread %s thrown exception %s", t.getId(), e.getClass().getName());
        e.printStackTrace();
        System.out.println("UncaughtExcreptionThreadGroup: terminating the rest of the threads");
        interrupt();
    }
}
