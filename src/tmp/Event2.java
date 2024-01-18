package tmp;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by kantipin on 25.05.2016.
 */
public class Event2 implements Delayed {

    private Date startDate;

    public Event2(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public int compareTo(Delayed e) {

        long diff = getDelay(TimeUnit.NANOSECONDS) - e.getDelay(TimeUnit.NANOSECONDS);
        if (diff < 0) {
            return -1;
        } else if (diff > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        return unit.convert(startDate.getTime() - now.getTime(), TimeUnit.MILLISECONDS);
    }
}
