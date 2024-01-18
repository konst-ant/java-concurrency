package threadSynchronization;

/**
 * Created by kantipin on 19.04.2016.
 */
public class Main {
    
    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        BufferProducer prod = new BufferProducer(mock, buffer);
        Thread prodThread = new Thread(prod, "Producer");
        BufferConsumer cons[] = new BufferConsumer[3];
        Thread[] consThread = new Thread[3];

        for (int i = 0; i < 3; i++) {
            cons[i] = new BufferConsumer(buffer);
            consThread[i] =  new Thread(cons[i], "Consumer" + i);
        }

        prodThread.start();
        System.out.printf("Started thread %s\n", prodThread.getName());
        for (int i = 0; i < 3; i++) {
            consThread[i].start();
            System.out.printf("Started thread %s\n", consThread[i].getName());
        }
    }
    
    
}
