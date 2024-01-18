package threadSyncUtils;

/**
 * Created by kantipin on 24.04.2016.
 */
public class Results {

    int[] results;

    public Results(int size) {
        results = new int[size];
    }

    public void setData(int index, int value) {
        results[index] =  value;
    }

    public int[] getData() {
        return results;
    }
}
