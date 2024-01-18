package threadSynchronization;

/**
 * Created by kantipin on 13.04.2016.
 */
public class PriceWriter implements Runnable {
    PriceInfo info;
    
    public PriceWriter(PriceInfo info) {
        this.info=info;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            double price1 = Math.round(Math.random()*5);
            double price2 = Math.round(Math.random()*10);

            System.out.printf("Thread %s : going to set new prices (%s %s)\n", Thread.currentThread().getId(),
                    price1, price2);
            info.setPrices(price1, price2);
            System.out.printf("Thread %s : prices has been modified\n", Thread.currentThread().getId());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
