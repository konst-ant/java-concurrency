package misc;

/**
 * Created by kantipin on 05.06.2016.
 */
public class Main_PingPong {
    public static void main(String[] args) {
        Ball ball = new Ball();
        PingPong pingTask = new PingPong(ball, Ball.PING);
        PingPong pongTask = new PingPong(ball, Ball.PONG);
        Thread pingThread = new Thread(pingTask);
        Thread pongThread = new Thread(pongTask);
        pingThread.start();
        pongThread.start();
    }
}
