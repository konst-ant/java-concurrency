package forkJoin;

import java.util.Random;

/**
 * Created by kantipin on 21.05.2016.
 */
public class Document {
    static private String[] words = {"one",  "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

    static public String[][] generateDocument(int numLines, int numCols, String searchWord) {
        String[][] document = new String[numLines][numCols];
        int counter=0;
        Random random = new Random();
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numCols; j++) {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (words[index].equals(searchWord)) {
                    counter++;
                }
            }
        }
        System.out.printf("Document: generated doc with %d occurencies of search word (%s)\n", counter, searchWord);
        return document;
    }
}
