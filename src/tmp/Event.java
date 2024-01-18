package tmp;

/**
 * Created by kantipin on 24.05.2016.
 */
public class Event implements Comparable<Event> {

    private int priority;
    private String threadName;

    public Event(int priority, String threadName) {
        this.priority = priority;
        this.threadName = threadName;
    }

    public int getPriority() {
        return priority;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public int compareTo(Event o) {
        // Note: here we return -1 if this object is 'bigger' than the argument, to make objects with bigger priority
        // go first. This is opposit to typical implementation of compareTo() method
        if (this.priority > o.priority) {
            return -1;
        } else if (this.priority == o.priority) {
            return 0;
        }
        return 1;
    }
}
