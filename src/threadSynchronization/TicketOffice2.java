package threadSynchronization;

import util.Utils;

/**
 * Created by kantipin on 11.04.2016.
 */
public class TicketOffice2 implements Runnable{
    private Cinema cinema;

    public TicketOffice2(Cinema cinema) {
        this.cinema = cinema;
    }


    @Override
    /**
     * total balance for sellTickets1() -8
     * total balance for sellTickets2() -6
     */
    public void run() {
        cinema.sellTickets2(2);
        cinema.sellTickets2(4);
        Utils.randomSleep();
        cinema.sellTickets1(2);
        Utils.randomSleep();
        cinema.sellTickets1(1);
        Utils.randomSleep();
        cinema.returnTickets2(2);
        Utils.randomSleep();
        cinema.sellTickets1(3);
        cinema.sellTickets2(2);
        Utils.randomSleep();
        cinema.sellTickets1(2);
    }
}
