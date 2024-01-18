package threads;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by KAntipin on 06.04.2016.
 */
public class Main_DaemonThread {
    public static void main(String[] args) {
        Deque d = new ArrayDeque<>();

        for (int i = 0; i < 3; i++) {
            Thread writer = new Thread(new DaemonThread_Writer(d));
            writer.start();
        }
        Thread cleaner = new DaemonThread_Cleaner(d);
        cleaner.start();
    }
}
