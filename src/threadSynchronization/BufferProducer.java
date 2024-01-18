package threadSynchronization;

/**
 * Created by kantipin on 19.04.2016.
 */
public class BufferProducer implements  Runnable{
    FileMock file;
    Buffer buffer;

    BufferProducer(FileMock file, Buffer buffer) {
        this.file = file;
        this.buffer = buffer;
    }


    @Override
    public void run() {
        buffer.setPendingLines(true);
        while(file.hasMoreLines()) {
            buffer.insert(file.getLine());
        }
        buffer.setPendingLines(false);
    }
}
