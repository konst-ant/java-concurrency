package threadExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 20.05.2016.
 */
public class ReportGenerator implements Callable<String> {

    String generatorName;
    String reportName;

    public ReportGenerator(String generatorName, String reportName) {
        this.generatorName = generatorName;
        this.reportName = reportName;
    }

    @Override
    public String call() throws Exception {
        long duration = (long)(Math.random()*10);
        System.out.printf("ReportGenerator %s : going to generate report for %d seconds\n", generatorName, duration);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String report = String.format("Report : %s produced by generator : %s.", reportName, generatorName);
        return report;
    }
}
