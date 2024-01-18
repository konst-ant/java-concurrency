package tmp;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Main_ThreadLocalRandom {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            TaskLocalRandom task = new TaskLocalRandom();
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}
