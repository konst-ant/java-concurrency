package threads;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by KAntipin on 29.03.2016.
 */
public class Main_Interruption2 {
    public static void main(String[] args) {
        Thread task = new Thread(new InterruptionTask2(new File("c:\\home\\myprojects"), "Calculator.class"));
        task.start();

        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.interrupt();
    }
}
