package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Main_Account {
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        ATMTask atmTask = new ATMTask(account);
        CompanyTask companyTask = new CompanyTask(account);

        Thread atmThread = new Thread(atmTask, "ATM");
        Thread companyThread = new Thread(companyTask, "Company");

        atmThread.start();
        companyThread.start();

        try {
            companyThread.join();
            atmThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The balance of amount after all transactions: " + account.getBalance());

    }
}
