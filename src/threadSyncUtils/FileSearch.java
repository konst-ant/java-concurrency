package threadSyncUtils;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 11.05.2016.
 */
public class FileSearch implements Runnable{
    private String initPath;
    private String end;
    private List<String> results;
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        this.results = new ArrayList<String>();
    }

    private void directoryProcess(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory())
                    directoryProcess(f);
                else
                    fileProcess(f);
            }
        }
    }

    private void fileProcess(File file) {
        if (file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath());
        }
    }

    private void filterResults() {
        long before = (new Date()).getTime();
        List<String> newResults = new ArrayList<String>();

        for (String s: results) {
            File f = new File(s);
            if (before - f.lastModified() < TimeUnit.MICROSECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(s);
            }
        }
        results = newResults;
    }

    private boolean checkResults() {
        if (results.isEmpty()) {
            System.out.printf("%s : Phase(checkResults) %d: 0 results. End \n", Thread.currentThread().getName(), phaser
                    .getPhase
                            ());
            phaser.arriveAndDeregister();
            return false;
        } else {
            System.out.printf("%s: Phase(checkResults) %d: %d results\n", Thread.currentThread().getName(), phaser
                            .getPhase(),
                    results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    private void showInfo() {
        for (String r : results) {
            System.out.printf("%s: result: %s\n", Thread.currentThread().getName(), r);
        }
        System.out.printf("%s: Phase(showInfo) %d\n", Thread.currentThread().getName(), phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
    }


    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s Starting.\n", Thread.currentThread().getName());
        File f = new File(initPath);
        if (f.isDirectory()) {
            directoryProcess(f);
        }

        if (!checkResults())
            return;

        filterResults();

        if (!checkResults())
            return;

        showInfo();
        phaser.arriveAndDeregister();
        System.out.printf("%s: Work completed\n", Thread.currentThread().getName());

    }
}
