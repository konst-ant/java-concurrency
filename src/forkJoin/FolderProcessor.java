package forkJoin;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 * Created by kantipin on 22.05.2016.
 */
public class FolderProcessor extends RecursiveTask<List<String>> {

    String path;
    String extension;

    public FolderProcessor(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    protected List<String> compute() {
        List<String> matches = new ArrayList<>();
        List<FolderProcessor> tasks = new ArrayList<>();

        File file = new File(path);
        File[] child = file.listFiles();
        if (child != null) {
            for (int i = 0; i < child.length; i++) {
                if (child[i].isDirectory()) {
                    FolderProcessor task = new FolderProcessor(child[i].getAbsolutePath(), extension);
                    tasks.add(task);
                    task.fork();
                } else {
                    if (checkFile(child[i].getName())) {
                        matches.add(child[i].getAbsolutePath());
                    }
                }
            }
        }

        if (tasks.size() > 50) {
            System.out.printf("FolderProcessor: More than 50 tasks were started for (sub)folder %s\n", file
                    .getAbsolutePath
                    ());
        }

        // join all results
        addResultsFromTasks(matches, tasks);


        return matches;
    }

    private void addResultsFromTasks(List<String> matches, List<FolderProcessor> tasks) {
        for (FolderProcessor item : tasks) {
            matches.addAll(item.join());
        }
    }

    private boolean checkFile(String name) {
        if (name.endsWith(extension)) {
            return true;
        } else {
            return false;
        }
    }
}
