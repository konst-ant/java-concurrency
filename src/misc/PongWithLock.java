package misc;

/**
 * Created by kantipin on 05.06.2016.
 */
public class PongWithLock implements Runnable {
    BallWithLock ball;

    public PongWithLock(BallWithLock ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while(true) {
            ball.pongStrike();
        }
    }
}
