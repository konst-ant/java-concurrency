package tmp;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Bank implements Runnable {

    Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.subtractAmount(1000);
        }
    }
}
