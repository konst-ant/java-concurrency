package threadExecutors;

/**
 * Created by kantipin on 20.05.2016.
 */
public class Task6 implements Runnable {

    private String name;

    public Task6(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        System.out.printf("Task %s started and going to execute %d seconds\n", name, duration);
        try {
            Thread.currentThread().sleep(1000 * duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task %s completed\n", name);
    }

    @Override
    public String toString() {
        return name;
    }
}
