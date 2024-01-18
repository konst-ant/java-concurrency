package threadSyncUtils;

import java.util.Random;

/**
 * Created by kantipin on 24.04.2016.
 */
public class MockMatrix {

    private int[][] data;
    int counter;

    public MockMatrix(int size, int length, int  searchNumber) {
        data = new int[size][length];
        counter=0;

        Random random = new Random();
        for(int i=0; i<size; i++) {
            for (int j=0; j<length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == searchNumber)
                    counter++;
            }
        }
        System.out.printf("MockMatrix: built matrix of (%d/%d), %d number is appearing inside %d times\n", size,
                length, searchNumber, counter);
    }

    int[] getRow(int index) {
        if (index>= 0 && index<data.length) {
            return data[index];
        }
        return null;
    }
}
