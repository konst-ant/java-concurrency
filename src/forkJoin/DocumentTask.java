package forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kantipin on 21.05.2016.
 */
public class DocumentTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID=1L;

    private String document[][];
    private int start;
    private int end;
    private String searchWord;

    public DocumentTask(String[][] document, int start, int end, String searchWord) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.searchWord = searchWord;
    }

    @Override
    protected Integer compute() {
        int result=0;

        if (end-start <10) {
            result = processLines(document, start, end, searchWord);
        } else {
            int middle = (end + start)/2;
            DocumentTask task1 = new DocumentTask(document, start, middle+1, searchWord);
            DocumentTask task2 = new DocumentTask(document, middle+1, end, searchWord);
            invokeAll(task1, task2);

            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException |ExecutionException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    private int processLines(String[][] document, int start, int end, String searchWord) {
        int result = 0;
        List<LineTask> tasks = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String[] line = document[i];
            LineTask  task = new LineTask(line, 0, line.length, searchWord);
            tasks.add(task);
        }
        invokeAll(tasks);

        try {
            for (LineTask task : tasks) {
                Integer r = task.get();
                result += r;
            }
        } catch (InterruptedException |ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int groupResults(int res1, int res2) {
        return res1 + res2;
    }
}
