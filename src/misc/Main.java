package misc;

/**
 * Created by kantipin on 05.06.2016.
 */
public class Main {
    public static void main(String[] args) {
        BallWithLock ball = new BallWithLock();
        PingWithLock pingTask = new PingWithLock(ball);
        PongWithLock pongTask = new PongWithLock(ball);
        Thread pingThread = new  Thread(pingTask);
        Thread pongThread = new Thread(pongTask);
        pingThread.start();
        pongThread.start();
    }
}
