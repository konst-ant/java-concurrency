package threadExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 18.05.2016.
 */
public class FactorialCalculator implements Callable<Integer> {

    Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        // calculate factorial
        long duration = (long)(Math.random()*5);
        System.out.printf("%s : Calculating factorial(%d) for %d seconds\n", Thread.currentThread().getId(), number,
                duration);
        int result=1;
        if (number == 0 || number == 1) {
            return 1;
        }
        for (int i = 1; i <= number; i++) {
            result *=i;
        }
        TimeUnit.SECONDS.sleep(duration);
        return result;
    }
}
