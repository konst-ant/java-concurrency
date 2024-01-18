package threads;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 06.04.2016.
 */
public class DaemonThread_Writer implements Runnable{
    private Deque d;

    DaemonThread_Writer(Deque d) {
        this.d = d;
    }

    @Override
    public void run() {
        String myName = Thread.currentThread().getName();
        for (int i = 0; i < 20; i++) {
            Event e = new Event("Event " + myName + "#" + i, new Date());
            d.addFirst(e);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                System.out.printf("%s - interrupted", myName);
            }
        }
        System.out.printf("%s - exited\n", myName);
    }
}
