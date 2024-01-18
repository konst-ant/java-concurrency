package tmp;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Company implements Runnable {

    Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            account.addAmount(1000);
        }
    }
}

