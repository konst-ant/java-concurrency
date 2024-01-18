package threads;

import java.io.File;

/**
 * Created by KAntipin on 29.03.2016.
 */
public class InterruptionTask2 implements Runnable {
    File path;
    String fileName;

    InterruptionTask2(File path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public void run() {
        if (path.isDirectory()) {
            try {
                processDirectory(path);
            } catch (InterruptedException e) {
                System.out.println("The search has been interrupted " + Thread.currentThread().getName());
            }
        }

    }

    private void processDirectory (File path) throws InterruptedException {
        File list[] = path.listFiles();
        //Thread.sleep(10);
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    processDirectory(list[i]);
                } else {
                    processFile(list[i]);
                }
            }
        }

        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    private void processFile (File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.println("Found file " + file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
