package forkJoin;

import java.util.Random;

/**
 * Created by kantipin on 22.05.2016.
 */
public class ArrayGenerator {
    public static int[] generateArray(int size) {
        int result[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt(10);
        }
        return result;
    }
}
