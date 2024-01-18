package threadExecutors;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 20.05.2016.
 */
public class ReportProcessor implements Runnable {
    private CompletionService<String> service;
    private boolean finish;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        finish = false;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    @Override
    public void run() {
        while (!finish) {
            try {
                Future<String> future = service.poll(5, TimeUnit.SECONDS);
                if (future != null) {
                    String report = future.get();
                    System.out.printf("ReportProcessor: received report: %s\n", report);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportProcessor: finished processing\n");
    }
}