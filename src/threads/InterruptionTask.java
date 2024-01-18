package threads;

/**
 * Created by KAntipin on 25.03.2016.
 */
public class InterruptionTask implements Runnable{
    Long number = 1L;

    @Override
    public void run() {
        while(true) {
            if (isPrime(number)) {
                System.out.println("The number " + number + " is prime\n");
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("InterruptionTask Thread is exiting on interrupt\n");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(Long number) {
        if (number <=2) {
            return true;
        }
        for (int i=2; i< number; i++) {
            if ((number % i) == 0) return false;
        }
        return true;
    }
}
