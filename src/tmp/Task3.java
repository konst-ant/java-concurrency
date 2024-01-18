package tmp;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by kantipin on 27.05.2016.
 */
public class Task3 implements Runnable {
    
    ConcurrentSkipListMap<String, Contact> map;
    char id;

    public Task3(ConcurrentSkipListMap<String, Contact> map, char id) {
        this.map = map;
        this.id = id;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            String phone = String.format("%02d0-0%03d", Character.getNumericValue(id), i);
            Contact contact = new Contact(id + "-" + i, phone);
            // Note : id will be sorted lexicographically
            map.put(id + "-" + String.format("%03d", i), contact);
        }
    }
}
