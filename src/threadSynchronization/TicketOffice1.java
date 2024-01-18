package threadSynchronization;

import util.Utils;

/**
 * Created by kantipin on 11.04.2016.
 */
public class TicketOffice1 implements Runnable{
    private Cinema cinema;

    public TicketOffice1(Cinema cinema) {
        this.cinema = cinema;
    }


    @Override
    /**
     * total balance for sellTickets1() -7
     * total balance for sellTickets2() -8
     */
    public void run() {
        cinema.sellTickets1(3);
        Utils.randomSleep();
        cinema.sellTickets1(2);
        cinema.sellTickets2(2);
        Utils.randomSleep();
        cinema.returnTickets1(3);
        Utils.randomSleep();
        cinema.sellTickets1(5);
        cinema.sellTickets2(2);
        Utils.randomSleep();
        cinema.sellTickets2(2);
        cinema.sellTickets2(2);
    }
}
