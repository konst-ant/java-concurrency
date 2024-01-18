package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class CompanyTask implements Runnable {
    Account account;

    public CompanyTask(Account account) {
        this.account = account;
    }

    @Override
    /**
     * Note: subtractAmount()/addAmount() work with sleep() delay
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.addAmount(1000);
            /*try {
                account.credit(1000);
            } catch (Account.InsufficientFundsException e) {
                e.printStackTrace();
            }*/
        }
    }
}
