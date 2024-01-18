package threads;

import java.util.Date;
import java.util.Deque;

/**
 * Created by KAntipin on 06.04.2016.
 */
public class DaemonThread_Cleaner extends Thread{
    private Deque d;
    public DaemonThread_Cleaner(Deque d) {
        this.d = d;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        String myName = Thread.currentThread().getName();

        if (d.isEmpty()) {
            return;
        }

        boolean delete = false;
        long difference = 0;
        do {
            Event e = (Event) d.getLast();
            difference = date.getTime() - e.getDate().getTime();
            if (difference > 10000) {
                System.out.println("Cleaner: cleaning event" + e.getEvent());
                d.removeLast();
                delete=true;
            }
        } while (difference > 10000);
        if (delete) {
            System.out.println("Cleaner: current queue size: " + d.size());
        }
    }
}
