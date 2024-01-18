package misc;

/**
 * Created by kantipin on 05.06.2016.
 */
public class Ball {
    public static final int PING =1;
    public static final int PONG=-1;

    private int side;

    public Ball() {
        side=PING;
    }

    public synchronized void strike(int strikingSide) {
        // wait till the ball is on my side
        while (this.side != strikingSide) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // strike it!
        System.out.printf("%s\n", strikingSide==Ball.PING ? "PIIIING" : "PONG");
        side=-side;
        notify();
    }

}
