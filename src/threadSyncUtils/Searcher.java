package threadSyncUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by kantipin on 24.04.2016.
 */
public class Searcher implements Runnable{

    int firstRow;
    int lastRow;
    MockMatrix matrix;
    int searchNumber;
    Results results;
    CyclicBarrier barrier;

    /*
     * @param firstRow - start row of the matrix (inclusive)
     * @param lastRow - last row of the matrix (exclusive)
     */
    public Searcher(int firstRow, int lastRow, MockMatrix matrix, int searchNumber, Results results,
                    CyclicBarrier
                    barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.matrix = matrix;
        this.searchNumber = searchNumber;
        this.results = results;
        this.barrier = barrier;
    }


    @Override
    public void run() {

        int totalCounter=0;
        for (int i=firstRow; i< lastRow; i++) {
            int counter=0;
            int[] row = matrix.getRow(i);
            for (int j=0; j<row.length; j++) {
                if (row[j] == searchNumber)
                    counter++;
            }
            totalCounter +=counter;
            results.setData(i, counter);
        }

        System.out.printf("%s: finished calculation [%d,%d), found %d occurences \n", Thread.currentThread().getName(),
                firstRow,
                lastRow, totalCounter);
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
