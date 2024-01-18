package threadExecutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kantipin on 17.05.2016.
 */
public class Server {
    ThreadPoolExecutor executor;

    public Server() {
        //executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }

    public void executeTask(Task task){
        System.out.printf("Server: a new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server : pool size : %d\n", executor.getPoolSize());
        System.out.printf("Server : active count : %d\n", executor.getActiveCount());
        System.out.printf("Server : completed tasks : %d\n", executor.getCompletedTaskCount());
        System.out.printf("Server : maximum pool size ever happened : %d\n", executor.getLargestPoolSize());
        System.out.printf("Server : task count : %d\n", executor.getTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}
