package tmp;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Main_AtomicVariables {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        System.out.printf("Initial account balance: %d\n", account.getBalance());

        Company c = new Company(account);
        Bank b = new Bank(account);

        Thread bThread = new Thread(b);
        Thread cThread = new Thread(c);
        bThread.start();
        cThread.start();

        try {
            bThread.join();
            cThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Ultimate account balance: %d\n", account.getBalance());
    }
}
