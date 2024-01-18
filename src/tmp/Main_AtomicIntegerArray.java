package tmp;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by kantipin on 28.05.2016.
 */
public class Main_AtomicIntegerArray {
    public static void main(String[] args) {
        AtomicIntegerArray vector = new AtomicIntegerArray(1000);

        int THREADS = 100;

        Incrementer i = new Incrementer(vector);
        Decrementer d = new Decrementer(vector);
        Thread ti[] = new Thread[THREADS];
        Thread td[] = new Thread[THREADS];

        for (int j = 0; j <THREADS; j++) {
            ti[j] = new Thread(i);
            td[j] = new Thread(d);

            ti[j].start();
            td[j].start();
        }

        for (int j = 0; j < THREADS; j++) {
            try {
                ti[j].join();
                td[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int j = 0; j < 1000; j++) {
            if (vector.get(j) != 0) {
                System.out.printf("Waw! inconsistency: %d element of AtomicIntegerArray not null: %d\n", j, vector.get(j));
            }
        }
        System.out.printf("Main: finished.\n");
    }
}
