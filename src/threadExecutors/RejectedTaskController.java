package threadExecutors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kantipin on 20.05.2016.
 */
public class RejectedTaskController implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskController: The task %s was rejected by executor %s\n", r.toString(), executor
                .toString());
        System.out.printf("RejectedTaskController: Executor terminating %s\n", executor.isTerminating());
        System.out.printf("RejectedTaskController: Executor terminated %s\n", executor.isTerminated());
    }
}
