package threadSyncUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by kantipin on 24.04.2016.
 */
public class Main_CyclicBarrier {

    public final static int PARTICIPANTS = 5;
    public final static int SEARCHNUMBER = 5;
    public final static int ROWS = 10000;
    public final static int COLUMNS = 1000;
    public final static int CHUNCKSIZE = 2000;
    public final static CountDownLatch mainBlocker=new CountDownLatch(1);


    public static void main(String[] args) {

        MockMatrix matrix = new MockMatrix(ROWS, COLUMNS, SEARCHNUMBER);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results,SEARCHNUMBER, mainBlocker);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        for (int i=0; i<PARTICIPANTS; i++) {
            Searcher searcher = new Searcher(i*CHUNCKSIZE, (i+1)*CHUNCKSIZE, matrix,SEARCHNUMBER,results,
                    barrier);
            Thread searcherThread = new Thread(searcher);
            searcherThread.start();
        }
        try {
            mainBlocker.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: finished.\n");
    }
}
