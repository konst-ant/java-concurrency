package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Main_Cinema {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        TicketOffice1 task1 = new TicketOffice1(cinema);
        TicketOffice2 task2 = new TicketOffice2(cinema);

        Thread thread1 = new Thread(task1, "Office1");
        Thread thread2 = new Thread(task2, "Office2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("After all celling/return the number of vacancies: " + cinema.getVacanciesCinema1() + " "
                + cinema.getVacanciesCinema2());
    }
}
