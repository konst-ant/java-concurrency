package threadExecutors;

import java.util.concurrent.CompletionService;

/**
 * Created by kantipin on 20.05.2016.
 */
public class ReportRequest implements Runnable {

    static int GENERATOR_COUNTER = 0;
    String reportName;
    CompletionService<String> service;

    public ReportRequest(String reportName, CompletionService<String> service) {
        this.reportName = reportName;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator generator = new ReportGenerator("generator"+ (++GENERATOR_COUNTER), reportName);
        service.submit(generator);
    }
}
