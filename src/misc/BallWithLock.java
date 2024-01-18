package misc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kantipin on 05.06.2016.
 */
public class BallWithLock {
    private final static int PING =1;
    private final static int PONG=-1;
    int side;
    Lock lock;
    Condition ping;
    Condition pong;


    public BallWithLock() {
        side = 1;
        this.lock = new ReentrantLock();
        ping = lock.newCondition();
        pong = lock.newCondition();
    }

    public void pingStrike() {
        lock.lock();
        try {
            while (side != PING) {
                ping.await();
            }
            System.out.printf("PING\n");
            side = -side;
            pong.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void pongStrike() {
        try {
            lock.lock();
            while(side != PONG) {
                pong.await();
            }
            System.out.printf("POOOONG\n");
            side=-side;
            ping.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
