package threadSynchronization;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kantipin on 13.04.2016.
 */
public class PriceInfo {
    private double price1;
    private double price2;

    private ReadWriteLock priceLock;

    public PriceInfo() {
        priceLock = new ReentrantReadWriteLock();
        this.price1=1.0;
        this.price2=2.0;
    }

    public void setPrices(double price1, double price2) {
        priceLock.writeLock().lock();
        this.price1=price1;
        this.price2=price2;
        priceLock.writeLock().unlock();
    }

    public double getPrice1() {
        double result;
        priceLock.readLock().lock();
        result = price1;
        priceLock.readLock().unlock();
        return result;
    }

    public double getPrice2() {
        double result;
        priceLock.readLock().lock();
        result = price2;
        priceLock.readLock().unlock();
        return result;
    }

}
