package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class SafePrint {
    public synchronized static void print(String s) {
        System.out.println(s);
    }
}
