package threadExecutors;

import java.util.concurrent.*;

/**
 * Created by kantipin on 20.05.2016.
 */
public class Main_CompletionService {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        CompletionService<String> service = new ExecutorCompletionService<String>(executor);

        ReportRequest faceRequest = new ReportRequest("Face", service);
        ReportRequest onlineRequest = new ReportRequest("Online", service);
        Thread faceThread = new Thread(faceRequest);
        Thread onlineThread = new Thread(onlineRequest);

        ReportProcessor processor = new ReportProcessor(service);
        Thread processorThread = new Thread(processor);

        System.out.printf("Starting threads for ReportRequest (2 threads) and ReportProcessor (1 thread)\n");
        faceThread.start();
        onlineThread.start();
        processorThread.start();

        try {
            System.out.printf("Waiting for ReportRequest threads to complete\n");
            faceThread.join();
            onlineThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Shutting down executor and awaiting completion of executor tasks\n");
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
            // sleep here just to be on safe ground ReportGenerator has obtained last report
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Shutting down ReportProcessor\n");
        processor.setFinish(true);
        try {
            processorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main end.\n");
    }
}
