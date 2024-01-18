package threadExecutors;

/**
 * Created by kantipin on 17.05.2016.
 */
public class Main_Executor {
    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task"+ i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
