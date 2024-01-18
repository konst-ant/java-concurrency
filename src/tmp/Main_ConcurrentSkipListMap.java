package tmp;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by kantipin on 27.05.2016.
 */
public class Main_ConcurrentSkipListMap {
    public static void main(String[] args) {
        ConcurrentSkipListMap<String, Contact> map = new ConcurrentSkipListMap<String, Contact>();
        Thread threads[] = new Thread[25];

        int counter=0;
        for (char i = 'A'; i < 'Z'; i++) {
            Task3 task = new Task3(map, i);
            Thread thread = new Thread(task);
            threads[counter] = thread;
            thread.start();
            counter++;
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("map size: %s\n", map.size());

        Map.Entry entry = map.firstEntry();
        System.out.printf("Main: first entry of map key=%s, phone=%s\n", entry.getKey(), ((Contact) entry.getValue()).getPhone());
        entry = map.lastEntry();
        System.out.printf("Main: first entry of map key=%s, phone=%s\n", entry.getKey(), ((Contact)entry.getValue()).getPhone());

        ConcurrentNavigableMap<String, Contact> submap = map.subMap("C-567","F-5");
        System.out.printf("Printing out entries of the map in key range: C-567 : F-5\n");;
        for (Map.Entry e: submap.entrySet()) {
            Contact contact = (Contact)e.getValue();
            System.out.printf("Main: submap entry key=%s, name=%s, value=%s\n", e.getKey(), contact.getName(), contact.getPhone());
        }
    }
}
