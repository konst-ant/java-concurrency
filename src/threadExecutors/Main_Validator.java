package threadExecutors;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kantipin on 18.05.2016.
 */
public class Main_Validator {
    public static void main(String[] args) {
        String user = "test";
        String password = "test";
        UserValidator validator1 = new UserValidator("LDAP");
        UserValidator validator2 = new UserValidator("DataBase");
        TaskValidator task1 = new TaskValidator(validator1, user, password);
        TaskValidator task2 = new TaskValidator(validator2, user, password);
        List<TaskValidator> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);


        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        String result;
        try {
            result = executor.invokeAny(tasks);
            System.out.printf("Main : Validation result %s\n", result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
