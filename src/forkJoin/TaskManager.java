package forkJoin;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinTask;

/**
 * Created by kantipin on 22.05.2016.
 */
public class TaskManager {
    List<ForkJoinTask<Integer>> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<ForkJoinTask<Integer>>();
    }

    public void addTask(ForkJoinTask task) {
        tasks.add(task);
    }

    public void cancelTasks(ForkJoinTask succeededTask) {
        for (ForkJoinTask task: tasks) {
            if (task != succeededTask) {
                task.cancel(true);
                ((SearchNumberTask)task).writeCancelMessage();
            }
        }
    }
}
