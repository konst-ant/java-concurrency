package threads;

/**
 * Created by KAntipin on 02.03.2016.
 */
public class Main_Calculator {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
