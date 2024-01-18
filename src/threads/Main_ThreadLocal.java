package threads;

import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 08.04.2016.
 */
public class Main_ThreadLocal {
    public static void main(String[] args) {
        //ThreadLocalUnsafe runner = new ThreadLocalUnsafe();
        ThreadLocalSafeTask runner = new ThreadLocalSafeTask();
        for (int i = 0; i < 3; i++) {
            Thread thread= new Thread(runner);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
