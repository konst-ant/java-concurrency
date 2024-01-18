package threadSyncUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 21.04.2016.
 */
public class Participant implements Runnable {
    VideoConference conference;
    String name;

    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            long duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s: joining the conference\n", Thread.currentThread().getName(), name);
        conference.arrive(name);
    }
}
