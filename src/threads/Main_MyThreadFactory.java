package threads;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Main_MyThreadFactory {
    public static void main(String[] args) {
        ThreadSleepTask task = new ThreadSleepTask(1);
        MyThreadFactory factory = new MyThreadFactory("CustomFactory");
        Thread t;
        for (int i = 0; i < 10; i++) {
            t = factory.newThread(task);
            t.start();
        }
        System.out.printf("Thread factory threads number: %d", factory.getCount());
        System.out.println("Thread factory statistics:");
        System.out.println(factory.getStatistics());
    }
}
