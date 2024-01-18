package threadExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by kantipin on 19.05.2016.
 */
public class MyFutureTask extends FutureTask<String> {

    String name;

    public MyFutureTask(Callable<String> callable) {
        super(callable);
        this.name = ((CallableTask)callable).getName();
    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("MyFutureTask: task %s was canceled\n", name);
        } else {
            System.out.printf("MyFutureTask: task %s was executed\n", name);
        }
    }
}
