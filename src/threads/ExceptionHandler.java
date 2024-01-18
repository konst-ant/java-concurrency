package threads;



/**
 * Created by KAntipin on 07.04.2016.
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Exception %s in thread %s\n", e.getClass().getName(), t.getName());
        //e.printStackTrace();
        System.out.println("Thread state: " + t.getState());
    }
}
