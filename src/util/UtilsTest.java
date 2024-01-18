package util;

import java.util.Arrays;

/**
 * Created by kantipin on 14.07.2016.
 */
public class UtilsTest {

    public void testFairPermutate() throws Exception {
        Integer list[] = {3, 2, 24, 1, 15, 5};
        //Integer list[] = {1,2};
        System.out.printf("List before permutation: %s\n", Arrays.toString(list));
        Utils.fairPermutate(Arrays.asList(list));
        System.out.printf("List after permutation: %s\n", Arrays.toString(list));
    }
}