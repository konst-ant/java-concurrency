package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class ATMTask implements Runnable {
    Account account;

    public ATMTask(Account account) {
        this.account = account;
    }

    @Override
    /**
     * Note: subtractAmount()/addAmount() work with sleep() delay
     */
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtractAmount(500);
            /*try {
                account.debit(500);
            } catch (Account.InsufficientFundsException e) {
                e.printStackTrace();
            }*/
        }
    }
}
