package threadSynchronization;

/**
 * Created by kantipin on 13.04.2016.
 */
public class PriceReader implements Runnable {
    PriceInfo info;

    public PriceReader(PriceInfo info) {
        this.info = info;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Thread %s : price1 %s\n", Thread.currentThread().getId(),  info.getPrice1());
            System.out.printf("Thread %s : price2 %s\n", Thread.currentThread().getId(),  info.getPrice2());
        }
    }
}
