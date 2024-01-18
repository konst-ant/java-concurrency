package threadExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 18.05.2016.
 */
public class Task2 implements Callable<Result> {

    String name;

    public Task2(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("Task : %s starting\n", name);

        try {
            TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value=0;
        for (int i = 0; i < 5; i++) {
            value += (int)(Math.random()*100);
        }

        Result result = new Result();
        result.setName(name);
        result.setValue(value);
        System.out.printf("Task : %s finished\n", name);
        return result;
    }

}
