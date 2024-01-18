package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    class InsufficientFundsException extends Exception {}

    public synchronized void addAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep((int)(Math.random()*1000));
            //Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
        System.out.println("Balance changed: " + balance);
    }

    /**
     * An alternative implementation of debit/credit methods
     * from Doug Lee book
     * credit is equal to addAmount
     * Note: credit sum can be negative, than it is acting like debit
     * @param amount
     */
    public synchronized void credit (double amount) throws InsufficientFundsException {
        if (amount >= 0 || balance >= -amount) {
            balance += amount;
        } else
            throw new InsufficientFundsException();
        System.out.println("Balance changed: " + balance);
    }

    public synchronized  void debit(double amount) throws InsufficientFundsException {
        credit(-amount);
        System.out.println("Balance changed: " + balance);
    }

    public synchronized void subtractAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep((int)(Math.random()*1000));
            //Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
        System.out.println("Balance changed: " + balance);
    }
}
