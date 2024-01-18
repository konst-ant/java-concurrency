package misc;

/**
 * Created by kantipin on 05.06.2016.
 */
public class PingWithLock implements Runnable {
    BallWithLock ball;

    public PingWithLock(BallWithLock ball) {
        this.ball = ball;
    }

    @Override
    public void run() {
        while(true) {
            ball.pingStrike();
        }
    }
}
