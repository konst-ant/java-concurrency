package threadSynchronization;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kantipin on 19.04.2016.
 */
public class Buffer {
    LinkedList<String> buffer;
    int maxSize;

    Lock lock;
    Condition space;
    Condition lines;
    boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock(true);
        space = lock.newCondition();
        lines = lock.newCondition();
        pendingLines = true;
    }

    public void insert(String line) {
        try {
            lock.lock();
            while (buffer.size() == maxSize) {
                space.await();
            }

            buffer.offer(line);
            System.out.printf("Thread %s inserted line %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String result = null;
        try {
            lock.lock();
            while(buffer.size() == 0 && hasPendingLines()) {
                lines.await();
            }
            buffer.poll();
            System.out.printf("Thread %s read line %d\n", Thread.currentThread().getName(), buffer.size());
            space.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    public boolean hasPendingLines() {
        return pendingLines || buffer.size() > 0;
    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }
}
