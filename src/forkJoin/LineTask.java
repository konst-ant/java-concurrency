package forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * Created by kantipin on 22.05.2016.
 */
public class LineTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID=1L;

    String[] line;
    int start;
    int end;
    String searchWord;

    public LineTask(String[] line, int start, int end, String searchWord) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.searchWord = searchWord;
    }

    @Override
    protected Integer compute() {
        int result=0;

        if (end - start < 10) {
            result = processWords(line, start, end, searchWord);
        } else {
            int middle = (end + start)/2;
            LineTask task1 = new LineTask(line, start, middle + 1, searchWord);
            LineTask task2 = new LineTask(line, middle +1, end, searchWord);
            invokeAll(task1, task2);

            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException| ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private int processWords(String[] line, int start, int end, String searchWord) {
        int result=0;
        for (int i = start; i <end; i++) {
            if(searchWord.equals(line[i])) {
                result++;
            }
        }
        return result;
    }

    private int groupResults(int res1, int res2) {
        return res1 + res2;
    }
}
