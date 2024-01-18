package misc;

/**
 * Created by kantipin on 05.06.2016.
 */
public class PingPong implements Runnable {
    private Ball ball;
    int side;

    public PingPong(Ball ball, int side) {
        this.ball = ball;
        this.side = side;
    }

    public void run() {
        while (true) {
            ball.strike(side);

        }
    }
}
