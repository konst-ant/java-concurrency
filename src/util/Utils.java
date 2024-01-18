package util;

import java.util.List;
import java.util.Random;

/**
 * Created by kantipin on 11.04.2016.
 */
public class Utils {

    public static void randomSleep() {
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T> void fairPermutate_bad(List<T> l) {
        Random random = new Random();
        // high index of distance for random select
        int b = l.size()-1;
        for(int i=0; i < b; i++) {
            // low index of distance for random select
            int a = i+1;
            int changeIndex = b-a > 0 ? a + random.nextInt(b-a) : a;
            T tmp = l.get(i);
            l.set(i, l.get(changeIndex));
            l.set(changeIndex, tmp);
            fairPermutate(l.subList(i+1, l.size() - 1));
        }
    }

    public static <T> void fairPermutate(List<T> l) {
        Random random = new Random();
        for (int i = l.size()-1; i > 0; i--) {
            int index = random.nextInt(i);
            T helper = l.get(i);
            l.set(i, l.get(index));
            l.set(index, helper);
        }
    }
}
