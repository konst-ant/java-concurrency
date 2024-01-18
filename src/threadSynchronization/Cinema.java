package threadSynchronization;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1;
    private final Object controlCinema2;

    public Cinema() {
        vacanciesCinema1 = 20;
        vacanciesCinema2 = 20;
        controlCinema1 = new Object();
        controlCinema2 = new Object();
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }

    public boolean sellTickets1(long amount) {
        synchronized (controlCinema1) {
            if (amount < vacanciesCinema1) {
                vacanciesCinema1 -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets2(long amount) {
        synchronized (controlCinema2) {
            if (amount < vacanciesCinema2) {
                vacanciesCinema2 -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

    public void returnTickets1(long amount) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += amount;
        }
    }

    public void returnTickets2(long amount) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += amount;
        }
    }
}
