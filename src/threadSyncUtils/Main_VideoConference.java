package threadSyncUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 21.04.2016.
 */
public class Main_VideoConference {
    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);

        Thread conferenceThread = new Thread(conference, "VideoConference");
        conferenceThread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            Thread participant = new Thread(new Participant(conference, "Participant"+i), "Participant"+i);
            participant.start();
        }

    }
}
