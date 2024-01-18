package threadSyncUtils;

import java.util.concurrent.Phaser;

/**
 * Created by kantipin on 12.05.2016.
 */
public class Main_FileSearch {

    public static void main(String[] args) {
        // argument to phaser - is the number of participant threads!
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("c:\\home", "txt", phaser);
        FileSearch app = new FileSearch("c:\\program files", "txt", phaser);
        FileSearch docs = new FileSearch("c:\\documents and settings", "txt", phaser);

        Thread systemThread = new Thread(system, "home");
        Thread appThread = new Thread(app, "program files");
        Thread docsThread = new Thread(docs, "documents and settings");

        systemThread.start();
        appThread.start();
        docsThread.start();

        try {
            systemThread.join();
            appThread.join();
            docsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminated: " +  phaser.isTerminated());
    }
}
