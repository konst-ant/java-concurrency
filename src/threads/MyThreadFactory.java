package threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by kantipin on 11.04.2016.
 */
public class MyThreadFactory implements ThreadFactory {
    int count;
    String baseName;
    List<String> stats;

    public MyThreadFactory(String baseName) {
        this.baseName=baseName;
        count=0;
        stats = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, baseName+"_thread_#" + count);
        stats.add(String.format("Thread %s number %d was started at %s", t.getName(), count, new Date().toString()));
        count++;
        return t;
    }

    public String getStatistics() {
        StringBuffer result = new StringBuffer();
        for (String s : stats) {
            result.append(s);
            result.append("\n");
        }
        return result.toString();
    }

    public int getCount() {return count;}
}
